package lotto.amount;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.LottoMoney;

class LottoAmountTest {
	@DisplayName("수동 티켓 가격이 구매가격보다 크면 에러가 발생한다.")
	@Test
	void name() {
		assertThatThrownBy(() -> LottoAmount.valueOf(new LottoMoney(1000), 2))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("수동로또 구매 갯수가 금액을 초과했습니다.");
	}

}

// - 수동으로 구매할 로또 갯수를 입력받는다.
//     -
// - 자동 로또 구매 갯수를 구한다.
//     - 나머지 금액으로 자동로또를 구매한다.
// - 구매한 로또들을 출력한다.
// - 당첨통계를 출력한다.
// - 총 수익률을 출력한다.