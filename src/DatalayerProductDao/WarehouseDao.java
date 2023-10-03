package DatalayerProductDao;

import java.util.ArrayList;
import java.util.List;

import BussinessLayer.Entity.ItemReceipt;
import BussinessLayer.Entity.Warehouse;
import FileManager.FileManager;
import FileManager.IFileManager;

//import BussinessLayer.Entity.ProductReceipt;

public class WarehouseDao implements IWarehouseDao {

	public ArrayList<Warehouse> receiptList = new ArrayList<>();

	private static final IWarehouseDao warehouseDao = new WarehouseDao();

	private static final String FILE_RECEIPT_STORE_NAME = "warehouse.txt";

	private static final String FILE_ITEM_STORE_NAME = "itemreceipt.txt";

	private IFileManager receiptFileManagerFile;

	private IFileManager itemFileManager;

	public static IWarehouseDao getWarehouseDao() {
		return warehouseDao;
	}

	public WarehouseDao() {
		try {
			receiptFileManagerFile = new FileManager(FILE_RECEIPT_STORE_NAME);

			itemFileManager = new FileManager(FILE_ITEM_STORE_NAME);

			loadDataFromFile();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void loadDataFromFile() throws Exception {
		List<String> rawList = receiptFileManagerFile.readDataFromFile();

		for (String raw : rawList) {

			Warehouse warehouse = new Warehouse();

			warehouse.pare(raw);

			receiptList.add(warehouse);

		}

		rawList = itemFileManager.readDataFromFile();

		for (String raw : rawList) {
			String[] components = raw.split(",");

			String receiptCode = components[0];  

			String itemCode = components[1];
			String name = components[2];
			int quanity = Integer.parseInt(components[3]);

			ItemReceipt item = new ItemReceipt(receiptCode, itemCode, name, quanity);

			for (Warehouse w : receiptList) {

				if (w.getCode().equals(receiptCode)) {
					w.addItem(item);
					break;
				}

			}
		}

	}

	@Override
	public boolean saveToFile() throws Exception {
		// TODO Auto-generated method stub
		List<String> rawList = new ArrayList<>();

		try {

			for (Warehouse item : receiptList) {

				rawList.add(item.receiptToRaw());

			}
			receiptFileManagerFile.commitFile(rawList);

			rawList = new ArrayList<>();

			for (Warehouse item : receiptList) {
				rawList.add(item.itemsToRawData());
			}
			itemFileManager.commitFile(rawList);

			return true;

		} catch (Exception e) {

			return false;
		}

	}

	@Override
	public boolean addReceipt(Warehouse warehouse) {
		return receiptList.add(warehouse);
	}

	@Override
	public List<Warehouse> getListWarehouses() {

		return receiptList;
	}

	@Override
	public ItemReceipt getProductInWarehouse(String itemCode) {

		for (Warehouse receipt : receiptList) {
			List<ItemReceipt> list = receipt.getProductList();
			for (ItemReceipt p1 : list) {
				if (p1.getItemId().equals(itemCode)) {
					return p1;
				}
			}
		}

		return null;
	}

	@Override
	public List<ItemReceipt> getItemReceiptListInWarehouse(String itemCode) {

		List<ItemReceipt> itemList = new ArrayList<>();

		for (Warehouse receipt : receiptList) {
			List<ItemReceipt> list = receipt.getProductList();
			for (ItemReceipt p1 : list) {
				if (p1.getItemId().equals(itemCode)) {
					itemList.add(p1);
				}
			}
		}

		return itemList;
	}

	@Override
	public int getCountItem() {
		return receiptList.size();
	}

}
