package lotto.amount;

import lotto.LottoMoney;
import lotto.amount.element.AutoLottoAmount;
import lotto.amount.element.ManualLottoAmount;

public class LottoAmount {
	private final ManualLottoAmount manualLottoAmount;
	private final AutoLottoAmount autoLottoAmount;
	private int manualLottoCount;

	public LottoAmount(ManualLottoAmount manualLottoAmount, AutoLottoAmount autoLottoAmount) {
		this.manualLottoAmount = manualLottoAmount;
		this.autoLottoAmount = autoLottoAmount;
		this.manualLottoCount = 0;
	}

	public static LottoAmount valueOf(LottoMoney lottoMoney, int manualAmount) {
		ManualLottoAmount manualLottoAmount = ManualLottoAmount.of(manualAmount, lottoMoney);
		AutoLottoAmount autoLottoAmount = AutoLottoAmount.of(manualLottoAmount, lottoMoney);

		return new LottoAmount(manualLottoAmount, autoLottoAmount);
	}

	public boolean hasNext() {
		return manualLottoAmount.isExcess(manualLottoCount);
	}

	public void next() {
		manualLottoCount++;
	}

	public int getManualLottoCount() {
		return manualLottoCount;
	}
}
