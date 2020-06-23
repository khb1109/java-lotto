package lotto;

import static lotto.number.LottoNumber.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.amount.LottoAmount;
import lotto.number.LottoNumber;

public class LottoFactory {
	private static final List<LottoNumber> lottoNumbers;

	static {
		lottoNumbers = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
			.mapToObj(LottoNumber::valueOf)
			.collect(Collectors.toList());
	}

	public static List<Lotto> createLotto(LottoAmount lottoAmount, SequenceStrategy sequenceStrategy) {
		List<Lotto> lottos = new ArrayList<>();

		for (int i = 0; i < lottoAmount.getAutoLottoAmount().getAmount(); i++) {
			sequenceStrategy.shake(lottoNumbers);
			lottos.add(new Lotto(lottoNumbers.subList(0, 6)));
		}
		return lottos;
	}
}
