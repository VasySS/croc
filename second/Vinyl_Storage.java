package second;

/**
 * Класс, наследующий Storing_Device, реализует устройство хранения Vinyl
 */
public class Vinyl_Storage extends Storing_Device {

	@Override
	public String toString() {
		return String.valueOf("Тип хранителя информации: VINYL");
	}
}
