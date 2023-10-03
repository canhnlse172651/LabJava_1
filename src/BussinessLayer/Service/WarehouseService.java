package BussinessLayer.Service;

import java.util.ArrayList;
import java.util.List;

import BussinessLayer.Entity.Warehouse;
import DatalayerProductDao.IWarehouseDao;
import DatalayerProductDao.WarehouseDao;

//import BussinessLayer.Entity.ProductReceipt;

public class WarehouseService implements IWarehouseService {

	IWarehouseDao warehouseDao = WarehouseDao.getWarehouseDao();

	@Override
	public void addReceipt(Warehouse warehouse) {

		if(warehouse==null) {
			System.out.println("Receeipt not is null");
		}else {
			warehouseDao.addReceipt(warehouse);
			System.out.println("Add sucsessfully ");
		}
	}

	@Override
	public List<Warehouse> getExportReceipt() {
		List<Warehouse> exportList = new ArrayList<>();

		for (Warehouse w : warehouseDao.getListWarehouses()) {

			if (w.getType() == Warehouse.EXPORT) {
				exportList.add(w);
			}
		}

		return exportList;
	}

	@Override
	public List<Warehouse> getImportReList() {
		List<Warehouse> exportList = new ArrayList<>();

		for (Warehouse w : warehouseDao.getListWarehouses()) {

			if (w.getType() == Warehouse.IMPORT) {
				exportList.add(w);
			}
		}

		return exportList;
	}

	public void display() {

		for (Warehouse w : warehouseDao.getListWarehouses()) {
			System.out.println(w.toString());
		}

	}

	@Override
	public int getCountItem() {
		return warehouseDao.getCountItem();
	}
	
	
//	
	public void save() throws Exception {
		boolean isResult = warehouseDao.saveToFile();

		if (isResult) {
                 System.out.println("Save file sucsess");
		} else {
              System.out.println("Save faild");
		}
	}

}
