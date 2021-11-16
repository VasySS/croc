package fifth;

import java.util.ArrayList;

/**
 * Стартовый класс.
 */
public class Main {
    /**
     * Пример входной строки.
     */
    public static final String INPUT_STRING = "Невежество есть мать промышленности, как и суеверий."
            + " Сила размышления и воображения подвержена ошибкам; но привычка двигать рукой или ногой"
            + " не зависит ни от того, ни от другого. Поэтому мануфактуры лучше всего процветают там, где"
            + " наиболее подавлена духовная жизнь, так что мастерская может рассматриваться как машина,"
            + " части которой составляют люди.";

    /**
     * Шаблон поиска символов в строке.
     */
    public static final String TEMPLATE = " ";

    /**
     * Точка входа в приложение.
     *
     * @param args аргументы командной строки.
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        long current = System.currentTimeMillis();
        // 1 - 38356 мс
        // 2 - 19195 мс
        // 4 - 9548 мс
        // 16 - 2383 мс
        // 64 - 631 мс
        final int THREADS = 32;

        // Строка, разбитая на части
        String[] str = INPUT_STRING.split("(?<=\\G.{" + INPUT_STRING.length() / THREADS + "})");
        for (int i = 0; i < str.length; i++)
            System.out.println(str[i]);

        // Создание списка и добавление потоков в него
        ArrayList<Thread> list = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            list.add(new MatcherThread(String.valueOf(str[i]), String.valueOf(TEMPLATE)));
        }
        // Запуск потоков
        for (int i = 0; i < str.length; i++) {
            list.get(i).start();
        }
        // Запуск ожидания завершения потоков MatcherThread потоком Main
        for (int i = 0; i < str.length; i++) {
            list.get(i).join();
        }

        System.out.println("Count of space: " + MatcherThread.getResult());
        System.out.println("Time: " + (System.currentTimeMillis() - current) + " мc.");
    }
}