package view;

public class OutputView {
	public void manualLotto() {
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");
	}

	public void winningStatistics() {
		System.out.println("당첨 통계\n"
			+ "---------\n"
			+ "3개 일치 (5000원)- 1개\n"
			+ "4개 일치 (50000원)- 0개\n"
			+ "5개 일치 (1500000원)- 0개\n"
			+ "5개 일치, 보너스 볼 일치(30000000원) - 0개\n"
			+ "6개 일치 (2000000000원)- 0개");
	}

	public void profit() {
		System.out.println("총 수익률은 30%입니다.");
	}
}
