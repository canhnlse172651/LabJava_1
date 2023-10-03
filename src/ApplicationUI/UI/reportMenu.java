package ApplicationUI.UI;

import java.util.Scanner;

import ApplicationUI.uitilities.DataInput;
import ApplicationUI.uitilities.Validation;
import BussinessLayer.Service.IReportService;
import BussinessLayer.Service.ReportService;
import DatalayerProductDao.IProductDao;
import DatalayerProductDao.ProductDao;

public class reportMenu {
	public reportMenu() {

	}

	private IReportService reportService = new ReportService();

	private IProductDao irProductDao = ProductDao.getProductDao();

	static Scanner sc = new Scanner(System.in);

	public void ShowMenu() {

		int choice = 0;
		try {
			do {
				System.out.println("1. Products that have expired");
				System.out.println("2. The products that the store is selling");
				System.out.println("3. Products that are running out of stock (sorted in ascending order)");
				System.out.println("4. Import/export receipt of a product");
				System.out.println("5. exit");
				System.out.print("Enter yout choice : ");
				choice = Integer.parseInt(sc.nextLine());

				switch (choice) {
				case 1 -> {
					showProductExpired();

				}
				case 2 -> {
					showProductSelling();

				}
				case 3 -> {
					productStock();
				}
				case 4 -> {
					showReceiptProduct();
				}
				}
			} while (choice != 5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void showReceiptProduct() {
		boolean tmp = true;

		while (tmp) {
			String code = Validation.inputCode();
			reportService.showReceiptProduct(code);
			String option = DataInput.getString("Do you want to continous show it ?  Y/N:");
			if (option.equalsIgnoreCase("Y")) {
				tmp = true;
			} else {
				tmp = false;
			}
		}

	}

	private void productStock() {

		reportService.ProductStock(irProductDao.getList());

	}

	private void showProductSelling() {
		// TODO Auto-generated method stub
		reportService.showProductSelling(irProductDao.getList());

	}

	public void showProductExpired() {
		reportService.showProductExpired(irProductDao.getList());
	}

}
