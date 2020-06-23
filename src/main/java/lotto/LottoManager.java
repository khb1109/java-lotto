package lotto;

import java.util.List;
import java.util.Map;

public class LottoManager {
	private final List<Lotto> lottos;
	private final WinningLotto winningLotto;

	public LottoManager(List<Lotto> lottos, WinningLotto winningLotto) {
		this.lottos = lottos;
		this.winningLotto = winningLotto;
	}

	public Map<Rank, Integer> calculateRanks() {
		return Rank.calculateStatistics(lottos, winningLotto);
	}
}
