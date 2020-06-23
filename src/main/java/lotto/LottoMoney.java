package lotto;

import lotto.amount.element.ManualLottoAmount;

public class LottoMoney {
	private final long amount;

	public LottoMoney(long amount) {
		validate(amount);
		this.amount = amount;
	}

	private void validate(long amount) {
		if (amount < 1000) {
			throw new IllegalArgumentException("로또의 금액은 1000원 이상이 필요합니다. amount=" + amount);
		}
	}

	public boolean isExcessLottoAmount(int amount) {
		return calculateLottoAmount() < amount;
	}

	public int calculateRemainderAmount(ManualLottoAmount manualLottoAmount) {
		return manualLottoAmount.minus(calculateLottoAmount()) * -1;
	}

	private int calculateLottoAmount() {
		return (int)(amount / 1000);
	}
}
