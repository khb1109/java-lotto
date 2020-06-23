package domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import domain.lotto.number.LottoNumber;

public class Lotto {
	public static final int LOTTO_SIZE = 6;

	private final Set<LottoNumber> lottoNumbers;

	public Lotto(List<LottoNumber> lottoNumbers) {
		Objects.requireNonNull(lottoNumbers);

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
		Objects.requireNonNull(lottoNumber);
		return lottoNumbers.contains(lottoNumber);
	}

	public Set<LottoNumber> getLottoNumbers() {
		return lottoNumbers;
	}

	public int countMatch(Lotto other) {
		Objects.requireNonNull(other);
		return (int)lottoNumbers.stream()
			.filter(other::isContains)
			.count();
	}

	@Override
	public String toString() {
		return "Lotto{" +
			"lottoNumbers=" + lottoNumbers +
			'}';
	}
}
