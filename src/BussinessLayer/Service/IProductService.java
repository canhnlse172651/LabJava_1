package BussinessLayer.Service;

import BussinessLayer.Entity.Product;

public interface IProductService {
	void addProduct(Product product);

	void printList();

	void deleteProduct(String code);

	boolean update(Product product);

	Product getProduct(String code);

	void save();
	
//	void deleteByName(String name);
	void deleteByQuanity(int a);
}
