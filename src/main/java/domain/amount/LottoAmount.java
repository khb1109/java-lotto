package domain.amount;

import java.util.Objects;

import domain.amount.element.AutoLottoAmount;
import domain.amount.element.ManualLottoAmount;

public class LottoAmount {
	private final ManualLottoAmount manualLottoAmount;
	private final AutoLottoAmount autoLottoAmount;
	private int manualLottoCount;

	private LottoAmount(ManualLottoAmount manualLottoAmount, AutoLottoAmount autoLottoAmount) {
		this.manualLottoAmount = manualLottoAmount;
		this.autoLottoAmount = autoLottoAmount;
		this.manualLottoCount = 0;
	}

	public static LottoAmount valueOf(LottoMoney lottoMoney, int manualAmount) {
		Objects.requireNonNull(lottoMoney);

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

	public ManualLottoAmount getManualLottoAmount() {
		return manualLottoAmount;
	}

	public AutoLottoAmount getAutoLottoAmount() {
		return autoLottoAmount;
	}

	public int getManualLottoCount() {
		return manualLottoCount;
	}
}
