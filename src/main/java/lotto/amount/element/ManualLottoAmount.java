package lotto.amount.element;

import lotto.LottoMoney;

public final class ManualLottoAmount extends Amount {
	public ManualLottoAmount(int amount) {
		super(amount);
	}

	public static ManualLottoAmount of(int manualAmount, LottoMoney lottoMoney) {
		if (lottoMoney.isExcessLottoAmount(manualAmount)) {
			throw new IllegalArgumentException(
				"수동로또 구매 갯수가 금액을 초과했습니다. LottoMoney" + lottoMoney + " manualLottoAmount=" + manualAmount);
		}
		return new ManualLottoAmount(manualAmount);
	}
}
