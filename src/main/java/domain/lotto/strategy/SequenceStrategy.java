package domain.lotto.strategy;

import java.util.List;

import domain.lotto.number.LottoNumber;

@FunctionalInterface
public interface SequenceStrategy {
	void shake(List<LottoNumber> lottoNumbers);
}
