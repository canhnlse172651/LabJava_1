package DatalayerProductDao;

import java.util.List;

import BussinessLayer.Entity.Product;

public interface IProductDao {

	void newAdd(Product product) throws Exception;

	List<Product> getList();

	boolean deleteProduct(String code);

	boolean update(Product product);

	Product getProduct(String code);

	boolean saveToFile();
	
//	boolean deleteByName(String name);
	boolean deleteByQuanity(int a);
}
