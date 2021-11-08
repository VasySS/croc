package second;

/**
 * Класс, наследующий Storing_Device, реализует устройство хранения CD
 */
public class CD_Storage extends Storing_Device {

	@Override
	public String toString() {
		return String.valueOf("Тип хранителя информации: CD");
	}

}
