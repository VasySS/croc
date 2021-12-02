import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;

public class Main {
	public static void main(String[] args) throws IOException {
		// Чтение файлов
		System.out.println("Считывание входных файлов...");
		Gson gson = new GsonBuilder().setDateFormat("dd.MM.yyyy").create();
		JsonReader reader = new JsonReader(new FileReader("data/goods.json"));
		JsonReader reader2 = new JsonReader(new FileReader("data/sellers.json"));
		JsonReader reader3 = new JsonReader(new FileReader("data/sellers_have_goods.json"));
		JsonReader reader4 = new JsonReader(new FileReader("data/sold_amount.json"));
		// Создание классов с заполнением данными из файлов
		Goods[] goods = gson.fromJson(reader, Goods[].class);
		Sellers[] sellers = gson.fromJson(reader2, Sellers[].class);
		SellersHaveGoods[] sellersHaveGoods = gson.fromJson(reader3, SellersHaveGoods[].class);
		SoldAmount[] soldAmount = gson.fromJson(reader4, SoldAmount[].class);

		reader.close();
		reader2.close();
		reader3.close();
		reader4.close();
		// Вызов методов для вывода файлов по варианту
		firstTask(goods, soldAmount);
		secondTask(soldAmount);
	}

	/**
	 * Возвращает название товара по его id из массива товаров
	 * 
	 * @param id    - id товара
	 * @param goods - массив товаров
	 * @return - название товара
	 */
	public static String getProductName(int id, Goods[] goods) {
		return Stream.of(goods).filter(good -> good.getId() == id).map(Goods::getGoodsName).findFirst()
				.orElse("name not found");
	}

	/**
	 * Метод для выполнения первой задачи по варианту:
	 * Вывести в файл топ 5 товаров с наибольшим количеством продаж
	 * 
	 * @param gd    - массив товаров
	 * @param solds - массив продаж
	 */
	public static void firstTask(Goods[] gd, SoldAmount[] solds) {
		// Создание Map для хранения названия товара и количества его продаж
		Map<String, Integer> map = new HashMap<>();

		for (SoldAmount sold : solds) {
			int value = 0;
			// Получение названия товара по его id
			String name = getProductName(sold.getGoodsId(), gd);
			// Получение количества проданного товара,
			// уже хранящегося в множестве
			if (map.get(name) != null)
				value = map.get(name);
			// Увеличение хранящегося количества
			map.put(name, value + sold.getSoldAmount());
		}

		// Создание отсортированного множества
		LinkedHashMap<String, Integer> sorted_map = new LinkedHashMap<>();
		map.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEachOrdered(x -> sorted_map.put(x.getKey(), x.getValue()));

		// Вывод для проверки
		// for (Map.Entry<String, Integer> entry : sorted_map.entrySet()) {
		// System.out.println("Key: " + entry.getKey() + " Value: "
		// + entry.getValue());
		// }

		// Создание 5 классов для вывода в файл
		FirstTask[] ft = new FirstTask[5];
		int it = 0;
		// Внесение данных в 5 классов из отсортированного множества
		for (Map.Entry<String, Integer> entry : sorted_map.entrySet()) {
			ft[it] = new FirstTask();
			ft[it].setGoodsName((String) entry.getKey());
			ft[it].setAmount((int) entry.getValue());

			it++;
			if (it == 5 || it == sorted_map.size())
				break;
		}

		// Вывод топ 5 товаров с наибольшим количеством продаж в файл
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (Writer writer = new FileWriter(("output/firstTaskResult.json"))) {
			gson.toJson(ft, writer);
			writer.close();
			System.out.println("Первый выходной файл успешно создан.");
		} catch (IOException ex) {
			System.out.println("Ошибка! Не удалось записать выходной файл.");
		}
	}

	/**
	 * Метод для выполнения второй задачи по варианту:
	 * Вывести в файл среднее количество проданных товаров в день
	 * 
	 * @param solds - массив продаж
	 */
	public static void secondTask(SoldAmount[] solds) {
		// Создание Map для хранения даты и среднего количества продаж
		Map<Date, Double> avg = Stream.of(solds)
				.collect(Collectors.groupingBy(SoldAmount::getDate, Collectors.averagingDouble(SoldAmount::getSoldAmount)));
		// Создание отсортированного множества
		LinkedHashMap<Date, Double> sorted_map = new LinkedHashMap<>();
		avg.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
				.forEachOrdered(x -> sorted_map.put(x.getKey(), x.getValue()));

		// Создание списка классов для вывода в файл
		ArrayList<SecondTask> arr = new ArrayList<>();
		for (Map.Entry<Date, Double> entry : sorted_map.entrySet()) {
			SecondTask task = new SecondTask();
			arr.add(task);
			task.setDate((Date) entry.getKey());
			task.setAverageSold((double) entry.getValue());
		}

		// Вывод среднего количества проданных товаров по дням
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (Writer writer = new FileWriter(("output/secondTaskResult.json"))) {
			gson.toJson(arr, writer);
			writer.close();
			System.out.println("Второй выходной файл успешно создан.");
		} catch (IOException ex) {
			System.out.println("Ошибка! Не удалось записать выходной файл.");
		}

	}
}