package second;

/**
 * Класс, наследующий Play_Device, реализует устройство проигрывания USB
 */
public class USB_Player extends Play_Device {
	/**
	 * Назначение устройства хранения с проверкой на его тип
	 */
	@Override
	public void setStoringDevice(Storing_Device device) {
		if (device instanceof USB_Storage) {
			super.storing_Device = device;
		} else {
			System.out.println("Ошибка, устройство хранения не является USB.");
		}
	}

	@Override
	public String toString() {
		return String.valueOf("Тип устройства воспроизведения: USB");
	}
}
