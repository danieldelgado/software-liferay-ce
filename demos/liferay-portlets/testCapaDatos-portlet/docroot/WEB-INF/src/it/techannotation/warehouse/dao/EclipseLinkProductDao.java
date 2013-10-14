package it.techannotation.warehouse.dao;

import it.techannotation.warehouse.jpa.Order;
import it.techannotation.warehouse.jpa.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("ProductDao")
public class EclipseLinkProductDao implements ProductDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProducts() {

		Query query = em.createQuery("SELECT p FROM warehouseproduct p",
				Order.class);
		query.setHint("javax.persistence.cache.storeMode", "REFRESH");
		
		return query.getResultList();
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void insertProduct(int orderId, Product product) {
		Order order = em.find(Order.class, orderId);
		
		product.setOrder(order);
		
		order.getProducts().add(product);
		em.persist(order);
		
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteProduct(String productId) {
		
		Product product  = em.find(Product.class, productId);
		
		em.remove(product);
		
		em.getEntityManagerFactory().getCache().evict(Order.class);
		
	}
}
