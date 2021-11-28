import java.util.Date;

/**
 * Класс для хранения входных данных с файла с продажами
 */
public class SoldAmount {
	private int id;
	private int seller_id;
	private int goods_id;
	private int sold_amount;
	private Date date;

	public SoldAmount() {
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSellerId(int id) {
		this.seller_id = id;
	}

	public void setGoodsId(int id) {
		this.goods_id = id;
	}

	public void setSoldAmount(int amount) {
		this.sold_amount = amount;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return this.id;
	}

	public int getSellerId() {
		return this.seller_id;
	}

	public int getGoodsId() {
		return this.goods_id;
	}

	public int getSoldAmount() {
		return this.sold_amount;
	}

	public Date getDate() {
		return this.date;
	}

	public String toString() {
		return "Sale id = " + this.id + ", seller id = " + this.seller_id +
				", goods id = " + this.goods_id + ", sold amount = " + this.sold_amount +
				", date = " + this.date;
	}
}
