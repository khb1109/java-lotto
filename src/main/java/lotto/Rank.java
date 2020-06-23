package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Rank {
	SIX(6),
	FIVE_BONUS(5, true),
	FIVE(5),
	FOUR(4),
	THREE(3),
	NONE_MATCH(6);

	private final int match;
	private final boolean bonus;

	Rank(int match) {
		this(match, false);
	}

	Rank(int match, boolean bonus) {
		this.match = match;
		this.bonus = bonus;
	}

	public static Map<Rank, Integer> calculateStatistics(List<Lotto> lottos, WinningLotto winningLotto) {
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
			.filter(rank -> rank.match == match)
			.filter(rank -> !rank.equals(FIVE_BONUS) || hasBonusMatch)
			.findFirst()
			.orElse(NONE_MATCH);
	}

	public int getMatch() {
		return match;
	}

	public boolean isBonus() {
		return bonus;
	}
}
