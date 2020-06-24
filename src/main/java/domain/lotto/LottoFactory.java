package domain.lotto;

import static domain.lotto.Lotto.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import domain.amount.LottoAmount;
import domain.lotto.number.LottoNumber;
import domain.lotto.strategy.LottoCreateStrategy;

public class LottoFactory {
	private static final List<LottoNumber> lottoNumbers = LottoNumber.getCachedLottoNumbers();

	public static List<Lotto> createLotto(LottoAmount lottoAmount, LottoCreateStrategy lottoCreateStrategy) {
		Objects.requireNonNull(lottoAmount);
		Objects.requireNonNull(lottoCreateStrategy);

		List<Lotto> lottos = new ArrayList<>();

		for (int i = 0; i < lottoAmount.getAutoLottoAmount().getAmount(); i++) {
			lottoCreateStrategy.execute(lottoNumbers);
			lottos.add(new Lotto(lottoNumbers.subList(0, SIZE)));
		}

		return lottos;
	}
}
