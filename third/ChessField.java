package third;

/**
 * Класс, описывающий координаты шахматной клетки
 */
public class ChessField {
	private int x;
	private int y;

	/**
	 * Конструктор по умолчанию
	 */
	public ChessField() {
	}

	/**
	 * Создать координаты шахматной клетки
	 * 
	 * @param x - координата x
	 * @param y - координата y
	 */
	public ChessField(int x, int y) throws IllegalArgumentException {
		setX(x);
		setY(y);
	}

	/**
	 * Изменить координаты x
	 * 
	 * @param x - координата x
	 */
	public void setX(int x) throws IllegalArgumentException {
		if (x < 0 || x > 7) {
			throw new IllegalArgumentException();
		}
		this.x = x;
	}

	/**
	 * Изменить координаты y
	 * 
	 * @param y - координата y
	 */
	public void setY(int y) throws IllegalArgumentException {
		if (y < 0 || y > 7) {
			throw new IllegalArgumentException();
		}
		this.y = y;
	}

	/**
	 * Получить координату x
	 * 
	 * @return - координата x
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Получить координату y
	 * 
	 * @return - координата y
	 */
	public int getY() {
		return this.y;
	}

	@Override
	public String toString() {
		char xx = (char) ('a' + this.y);
		return String.format("%s%d", xx, this.y + 1);
	}

}
