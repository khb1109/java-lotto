package controller;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import domain.LottoManager;
import domain.amount.LottoAmount;
import domain.amount.LottoMoney;
import domain.lotto.Lotto;
import domain.lotto.LottoFactory;
import domain.lotto.WinningLotto;
import domain.lotto.number.LottoNumber;
import domain.statistics.Rank;
import view.InputView;
import view.OutputView;

public class LottoController {
	private final InputView inputView;
	private final OutputView outputView;

	public LottoController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void run() {
		LottoMoney lottoMoney = new LottoMoney(inputView.lottoMoney());
		LottoAmount lottoAmount = LottoAmount.valueOf(lottoMoney, inputView.manualLottoAmount());

		outputView.showManualLotto();
		List<Lotto> lottos = readManualLottoNumbers(lottoAmount);
		lottos.addAll(buyAutoLottos(lottoAmount));
		outputView.showPurchasedLotto(lottoAmount, lottos);

		WinningLotto winningLotto = readWinningLotto();

		LottoManager lottoManager = new LottoManager(lottos, winningLotto);
		Map<Rank, Integer> countByRank = lottoManager.calculateRanks();

		outputView.showWinningStatistics(countByRank);
		outputView.showProfit(lottoManager.calculateProfit(countByRank, lottoMoney));
	}

	private List<Lotto> readManualLottoNumbers(LottoAmount lottoAmount) {
		List<Lotto> lottos = new ArrayList<>();

		while (lottoAmount.hasNext()) {
			lottos.add(
				inputView.manualLotto()
					.stream()
					.map(LottoNumber::valueOf)
					.collect(collectingAndThen(toList(), Lotto::new))
			);
			lottoAmount.next();
		}

		return lottos;
	}

	private List<Lotto> buyAutoLottos(LottoAmount lottoAmount) {
		return LottoFactory.createLotto(lottoAmount, Collections::shuffle);
	}

	private WinningLotto readWinningLotto() {
		Lotto lottoNumbers = inputView.winningLotto().stream()
			.map(LottoNumber::valueOf)
			.collect(collectingAndThen(toList(), Lotto::new));

		LottoNumber bonusNumber = LottoNumber.valueOf(inputView.bonusNumber());

		return new WinningLotto(lottoNumbers, bonusNumber);
	}
}
