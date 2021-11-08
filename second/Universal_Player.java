package second;

/**
 * Класс, наследующий Play_Device, реализует универсальное устройство
 * проигрывания
 */
public class Universal_Player extends Play_Device {
	/**
	 * Назначение устройства хранения
	 */
	@Override
	public void setStoringDevice(Storing_Device device) {
		super.storing_Device = device;
	}

	@Override
	public String toString() {
		return String.valueOf("Тип устройства воспроизведения: UNIVERSAL");
	}
}
