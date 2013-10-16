package com.vst.spring.service;

import java.util.List;

import com.vst.spring.jpa.Product;

public interface ProductService {

	public List<Product> getProducts();
	
	public void insertProduct(int orderId, Product product) ;
	
	public void deleteProduct(String productId);
	
}
