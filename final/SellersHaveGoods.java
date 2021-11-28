/**
 * Класс для хранения входных данных с файла с данными по
 * наличию товаров у продавцов
 */
public class SellersHaveGoods {
	private int seller_id;
	private int goods_id;
	private double price;
	private int amount;

	public SellersHaveGoods() {
	}

	public void setSellerId(int id) {
		this.seller_id = id;
	}

	public void setGoodsId(int id) {
		this.goods_id = id;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getSellerId() {
		return this.seller_id;
	}

	public int getGoodsId() {
		return this.goods_id;
	}

	public double getPrice() {
		return this.price;
	}

	public int getAmount() {
		return this.amount;
	}

	public String toString() {
		return "Seller with id =  " + this.seller_id + " have " + this.amount +
				" pieces of goods with id = " + this.goods_id + ", price= " + this.price;
	}
}
