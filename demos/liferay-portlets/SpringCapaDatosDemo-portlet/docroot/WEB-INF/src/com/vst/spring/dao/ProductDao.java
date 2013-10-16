package com.vst.spring.dao;

import java.util.List;

import com.vst.spring.jpa.Product;

public interface ProductDao {
	public List<Product> getProducts();	
	public void insertProduct(int orderId, Product product);
	public void deleteProduct(String productId);
}
