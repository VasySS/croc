package second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Класс, отвечающий за носитель информации, наследующий проигрывающее
 * устройство
 */
public class Storing_Device {
	private String device_type;
	private ArrayList<String> singer = new ArrayList<>();
	private ArrayList<String> songs = new ArrayList<>();

	/**
	 * Конструктор по умолчанию
	 */
	public Storing_Device() {
	}

	/**
	 * Создание устройства хранения песен
	 * 
	 * @param device_type - тип устройства (USB,VINYL,CD и т.д.)
	 */
	public Storing_Device(String device_type) {
		this.device_type = device_type;
	}

	/**
	 * Добавление песни на носитель
	 * 
	 * @param singer - Исполнитель песни (группа)
	 * @param song   - Название песни
	 */
	public void addSong(String singer, String song) {
		this.singer.add(singer);
		this.songs.add(song);
	}

	/**
	 * Получение песни с утройства
	 * 
	 * @param n - номер песни
	 * @return - Имя исполнителя, название песни
	 */
	public ArrayList<String> getSong(int n) {
		return new ArrayList<>(Arrays.asList(this.singer.get(n), this.songs.get(n)));
	}

	/**
	 * Получение типа устройства
	 * 
	 * @return - тип
	 */
	public String getType() {
		return this.device_type;
	}

	/**
	 * Вывод списка песен
	 */
	public void printListOfSongs() {
		for (int i = 0; i < songs.size(); i++) {
			System.out.printf("%d. Исполнитель: %s, песня: %s%n", i + 1, getSong(i).get(0), getSong(i).get(1));
		}
	}

	/**
	 * Удаление песни с носителя по её номеру
	 * 
	 * @param n - Номер песни
	 */
	public void removeSong(int n) {
		this.songs.remove(n);
		this.singer.remove(n);
	}

	@Override
	public String toString() {
		return String.format("Тип устройства: %s, количество песен: %s%n", device_type, singer.size());
	}

	@Override
	public boolean equals(Object storing_Device) {
		if (storing_Device instanceof Storing_Device) {
			Storing_Device d = (Storing_Device) storing_Device;
			return this.device_type == d.device_type;
		} else {
			return false;
		}

	}

	@Override
	public int hashCode() {
		return Objects.hash(this);
	}
}
