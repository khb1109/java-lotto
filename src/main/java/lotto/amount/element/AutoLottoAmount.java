package lotto.amount.element;

import lotto.LottoMoney;

public class AutoLottoAmount extends Amount {
	public AutoLottoAmount(int amount) {
		super(amount);
	}

	public static AutoLottoAmount of(ManualLottoAmount manualLottoAmount, LottoMoney lottoMoney) {
		return new AutoLottoAmount(lottoMoney.calculateRemainderAmount(manualLottoAmount));
	}
}
