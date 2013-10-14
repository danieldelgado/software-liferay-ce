package it.techannotation.warehouse.service;

import java.util.List;

import it.techannotation.warehouse.dao.ProductDao;
import it.techannotation.warehouse.jpa.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductService {

	@Autowired
//	@Qualifier("ProductDao")
	private ProductDao productDao;
	
	public List<Product> getProducts() {
		return productDao.getProducts();
	}
	
	public void insertProduct(int orderId, Product product) {
		productDao.insertProduct(orderId, product);
	}
	
	public void deleteProduct(String productId) {
		productDao.deleteProduct(productId);
	}
	
}
