package BussinessLayer.Entity;

import java.io.Serializable;

public class Product implements Comparable<Product> {

	private String code;
	private String name;
	private String manufacturingDate;
	private String expirationDate;
	private int quanity;

	public Product(String code, String name, String manufacturingDate, String expirationDate,int quanity) {
		super();
		this.code = code;
		this.name = name;
		this.manufacturingDate = manufacturingDate;
		this.expirationDate = expirationDate;
		this.quanity = quanity;
	}

	public Product() {

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(String manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}



	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}



	public String getFileLine() {
		return code+","+name+","+manufacturingDate+","+expirationDate+","+quanity;
	}


	@Override
	public String toString() {
		return "Product [code = " + code + ", name = " + name + ", manufacturingDate = " + manufacturingDate
				+ ", expirationDate = " + expirationDate + ", quanity = " + quanity + "]";
	}

	public void pase(String line) {
		String newLine[] = line.split(",");

		code = newLine[0];
		name = newLine[1];
		manufacturingDate = newLine[2];
		expirationDate = newLine[3];
		quanity = Integer.parseInt(newLine[4]);
	}

	@Override
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
		return this.getQuanity()-o.getQuanity();
	}

}
