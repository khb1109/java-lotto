package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.amount.LottoAmount;
import lotto.number.LottoNumber;

class LottoFactoryTest {

	@DisplayName("자동 로또를 구매하여 로또를 확인한다.")
	@Test
	void testCreateLotto() {
		LottoAmount lottoAmount = LottoAmount.valueOf(new LottoMoney(1000), 0);
		List<Lotto> lotto = LottoFactory.createLotto(lottoAmount, lottoNumbers -> {
		});

		List<LottoNumber> expect = IntStream.rangeClosed(1, 6)
			.mapToObj(LottoNumber::valueOf)
			.collect(Collectors.toList());

		Set<LottoNumber> actual = lotto.get(0).getLottoNumbers();
		assertThat(actual).containsAll(expect);
	}
}