package DatalayerProductDao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ApplicationUI.uitilities.Validation;
import BussinessLayer.Entity.ItemReceipt;
import BussinessLayer.Entity.Product;

public class ReportDao implements IReportDao {
	private IProductDao iProductDao = ProductDao.getProductDao();
	private IWarehouseDao iWarehouseDao = WarehouseDao.getWarehouseDao();

	
	public ReportDao() {

	}

	@Override
	public List<Product> showProductExpired(List<Product> list) {
		List<Product> newList = new ArrayList<>();
		for (Product product : list) {
			if (Validation.beforeDay(product.getManufacturingDate(), product.getExpirationDate()) > 0) {
				newList.add(product);
			}
		}

		return newList;
	}

	@Override
	public List<Product> showProductSelling(List<Product> list) {
		List<Product> newList = new ArrayList<>();

		for (Product product : list) {
			if (Validation.beforeDay(product.getManufacturingDate(), product.getExpirationDate()) <= 0
					&& product.getQuanity() > 0) {
				newList.add(product);
			}
		}

		return newList;
	}

	@Override
	public List<Product> productStock(List<Product> list) {

		List<Product> newList = new ArrayList<>();

		for (Product product : list) {
			
			if (product.getQuanity() <= 3) {
				newList.add(product);
			}
		}

		Collections.sort(newList, new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {
				return o1.getQuanity() - o2.getQuanity();
			}

		});

		return newList;
		

	}

	@Override
	public List<ItemReceipt> getItemReceiptListInWarehouse(String code) {
		return iWarehouseDao.getItemReceiptListInWarehouse(code);
	}
}
