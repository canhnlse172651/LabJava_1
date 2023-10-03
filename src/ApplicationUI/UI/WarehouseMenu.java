package ApplicationUI.UI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ApplicationUI.uitilities.DataInput;
import BussinessLayer.Entity.ItemReceipt;
import BussinessLayer.Entity.Product;
import BussinessLayer.Entity.Warehouse;
import BussinessLayer.Service.IWarehouseService;
import BussinessLayer.Service.WarehouseService;
import DatalayerProductDao.IProductDao;
import DatalayerProductDao.ProductDao;

public class WarehouseMenu {

	static Scanner sc = new Scanner(System.in);
	IProductDao iProductDao = ProductDao.getProductDao();
	IWarehouseService iWarehouseService = new WarehouseService();

	public void showMenu() {

		int choice = 0;

		try {
			do {

				System.out.println("1. Create import receipt ");
				System.out.println("2. Create export receipt");
				System.out.println("3. Load data from File");
				System.out.println("4. Show all receipt item on warehouse");
				System.out.println("5. exit");

				choice = Integer.parseInt(sc.nextLine());

				switch (choice) {
				case 1 -> {
					createImportReceipt();
				}
				case 2 -> {
					createExportReceipt();
				}
				case 3 -> {
					loadDataFromFile();
				}
				case 4 -> {
					(new WarehouseService()).display();
				}
				}
			} while (choice != 5);
		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

	}

	private void loadDataFromFile() {
		// TODO Auto-generated method stub

	}

	private void createImportReceipt() {
		Warehouse warehouse = inputReceipt(Warehouse.IMPORT);
		iWarehouseService.addReceipt(warehouse);
	}

	private void createExportReceipt() {
		Warehouse warehouse = inputReceipt(Warehouse.EXPORT);
		iWarehouseService.addReceipt(warehouse);
	}

	private String getCode() {
		String code = "";

		int end_Code = iWarehouseService.getCountItem();

		if (end_Code > 999999) {
			System.out.println("warehouse information is full");
		}

		int number_zero = 7 - (end_Code + "").length();
		String med = "";
		for (int i = 1; i < number_zero; i++) {
			med += "0";
		}
		code += (med + end_Code);

		return code;
	}

	public Warehouse inputReceipt(String receiptType) {

		String code = getCode();

		// getTimesystem;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDateTime now = LocalDateTime.now();

		String importDate = dtf.format(now);

		// tạo một list product

		List<ItemReceipt> list = new ArrayList<>();

		Warehouse importWarehouse = null;

		while (true) {
			String productCode = DataInput.getString("Enter code of product to add on receipt ");
			Product product = iProductDao.getProduct(productCode.toUpperCase());

			if (product == null) {
				System.out.println("product does not exit");
			} else {

				try {

					for (ItemReceipt itemReceipt : list) {
						if (itemReceipt.getItemId().equals(product.getCode())) {
							throw new RuntimeException();
						}
					}

					int quanity = DataInput.getIntegerNumber("Enter your quanity: ");

					ItemReceipt itemReceipt = new ItemReceipt(code, product.getCode(), product.getName(), quanity);

					list.add(itemReceipt);

					System.out.println("Do you want to add more ? Y/N");
					String check = sc.nextLine();
					if (check.equalsIgnoreCase("Y")) {
						continue;
					}
					break;

				} catch (Exception e) {
				}

			}

		}
		importWarehouse = new Warehouse(code, receiptType, importDate, list);

		return importWarehouse;

	}
}
