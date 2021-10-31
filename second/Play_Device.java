package second;

import java.util.Objects;

/**
 * Класс, отвечающий за проигрывающее устройство
 */
public class Play_Device {
	private String device_type;
	private Storing_Device storing_Device;
	private String current_song;
	private String current_singer;

	/**
	 * Конструктор по умолчанию
	 */
	public Play_Device() {
	}

	/**
	 * Создание проигрывающего устройства
	 * 
	 * @param storing_Device - тип проигрывающего устройства (VINYL,CD,UNIVERSAL)
	 */
	public Play_Device(String device_type) {
		this.device_type = device_type;
	}

	/**
	 * Установить устройство хранения для проигрывающего устройства
	 * 
	 * @param device - устройство хранения
	 */
	public void setStoringDevice(Storing_Device device) {
		if (this.device_type == device.getType() || this.device_type == "UNIVERSAL") {
			this.storing_Device = device;
		} else {
			System.out.printf("Проигрывающее устройство и тип носителя не совместимы.%n");
		}
	}

	/**
	 * Поставить песню из хранилища
	 * 
	 * @param n - номер песни
	 */
	public void setSong(int n) {
		this.current_song = storing_Device.getSong(n).get(0);
		this.current_singer = storing_Device.getSong(n).get(1);
	}

	public void printCurrentSong() {
		System.out.printf("Текущая песня: %s, исполнитель: %s%n", current_song, current_singer);
	}

	@Override
	public String toString() {
		return String.format("Тип устройства воспроизведения: %s, тип носителя: %s%n", device_type,
				storing_Device.getType());
	}

	@Override
	public boolean equals(Object play_Device) {
		if (play_Device instanceof Play_Device) {
			Play_Device p = (Play_Device) play_Device;
			return this.device_type == p.device_type;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(this);
	}
}
