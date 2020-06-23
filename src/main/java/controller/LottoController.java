package controller;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lotto.Lotto;
import lotto.LottoMoney;
import lotto.amount.LottoAmount;
import lotto.number.LottoNumber;
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

		outputView.showPurchasedLotto(lottoAmount, lottos);

		inputView.winningLotto();
		inputView.bonusNumber();

		outputView.showWinningStatistics();
		outputView.showProfit();
	}

	private List<Lotto> readManualLottoNumbers(LottoAmount lottoAmount) {
		List<Lotto> lottos = new ArrayList<>();

		while (lottoAmount.hasNext()) {
			lottos.add(
				inputView.manualLotto()
					.stream()
					.map(LottoNumber::valueOf)
					.collect(Collectors.collectingAndThen(toList(), Lotto::new))
			);
			lottoAmount.next();
		}

		return lottos;
	}
}
