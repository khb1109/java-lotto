package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.number.LottoNumber;

public class Lotto {
	private static final int LOTTO_SIZE = 6;

	private final Set<LottoNumber> lottoNumbers;

	public Lotto(List<LottoNumber> lottoNumbers) {
		validateSize(lottoNumbers);
		this.lottoNumbers = new HashSet<>(lottoNumbers);
		validateDuplicate();
	}

	private void validateDuplicate() {
		if (this.lottoNumbers.size() != LOTTO_SIZE) {
			throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다." + this.lottoNumbers);
		}
	}

	private void validateSize(List<LottoNumber> lottoNumbers) {
		if (lottoNumbers.size() != LOTTO_SIZE) {
			throw new IllegalArgumentException("로또는 로또넘버 6개로 만들 수 있습니다. lottoNumbers=" + lottoNumbers);
		}
	}

	public boolean isContains(LottoNumber lottoNumber) {
		return lottoNumbers.contains(lottoNumber);
	}
}
