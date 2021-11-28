/**
 * Класс для хранения входных данных с файла с товарами
 */
public class Goods {
	private int id;
	private String goods_name;

	public Goods() {
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setGoodsName(String name) {
		this.goods_name = name;
	}

	public int getId() {
		return this.id;
	}

	public String getGoodsName() {
		return this.goods_name;
	}

	public String toString() {
		return "Goods id: " + this.id + ", name: " + this.goods_name;
	}
}
