package BussinessLayer.Entity;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {

	public static String EXPORT = "EXPORT";
	public static String IMPORT = "IMPORT";

	private String code;
	private String time;
	private String type;

	private List<ItemReceipt> productList;

	public Warehouse() {
		productList = new ArrayList<>();
	}

	public Warehouse(String code, String receiptType, String time, List<ItemReceipt> productList) {
		super();
		this.type = receiptType;
		this.code = code;
		this.time = time;
		this.productList = productList;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<ItemReceipt> getProductList() {
		return productList;
	}

	public void setProductList(List<ItemReceipt> productList) {
		this.productList = productList;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {

		String result = type + "," + code + "," + time +","+productList.toString();

		return result;
	}

	public String itemsToRawData() {

		String result = "";

		for (ItemReceipt item : productList) {
			result += item.toRawData() + "\n";
		}

		return result;
	}
	public String receiptToRaw() {
		return type+","+code+","+time + "\n";

	}

	public void pare(String line) {
		String newLine[] = line.split(",");

		type = newLine[0];
		code = newLine[1];
		time = newLine[2];

	}

	public void addItem(ItemReceipt item) {
		productList.add(item);
	}

}
