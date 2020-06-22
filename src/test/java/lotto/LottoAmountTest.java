package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoAmountTest {
	@DisplayName("금액은 1000원 이상으로 입력해야한다.")
	@Test
	void name() {
		assertThatThrownBy(() -> new LottoAmount(999L))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("로또를 구매할 비용이 부족합니다.");
	}

	@DisplayName("로또 갯수는 로또가격을 나눈 몫이다.")
	@CsvSource(value = {"20001,20", "1234,1", "2345,2"})
	@ParameterizedTest
	void name2(long lottoMoney, int expect) {
		LottoAmount lottoAmount = new LottoAmount(lottoMoney);

		assertThat(lottoAmount.getAmount()).isEqualTo(expect);
	}
}

// - 수동으로 구매할 로또 갯수를 입력받는다.
//     - 0이상이며, (갯수*금액) 가격이 구입금액보다 크면 안된다.
// - 자동 로또 구매 갯수를 구한다.
//     - 나머지 금액으로 자동로또를 구매한다.
// - 구매한 로또들을 출력한다.
// - 당첨통계를 출력한다.
// - 총 수익률을 출력한다.