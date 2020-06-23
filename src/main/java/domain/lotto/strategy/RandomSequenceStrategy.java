package domain.lotto.strategy;

import java.util.Collections;
import java.util.List;

import domain.lotto.number.LottoNumber;

public class RandomSequenceStrategy implements SequenceStrategy {
	@Override
	public void shake(List<LottoNumber> lottoNumbers) {
		Collections.shuffle(lottoNumbers);
	}
}
