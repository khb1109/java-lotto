package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import helper.LottoProvider;
import lotto.number.LottoNumber;

class RankTest {
	@DisplayName("매치와 보너스 값을 이용하여 순위를 구한다.")
	@Test
	void calculateStatistics() {
		Lotto 일등 = LottoProvider.create(1, 2, 3, 4, 5, 6);

		Lotto winningNumbers = LottoProvider.create(1, 2, 3, 4, 5, 6);
		WinningLotto winningLotto = new WinningLotto(winningNumbers, LottoNumber.valueOf(7));

		Map<Rank, Integer> ranks = Rank.calculateStatistics(Arrays.asList(일등), winningLotto);

		assertThat(ranks).isEqualTo(new HashMap<Rank, Integer>() {{
			put(Rank.SIX, 1);
		}});
	}
}