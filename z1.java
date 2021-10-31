/**
 * Класс, выводящий числа от 1 до 100 с заменой чисел, делящихся на 3 на Fizz,
 * делящихся на 5 на Buzz, делящихся на 3 и 5 на FizzBuzz
 */
public class z1 {
	public static void main(String[] args) {
		for (int i = 1; i <= 100; ++i) {
			// Проверка деления на 3
			if (i % 3 == 0) {
				System.out.print("Fizz");
			}
			// Проверка деления на 5
			if (i % 5 == 0) {
				System.out.print("Buzz");
			}
			// Проверка неделимости на 3 и 5
			if (i % 3 != 0 && i % 5 != 0) {
				System.out.print(i);
			}

			System.out.println();
		}
	}
}
