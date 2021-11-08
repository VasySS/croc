package second;

/**
 * Класс, наследующий Storing_Device, реализует устройство хранения USB
 */
public class USB_Storage extends Storing_Device {

	@Override
	public String toString() {
		return String.valueOf("Тип хранителя информации: USB");
	}

}
