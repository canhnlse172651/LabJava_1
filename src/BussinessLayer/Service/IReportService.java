package BussinessLayer.Service;

import java.util.List;

import BussinessLayer.Entity.Product;

public interface IReportService {

	void showProductExpired(List<Product> list);

	void showProductSelling(List<Product> list);

	void ProductStock(List<Product> list);

	void showReceiptProduct(String code);


}
