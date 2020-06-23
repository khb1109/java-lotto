package domain.statistics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import domain.lotto.Lotto;
import domain.lotto.WinningLotto;

public enum Rank {
	SIX(6, 2_000_000_000L),
	FIVE_BONUS(5, 30_000_000L),
	FIVE(5, 1_500_000L),
	FOUR(4, 50_000L),
	THREE(3, 5_000L),
	NONE_MATCH(0, 0L);

	private final int match;
	private final long money;

	Rank(int match, long money) {
		this.match = match;
		this.money = money;
	}

	public static Map<Rank, Integer> calculateStatistics(List<Lotto> lottos, WinningLotto winningLotto) {
		Objects.requireNonNull(lottos);
		Objects.requireNonNull(winningLotto);

		Map<Rank, Integer> ranks = new HashMap<>();
		for (Lotto lotto : lottos) {
			int match = winningLotto.countMatch(lotto);
			boolean isBonusMatch = winningLotto.checkBonus(lotto);

			Rank rank = Rank.of(match, isBonusMatch);
			Integer rankByCount = ranks.getOrDefault(rank, 0);

			ranks.put(rank, rankByCount + 1);
		}
		return ranks;
	}

	private static Rank of(int match, boolean hasBonusMatch) {
		return Arrays.stream(values())
			.filter(rank -> rank.isSameMatch(match))
			.filter(rank -> !rank.equals(FIVE_BONUS) || hasBonusMatch)
			.findAny()
			.orElse(NONE_MATCH);
	}

	private boolean isSameMatch(int match) {
		return this.match == match;
	}

	public long multiplyMoneyByCount(int count) {
		return this.money * count;
	}

	public int getMatch() {
		return match;
	}

	public long getMoney() {
		return money;
	}
}
