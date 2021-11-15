import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Класс, подсчитывающий количество слов в файле
 */
public class Main {
	public static void main(String[] args) throws IOException {
		int res = 0;
		// Ввод пути до файла
		System.out.print("Введите путь до файла: ");
		Scanner s = new Scanner(System.in);
		String path = s.nextLine();
		s.close();
		// Открытие потока на чтение
		try (BufferedReader r = new BufferedReader(new FileReader(path))) {
			String line;
			// Ввод текущей строки
			while ((line = r.readLine()) != null) {
				boolean word = false;
				// Перебор строки посимвольно
				for (char c : line.toCharArray()) {
					// Проверка на то, является ли символ буквой, если нет - слово закончилось
					if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'z') || (c >= 'а' && c <= 'я') || (c >= 'А' && c <= 'Я')) {
						word = true;
					} else if (word) {
						word = false;
						res++;
					}
				}
				// Обработка последнего слова в строке
				// если после него ничего нету (точки, запятой,пробела и т.д.)
				if (word) {
					res++;
				}

			}
		} catch (IllegalArgumentException ex) {
			System.out.println("Неправильно задан путь.");
		} catch (FileNotFoundException ex) {
			System.out.println("Файл не найден.");
		}

		System.out.println("Количество слов в файле: " + res);
	}
}