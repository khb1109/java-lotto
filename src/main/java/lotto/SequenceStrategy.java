package lotto;

import java.util.List;

import lotto.number.LottoNumber;

@FunctionalInterface
public interface SequenceStrategy {
	void shake(List<LottoNumber> lottoNumbers);
}
