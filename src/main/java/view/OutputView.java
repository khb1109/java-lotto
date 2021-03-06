package view;

import java.util.List;
import java.util.StringJoiner;

import domain.GameResult;
import domain.Lotto;
import domain.LottoAmount;
import domain.Lottos;
import domain.Money;
import domain.Rank;

public class OutputView {
	private static final String DELIMITER = ", ";
	private static final String PREFIX = "[";
	private static final String SUFFIX = "]";

	public static void printLottos(Lottos lottoTickets) {
		List<Lotto> lottos = lottoTickets.getLottos();
		for (Lotto lotto : lottos) {
			StringJoiner stringJoiner = new StringJoiner(DELIMITER, PREFIX, SUFFIX);
			lotto.getNumbers()
				.forEach(lottoNumber -> stringJoiner.add(Integer.toString(lottoNumber.getNumber())));
			System.out.println(stringJoiner.toString());
		}
	}

	public static void printErrorMessage(String message) {
		System.out.println(message);
	}

	public static void printStatistics(GameResult gameResult, Money purchaseMoney) {
		System.out.println("당첨 통계");
		System.out.println("-------");
		for (Rank rank : Rank.values()) {
			String matchedCount = rank.getMessage();
			Money winningMoney = rank.getWinningMoney();
			int containingCount = gameResult.numberOfRank(rank);
			System.out.println(
				String.format("%s (%.0f원) - %d개", matchedCount, winningMoney.getMoney(), containingCount));
		}
		System.out.println(String.format("총 수익률은 %.0f%%입니다.", gameResult.calculateProfit(purchaseMoney)));
	}

	public static void printAmount(LottoAmount lottoAmount) {
		System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", lottoAmount.getSelfLottoAmount(),
			lottoAmount.getAutoLottoAmount()));
	}
}
