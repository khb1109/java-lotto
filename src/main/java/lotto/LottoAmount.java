package lotto;

import java.util.Objects;

public class LottoAmount {
	private final int amount;

	public LottoAmount(Long money) {
		validate(money);
		this.amount = (int)(money / 1000);
	}

	private void validate(Long amount) {
		Objects.requireNonNull(amount, "amount는 null이 올 수 없습니다.");
		if (amount < 1000) {
			throw new IllegalArgumentException("로또를 구매할 비용이 부족합니다. amount=" + amount);
		}
	}

	public int getAmount() {
		return amount;
	}
}
