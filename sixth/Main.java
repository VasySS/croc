package sixth;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	/**
	 * Метод, удаляющий лишние директории из пути
	 * 
	 * @param path - путь
	 * @return - "нормализованный" путь
	 */
	public static String PathNormalizer(String path) {
		// Разбиение пути на отдельные элементы и создание очереди
		String[] path_array = path.split("/");
		Deque<String> dq = new ArrayDeque<String>();

		for (int i = 0; i < path_array.length; i++) {
			String str = path_array[i];
			// Добавление директории в очередь
			if (!str.equals(".") && !str.equals("..")) {
				dq.add(str);
			}
			// Проверка на подачу элемента ".."
			if ((dq.isEmpty() || dq.getLast().equals("..")) && str.equals("..")) {
				dq.add(".."); // Добавление ".." если последний элемент в очереди не директория
			} else if (!dq.isEmpty() && str.equals("..") && dq.getLast().charAt(str.length() - 1) != ':') {
				dq.removeLast(); // Удаление директории, не являющейся корневой, в противном случае
			}

		}
		// Преобразование очереди в готовый путь
		String result = "";
		for (String i : dq) {
			result = result.concat(i + "/");
		}

		return result;
	}

	public static void main(String[] args) {
		String path = "КРОК/task_6_2/src/./../../task_6_1/../../../мемы/котики";
		System.out.println(PathNormalizer(path));

		String path2 = "C:/Windows/./././../../../some_data/123/..";
		System.out.println(PathNormalizer(path2));

		String path3 = "C:/Windows/./././../../../";
		System.out.println(PathNormalizer(path3));
	}
}
