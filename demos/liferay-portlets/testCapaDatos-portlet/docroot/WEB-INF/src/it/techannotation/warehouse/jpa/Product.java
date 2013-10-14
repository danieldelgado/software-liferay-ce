package it.techannotation.warehouse.jpa;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "warehouseproduct")
@Table(name = "product_tbl")
public class Product {

	@Id
	@Column(name = "product_id", nullable = false)
	private String product_id;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "price", nullable = false)
	private double price;

	@Column(name = "qtaAvailable", nullable = false)
	private double qtaAvailable;

	@ManyToOne(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST})
	@JoinColumn(name = "order_id", nullable = false)
	private Order order;

	public Product() {
	}

	public Product(String product_id, String description, double price,
			double qtaAvailable) {
		
		this.product_id = product_id;  
		this.description = description; 
		this.price = price;
		this.qtaAvailable = qtaAvailable;  
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getQtaAvailable() {
		return qtaAvailable;
	}

	public void setQtaAvailable(double qtaAvailable) {
		this.qtaAvailable = qtaAvailable;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
