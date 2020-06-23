package controller;

import lotto.LottoMoney;
import lotto.amount.LottoAmount;
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
		// for (int i = 0; i < lottoAmount; i++) {
		// 	List<Integer> integers = inputView.manualLotto();
		// }

		outputView.showPurchasedLotto();

		inputView.winningLotto();
		inputView.bonusNumber();

		outputView.showWinningStatistics();
		outputView.showProfit();
	}
}
