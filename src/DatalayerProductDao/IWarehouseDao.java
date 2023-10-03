package DatalayerProductDao;

import java.util.List;

import BussinessLayer.Entity.ItemReceipt;
import BussinessLayer.Entity.Warehouse;


public interface IWarehouseDao {


	boolean addReceipt(Warehouse warehouse);

	List<Warehouse> getListWarehouses();

	public ItemReceipt getProductInWarehouse(String itemCode);

	int getCountItem();

	List<ItemReceipt> getItemReceiptListInWarehouse(String itemCode);

	boolean saveToFile() throws Exception;
}
