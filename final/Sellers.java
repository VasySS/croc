/**
 * Класс для хранения входных данных с файла с продавцами
 */
public class Sellers {
	private int id;
	private String last_name;
	private String first_name;

	public Sellers() {
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLastName(String name) {
		this.last_name = name;
	}

	public void setFirstName(String name) {
		this.first_name = name;
	}

	public int getId() {
		return this.id;
	}

	public String getLastName() {
		return this.last_name;
	}

	public String getFirstName() {
		return this.first_name;
	}

	public String toString() {
		return "Seller id: " + this.id + ", name: " + this.last_name + " " + this.first_name;
	}
}
