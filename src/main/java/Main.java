import controller.LottoController;
import domain.lotto.strategy.RandomSequenceStrategy;
import view.InputView;
import view.OutputView;

public class Main {
	public static void main(String[] args) {
		new LottoController(new InputView(), new OutputView(), new RandomSequenceStrategy()).run();
	}
}
