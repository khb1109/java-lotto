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
