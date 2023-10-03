package ApplicationUI.UI;

import ApplicationUI.uitilities.DataInput;
import BussinessLayer.Service.ProductService;
import BussinessLayer.Service.WarehouseService;
import DatalayerProductDao.IProductDao;
import DatalayerProductDao.IWarehouseDao;
import DatalayerProductDao.ProductDao;
import DatalayerProductDao.WarehouseDao;

public class FileMenu {
	IProductDao iProductDao = ProductDao.getProductDao();

	IWarehouseDao iWarehouseDao = WarehouseDao.getWarehouseDao();

	public void showMenu() {

		int choice = 0;
		try {
			do {
				System.out.println("1. Save File Product");
				System.out.println("2. Save File Warehouse");
				System.out.println("3. Exit ! back main manu.");
				System.out.println("Enter your choice : ");
				choice = DataInput.getIntegerNumber();

				switch (choice) {

				case 1 -> {
					saveFileProduct();
				}

				case 2 -> {
					saveProductWarehouse();
				}

				}
			} while (choice != 3);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void saveProductWarehouse() {
		try {
			(new WarehouseService()).save();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void saveFileProduct() {
		(new ProductService()).save();
	}
}
