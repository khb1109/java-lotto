package lotto.amount;

import lotto.LottoMoney;
import lotto.amount.element.AutoLottoAmount;
import lotto.amount.element.ManualLottoAmount;

public class LottoAmount {
	private final ManualLottoAmount manualLottoAmount;
	private final AutoLottoAmount autoLottoAmount;

	public LottoAmount(ManualLottoAmount manualLottoAmount, AutoLottoAmount autoLottoAmount) {
		this.manualLottoAmount = manualLottoAmount;
		this.autoLottoAmount = autoLottoAmount;
	}

	public static LottoAmount valueOf(LottoMoney lottoMoney, int manualAmount) {
		ManualLottoAmount manualLottoAmount = ManualLottoAmount.of(manualAmount, lottoMoney);
		AutoLottoAmount autoLottoAmount = AutoLottoAmount.of(manualLottoAmount, lottoMoney);

		return new LottoAmount(manualLottoAmount, autoLottoAmount);
	}
}
