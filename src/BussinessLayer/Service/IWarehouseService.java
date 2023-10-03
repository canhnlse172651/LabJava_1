package BussinessLayer.Service;

import java.util.List;

import BussinessLayer.Entity.Warehouse;

//import org.ietf.jgss.Oid;

//import BussinessLayer.Entity.ProductReceipt;

public interface IWarehouseService {
	void addReceipt(Warehouse warehouse);

	int getCountItem();

	List<Warehouse> getExportReceipt();

	List<Warehouse> getImportReList();
}
