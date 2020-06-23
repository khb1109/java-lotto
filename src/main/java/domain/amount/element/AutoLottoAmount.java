package domain.amount.element;

import java.util.Objects;

import domain.amount.LottoMoney;

public final class AutoLottoAmount extends Amount {
	public AutoLottoAmount(int amount) {
		super(amount);
	}

	public static AutoLottoAmount of(ManualLottoAmount manualLottoAmount, LottoMoney lottoMoney) {
		Objects.requireNonNull(manualLottoAmount);
		Objects.requireNonNull(lottoMoney);
		return new AutoLottoAmount(lottoMoney.calculateRemainderAmount(manualLottoAmount));
	}
}
