package it.techannotation.warehouse.dao;

import it.techannotation.warehouse.jpa.Product;

import java.util.List;

public interface ProductDao {
	public List<Product> getProducts();	
	public void insertProduct(int orderId, Product product);
	public void deleteProduct(String productId);
}
