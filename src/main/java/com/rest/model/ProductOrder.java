package com.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.transaction.annotation.EnableTransactionManagement;

@Entity
@Table(name = "product_order")
@EnableTransactionManagement
public class ProductOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "productOrderId")
	private int productOrderId;
	
	@Column(name = "productId")
    private int productId;
	
	@Column(name = "userId")
    private int userId;
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductOrderId() {
		return productOrderId;
	}

	public void setProductOrderId(int productOrderId) {
		this.productOrderId = productOrderId;
	}
}
