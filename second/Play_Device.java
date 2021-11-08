package second;

import java.util.Objects;

/**
 * Абстрактный класс, отвечающий за проигрывающее устройство
 */
public abstract class Play_Device {
	protected String current_song;
	protected String current_singer;
	protected Storing_Device storing_Device;

	/**
	 * Конструктор по умолчанию
	 */
	public Play_Device() {
	}

	/**
	 * Установить устройство хранения для проигрывающего устройства
	 * 
	 * @param device - устройство хранения
	 */
	public abstract void setStoringDevice(Storing_Device device);

	/**
	 * Поставить песню из хранилища
	 * 
	 * @param n - номер песни
	 */
	public void setSong(int n) {
		this.current_song = storing_Device.getSong(n).get(0);
		this.current_singer = storing_Device.getSong(n).get(1);
	}

	/**
	 * Вывод текущей песни
	 */
	public void printCurrentSong() {
		System.out.printf("Текущая песня: %s, исполнитель: %s%n", current_song, current_singer);
	}

	@Override
	public abstract String toString();

	@Override
	public boolean equals(Object play_Device) {
		if (play_Device instanceof Play_Device) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(this);
	}
}
