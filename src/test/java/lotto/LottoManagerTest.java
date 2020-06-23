package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Map;

import org.junit.jupiter.api.Test;

import helper.LottoProvider;
import lotto.number.LottoNumber;

class LottoManagerTest {
	@Test
	void calculateRanks() {
		Lotto 일등 = LottoProvider.create(1, 2, 3, 4, 5, 6);
		Lotto 이등 = LottoProvider.create(1, 2, 3, 4, 5, 7);
		Lotto 삼등 = LottoProvider.create(1, 2, 3, 4, 5, 10);

		Lotto winningNumbers = LottoProvider.create(1, 2, 3, 4, 5, 6);
		WinningLotto winningLotto = new WinningLotto(winningNumbers, LottoNumber.valueOf(7));

		LottoManager lottoManager = new LottoManager(Arrays.asList(일등, 이등, 이등, 삼등, 삼등), winningLotto);

		Map<Rank, Integer> actual = lottoManager.calculateRanks();

		assertAll(
			() -> assertThat(actual.get(Rank.SIX)).isEqualTo(1),
			() -> assertThat(actual.get(Rank.FIVE_BONUS)).isEqualTo(2),
			() -> assertThat(actual.get(Rank.FIVE)).isEqualTo(2)
		);
	}
}