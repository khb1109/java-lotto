package lotto;

import lotto.number.LottoNumber;

public class WinningLotto {
	private final Lotto lotto;
	private final LottoNumber bonusNumber;

	public WinningLotto(Lotto lotto, LottoNumber lottoNumber) {
		if (lotto.isContains(lottoNumber)) {
			throw new IllegalArgumentException(
				"당첨번호와 보너스번호는 중복될 수 없습니다. lotto=" + lotto + "lottoNumber" + lottoNumber);
		}
		this.lotto = lotto;
		this.bonusNumber = lottoNumber;
	}

	public int countMatch(Lotto lotto) {
		return this.lotto.countMatch(lotto);
	}

	public boolean checkBonus(Lotto lotto) {
		return lotto.isContains(this.bonusNumber);
	}

	@Override
	public String toString() {
		return "WinningLotto{" +
			"lotto=" + lotto +
			", bonusNumber=" + bonusNumber +
			'}';
	}
}
