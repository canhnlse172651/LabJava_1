package BussinessLayer.Service;

import java.util.List;

import BussinessLayer.Entity.ItemReceipt;
import BussinessLayer.Entity.Product;
import DatalayerProductDao.IReportDao;
import DatalayerProductDao.ReportDao;

public class ReportService implements IReportService {
	IReportDao iReportDao = new ReportDao();

	public ReportService() {

	}

	@Override
	public void showProductExpired(List<Product> list) {
		// TODO Auto-generated method stub
		List<Product> newList = iReportDao.showProductExpired(list);

		for (Product product : newList) {
			System.out.println(product.toString());
		}

	}

	@Override
	public void showProductSelling(List<Product> list) {
		List<Product> newList = iReportDao.showProductSelling(list);

		for (Product product : newList) {
			System.out.println(product.toString());
		}

	}

	@Override
	public void ProductStock(List<Product> list) {
		List<Product> newList = iReportDao.productStock(list);
		if (newList.isEmpty()) {
			System.out.println("No product that has quanity less than 3");
		}

		for (Product product : newList) {
			System.out.println(product.toString());
		}

	}

	@Override
	public void showReceiptProduct(String code) {
		List<ItemReceipt> itemList = iReportDao.getItemReceiptListInWarehouse(code);
		if (itemList.isEmpty()) {
			System.out.println("Item not found !!");
		} else {

			for (ItemReceipt item : itemList) {
				System.out.println(item.toString());
			}
		}
	}
}
