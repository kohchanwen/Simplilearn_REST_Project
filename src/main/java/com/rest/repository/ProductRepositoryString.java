package com.rest.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rest.model.Product;

public interface ProductRepositoryString extends JpaRepository<Product, Long>{
	
	

	List<Product> findBySeason(String season);

	List<Product> findByBrand(String brand);

	List<Product> findByCategory(String category);

	List<Product> findByPrice(Integer price);

	List<Product> findByColor(String color);

	List<Product> findByCreatedDate(Date parsedDate);
	
	@Query("SELECT prod FROM ProductOrder po, Product prod WHERE po.productId = prod.productId")
	List<Product> findByProductOrderDetails();
	
}
