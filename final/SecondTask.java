import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Класс для хранения данных по второму заданию
 */
public class SecondTask {
	private String date;
	private String average_sold;

	SecondTask() {
	}

	public void setDate(Date date) {
		this.date = new SimpleDateFormat("dd.MM.yyyy").format(date);
	}

	public void setAverageSold(double avg) {
		this.average_sold = String.format("%.2f", avg);
	}

	public String getDate() {
		return this.date;
	}

	public String getAverageSold() {
		return this.average_sold;
	}

	public String toString() {
		return "Date: " + this.date + ", average amount of sold goods: " + this.average_sold;
	}
}
