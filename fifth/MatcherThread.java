package fifth;

/**
 * Потоковый класс для Matcher
 */
public class MatcherThread extends Thread {
	static int res = 0;
	private String INPUT_STRING;
	private String TEMPLATE;
	private static final Object lock = new Object();

	/**
	 * Конструктор класса
	 * 
	 * @param INPUT_STRING - строка для обработки
	 */
	public MatcherThread(String INPUT_STRING, String TEMPLATE) {
		this.INPUT_STRING = INPUT_STRING;
		this.TEMPLATE = TEMPLATE;
	}

	/**
	 * Получение результата сравнения
	 * 
	 * @return - количество совпадений
	 */
	public static int getResult() {
		return MatcherThread.res;
	}

	@Override
	public void run() {
		// Прохождение по заданной строке и поиск совпадений
		for (int i = 0; i < INPUT_STRING.length(); i++) {
			if (Matcher.match(String.valueOf(INPUT_STRING.charAt(i)), TEMPLATE)) {
				synchronized (lock) {
					res++;
				}
			}
		}
	}
}
