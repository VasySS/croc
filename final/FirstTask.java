/**
 * Класс для хранения данных по первому заданию
 */
public class FirstTask {
	private String goods_name;
	private int sold_amount;

	FirstTask() {
	}

	public void setGoodsName(String name) {
		this.goods_name = name;
	}

	public void setAmount(int amount) {
		this.sold_amount = amount;
	}

	public String getGoodsName() {
		return this.goods_name;
	}

	public int getAmount() {
		return this.sold_amount;
	}

	public String toString() {
		return "Goods name = " + this.goods_name + ", sold amount = " + this.sold_amount;
	}
}
