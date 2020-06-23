package domain.lotto;

import static domain.lotto.Lotto.*;
import static domain.lotto.number.LottoNumber.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import domain.amount.LottoAmount;
import domain.lotto.number.LottoNumber;

public class LottoFactory {
	private static final List<LottoNumber> lottoNumbers;

	static {
		lottoNumbers = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
			.mapToObj(LottoNumber::valueOf)
			.collect(Collectors.toList());
	}

	public static List<Lotto> createLotto(LottoAmount lottoAmount, SequenceStrategy sequenceStrategy) {
		Objects.requireNonNull(lottoAmount);
		Objects.requireNonNull(sequenceStrategy);

		List<Lotto> lottos = new ArrayList<>();

		for (int i = 0; i < lottoAmount.getAutoLottoAmount().getAmount(); i++) {
			sequenceStrategy.shake(lottoNumbers);
			lottos.add(new Lotto(lottoNumbers.subList(0, LOTTO_SIZE)));
		}
		return lottos;
	}
}
