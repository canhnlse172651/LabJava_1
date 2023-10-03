package DatalayerProductDao;

import java.util.List;

import BussinessLayer.Entity.ItemReceipt;
import BussinessLayer.Entity.Product;

public interface IReportDao {
	List<Product> showProductExpired(List<Product> list);

	List<Product> showProductSelling(List<Product> list);

	List<Product> productStock(List<Product> list);

	List<ItemReceipt> getItemReceiptListInWarehouse(String code);
}
