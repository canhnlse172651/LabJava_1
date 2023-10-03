package DatalayerProductDao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import BussinessLayer.Entity.Product;
import FileManager.FileManager;
import FileManager.IFileManager;

public class ProductDao implements IProductDao {

	public final List<Product> productList = new ArrayList<>();

	private static final IProductDao productDao = new ProductDao();

	public static final String FILE_STORE_NAME = "product.txt";

	private IFileManager fileManager;

	public static IProductDao getProductDao() {
		return productDao;
	}

	public ProductDao() {
		try {
			fileManager = new FileManager(FILE_STORE_NAME);
			loadDataFromFile();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		Collections.sort(productList);
	}

	private void loadDataFromFile() throws Exception {

		
		List<String> rList = fileManager.readDataFromFile();

		for (String raw : rList) {
			Product aProduct = new Product();
			aProduct.pase(raw);
			productList.add(aProduct);
		}

	}

	@Override
	public boolean saveToFile() {
		try {
			ArrayList<String> rawList = new ArrayList<>();
			for (Product product : productList) {
				String line = product.getFileLine() + "\n";
				rawList.add(line);
			}
			fileManager.commitFile(rawList);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void newAdd(Product product) throws Exception {
		for (Product pd : productList) {
			if (pd.getCode().equalsIgnoreCase(product.getCode())) {
				throw new IllegalArgumentException("Product code is duplicated");
			}
		}

		productList.add(product);

	}

	@Override
	public List<Product> getList() {
		return productList;
	}

	@Override
	public boolean deleteProduct(String code) {
		// TODO Auto-generated method stub
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).getCode().equals(code)) {
				return productList.remove(i) != null;

			}

		}
		return false;

	}

	@Override
	public Product getProduct(String code) {
		for (Product product : productList) {
			if (product.getCode().equals(code)) {
				return product;
			}

		}
		return null;
	}

	@Override
	public boolean update(Product product) {
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).getCode().equals(product.getCode())) {
				return productList.set(i, product) != null;
			}
		}
		return false;
	}

	
	
	@Override
	public boolean deleteByQuanity(int quanity) {
		// TODO Auto-generated method stub
		boolean tmp = false;
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).getQuanity()==quanity) {
				return productList.remove(i) != null;

		
			}

		}
		return false;

	}

}
