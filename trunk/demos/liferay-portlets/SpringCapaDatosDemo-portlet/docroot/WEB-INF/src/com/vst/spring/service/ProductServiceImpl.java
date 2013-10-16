package com.vst.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vst.spring.dao.ProductDao;
import com.vst.spring.dao.ProductDaoImpl;
import com.vst.spring.jpa.Product;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {

//	@BeanReference(name = "com.vst.spring.dao.ProductDaoImpl")
//	@Autowired
//	@Qualifier("ProductDao")
	private ProductDao productDao = new ProductDaoImpl();
	
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
