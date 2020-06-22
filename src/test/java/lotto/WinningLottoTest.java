package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.number.LottoNumber;

class WinningLottoTest {
	@DisplayName("당첨번호와 보너스 번호가 중복되면 에러가 발생한다.")
	@Test
	void name() {
		Lotto lotto = new Lotto(Arrays.asList(LottoNumber.valueOf(1), LottoNumber.valueOf(2), LottoNumber.valueOf(3)
			, LottoNumber.valueOf(4), LottoNumber.valueOf(5), LottoNumber.valueOf(6)));

		assertThatThrownBy(() -> new WinningLotto(lotto, LottoNumber.valueOf(1)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("당첨번호와 보너스번호는 중복될 수 없습니다.");
	}
}

//- 로또 구입 금액을 입력받는다.
//     - 금액은 1000원 이상으로 입력해야한다.
// - 수동으로 구매할 로또 갯수를 입력받는다.
//     - 0이상이며, (갯수*금액) 가격이 구입금액보다 크면 안된다.
// - 자동 로또 구매 갯수를 구한다.
//     - 나머지 금액으로 자동로또를 구매한다.
// - 구매한 로또들을 출력한다.
// - 당첨통계를 출력한다.
// - 총 수익률을 출력한다.