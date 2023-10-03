package BussinessLayer.Service;

import java.util.List;

import BussinessLayer.Entity.Product;
import DatalayerProductDao.IProductDao;
import DatalayerProductDao.IWarehouseDao;
import DatalayerProductDao.ProductDao;
import DatalayerProductDao.WarehouseDao;

public class ProductService implements IProductService {

	private IProductDao productDao = ProductDao.getProductDao();

	private IWarehouseDao iWarehouseDao = WarehouseDao.getWarehouseDao();

	@Override
	public void addProduct(Product product) {

		try {
			productDao.newAdd(product);
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

	@Override
	public void deleteProduct(String code) {
		Product product = productDao.getProduct(code);
		if (iWarehouseDao.getProductInWarehouse(product.getCode()) == null) {
			productDao.deleteProduct(code);
			System.out.println("Delete sucsess");
		} else {
			System.out.println("This product can not delete because it was exit on receipt ");
		}

	}

	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		productDao.update(product);
		return false;

	}

	@Override
	public Product getProduct(String code) {
		return productDao.getProduct(code);
	}

	@Override
	public void save() {
		boolean isResult = productDao.saveToFile();

		if (isResult) {
			System.out.println("Save file sucsess");
		} else {
			System.out.println("Save faild");
		}
	}

	@Override
	public void deleteByQuanity(int quanity) {
		// TODO Auto-generated method stub
		boolean tmp = true;
		while (tmp) {
			tmp = productDao.deleteByQuanity(quanity);
			if (!tmp)
				break;
		}

	}

	@Override
	public void printList() {
		// TODO Auto-generated method stub
		List<Product> list = productDao.getList();
		for (Product product : list) {
			System.out.println(product.toString());
		}

	}
}
