package view;

import java.util.List;
import java.util.stream.Collectors;

import lotto.Lotto;
import lotto.amount.LottoAmount;
import lotto.number.LottoNumber;

public class OutputView {
	private static final String DELIMITER = ", ";

	public void showManualLotto() {
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");
	}

	public void showPurchasedLotto(LottoAmount lottoAmount, List<Lotto> lottos) {
		System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", lottoAmount.getManualLottoAmount().getAmount(),
			lottoAmount.getAutoLottoAmount().getAmount());

		for (Lotto lotto : lottos) {
			String numbers = lotto.getLottoNumbers()
				.stream()
				.map(LottoNumber::getNumber)
				.map(String::valueOf)
				.collect(Collectors.joining(DELIMITER));
			System.out.printf("[%s]\n", numbers);
		}
	}

	public void showWinningStatistics() {
		System.out.println("당첨 통계\n"
			+ "---------\n"
			+ "3개 일치 (5000원)- 1개\n"
			+ "4개 일치 (50000원)- 0개\n"
			+ "5개 일치 (1500000원)- 0개\n"
			+ "5개 일치, 보너스 볼 일치(30000000원) - 0개\n"
			+ "6개 일치 (2000000000원)- 0개");
	}

	public void showProfit() {
		System.out.println("총 수익률은 30%입니다.");
	}
}
