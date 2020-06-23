package view;

import java.util.List;

import lotto.Lotto;
import lotto.amount.LottoAmount;

public class OutputView {
	public void showManualLotto() {
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");
	}

	public void showPurchasedLotto(LottoAmount lottoAmount, List<Lotto> lottos) {
		System.out.println("수동으로 3장, 자동으로 11개를 구매했습니다.\n"
			+ "[8, 21, 23, 41, 42, 43]\n"
			+ "[3, 5, 11, 16, 32, 38]\n"
			+ "[7, 11, 16, 35, 36, 44]\n"
			+ "[1, 8, 11, 31, 41, 42]\n"
			+ "[13, 14, 16, 38, 42, 45]\n"
			+ "[7, 11, 30, 40, 42, 43]\n"
			+ "[2, 13, 22, 32, 38, 45]\n"
			+ "[23, 25, 33, 36, 39, 41]\n"
			+ "[1, 3, 5, 14, 22, 45]\n"
			+ "[5, 9, 38, 41, 43, 44]\n"
			+ "[2, 8, 9, 18, 19, 21]\n"
			+ "[13, 14, 18, 21, 23, 35]\n"
			+ "[17, 21, 29, 37, 42, 45]\n"
			+ "[3, 8, 27, 30, 35, 44]\n");
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
