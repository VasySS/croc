package second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Абстрактный класс, отвечающий за носитель информации
 */
public abstract class Storing_Device {
	protected ArrayList<String> singer = new ArrayList<>();
	protected ArrayList<String> songs = new ArrayList<>();

	/**
	 * Конструктор по умолчанию
	 */
	public Storing_Device() {
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
	public abstract String toString();

	@Override
	public boolean equals(Object storing_Device) {
		if (storing_Device instanceof Storing_Device) {
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
