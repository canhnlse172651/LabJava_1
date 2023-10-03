package ApplicationUI.UI;

import java.util.Iterator;
import java.util.List;

import ApplicationUI.uitilities.DataInput;
import ApplicationUI.uitilities.Validation;
import BussinessLayer.Entity.ItemReceipt;
import BussinessLayer.Entity.Product;
import BussinessLayer.Service.IProductService;
import BussinessLayer.Service.ProductService;
import DatalayerProductDao.IWarehouseDao;
import DatalayerProductDao.WarehouseDao;

public class ProductMenu {

	private IProductService service = new ProductService();
	private IWarehouseDao iwareDao = WarehouseDao.getWarehouseDao();

	public void showMenu() {
		int choice = 0;
		try {
			do {
				System.out.println("1. Add product.");
				System.out.println("2. Update product information.");
				System.out.println("3. Delete product.");
				System.out.println("4. Show all product.");
				System.out.println("5. Exit ! back main manu.");
				System.out.println("6. Delete by name ");
				System.out.println("Enter your choice : ");
				choice = DataInput.getIntegerNumber();

				switch (choice) {

				case 1 -> {
					inputProduct();
				}

				case 2 -> {
					update();
				}

				case 3 -> {
					delete();
				}
				case 4 -> {
					displayAllProduct();

				}
				case 6 -> {
//						deleteByName();
					deleteByQuanity();
				}

				}
			} while (choice != 5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

//	
	private void deleteByQuanity() {
		// TODO Auto-generated method stub
		int quanity = DataInput.getIntegerNumber("Enter quanity");

		service.deleteByQuanity(quanity);

	}

	public void inputProduct() {

		String code = Validation.inputCode();
		String name = Validation.checkName();
		System.out.println("Enter manufacturingDate :");
		String manufacturingDate = Validation.validDay();
		System.out.println("Enter expirationDate : ");
		String expirationDate = Validation.validDay();

		int quanity = DataInput.getIntegerNumber("Enter your quanity: ");

		Product a = new Product(code, name, manufacturingDate, expirationDate, quanity);
		service.addProduct(a);
		System.out.println("Add product sucsess !!!!");
	}

	public void displayAllProduct() {
		service.printList();
	}

	public void delete() {
		String a = Validation.inputCode();
		service.deleteProduct(a);
	}

	public void update() {
		String code = Validation.inputCode();
		List<ItemReceipt> list = iwareDao.getItemReceiptListInWarehouse(code);

		Product oldProduct = service.getProduct(code);
		if (oldProduct == null) {
			System.out.println("Product does not exit");
		} else {

			String name = DataInput.getString("Enter your name: ");
			if (name.isBlank()) {
				name = oldProduct.getName();
			} else {
				for (ItemReceipt item : list) {
					item.setName(name);
				}
			}

			System.out.println("Enter new ManufacturingDate : ");
			String manufacturingDate = Validation.validDay();
			if (manufacturingDate.isBlank()) {
				manufacturingDate = oldProduct.getManufacturingDate();
			}

			System.out.println("Enter new expirationDate : ");
			String expirationDate = Validation.validDay();
			if (expirationDate.isBlank()) {
				expirationDate = oldProduct.getExpirationDate();
			}

			int quanity = -1;
			String checkString = DataInput.getString("Enter new product quanity : ");
			try {

				if (checkString.isBlank()) {
					quanity = oldProduct.getQuanity();
				} else {
					quanity = Integer.parseInt(checkString);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Product newProduct = new Product(oldProduct.getCode(), name, manufacturingDate, expirationDate, quanity);
			service.update(newProduct);

		}

	}

}
