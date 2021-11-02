package third;

public class Main {
	public static void main(String[] args) {
		ChessField cf = new ChessField(0, 0);
		System.out.println(cf.toString());

		cf.setX(7);
		cf.setY(7);
		System.out.println(cf.toString());
	}
}
