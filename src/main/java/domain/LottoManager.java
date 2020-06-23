package domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import domain.amount.LottoMoney;
import domain.lotto.Lotto;
import domain.lotto.WinningLotto;
import domain.statistics.Rank;

public class LottoManager {
	private final List<Lotto> lottos;
	private final WinningLotto winningLotto;

	public LottoManager(List<Lotto> lottos, WinningLotto winningLotto) {
		Objects.requireNonNull(lottos);
		Objects.requireNonNull(winningLotto);

		this.lottos = lottos;
		this.winningLotto = winningLotto;
	}

	public Map<Rank, Integer> calculateRanks() {
		return Rank.calculateStatistics(lottos, winningLotto);
	}

	public double calculateProfit(Map<Rank, Integer> countByRank, LottoMoney lottoMoney) {
		Objects.requireNonNull(countByRank);
		Objects.requireNonNull(lottoMoney);

		long winningMoney = 0L;

		for (Rank rank : Rank.values()) {
			int count = countByRank.getOrDefault(rank, 0);
			winningMoney += rank.multiplyMoneyByCount(count);
		}

		return lottoMoney.calculateProfit(winningMoney);
	}
}
