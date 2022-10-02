package com.rest.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Product;
import com.rest.repository.ProductRepository;
import com.rest.repository.ProductRepositoryString;

@RestController
@RequestMapping("products")
public class ProductController {
	@Autowired
	ProductRepository productrepository;
	@Autowired
	ProductRepositoryString productrepositorystring;

	// retrieve all products from database
	@GetMapping("all")
	public List<Product> getAllProduct() {
		List<Product> product = (List<Product>) productrepository.findAll();
		return product;
	}

	// insert new product into database
	@PostMapping("add")
	public Product addProduct(@RequestBody Product product) {
		return productrepository.save(product);
	}

	// get particular product by their ID
	@GetMapping("product/{id}")
	public Optional<Product> getProductId(@PathVariable int id) {
		return productrepository.findById(id);
	}

	// get products by their season
	@GetMapping("season")
	public List<Product> getProductBySeason(@RequestParam String season) {
		List<Product> product = (List<Product>) productrepositorystring.findBySeason(season);
		return product;
	}

	// get products by their brand
	@GetMapping("brand")
	public List<Product> getProductByBrand(@RequestParam String brand) {
		List<Product> product = (List<Product>) productrepositorystring.findByBrand(brand);
		return product;
	}

	// get products by their category
	@GetMapping("category")
	public List<Product> getProductByCategory(@RequestParam String category) {
		List<Product> product = (List<Product>) productrepositorystring.findByCategory(category);
		return product;
	}

	// get products by their price
	@GetMapping("price")
	public List<Product> getProductByPrice(@RequestParam String price) {
		List<Product> product = (List<Product>) productrepositorystring.findByPrice(price);
		return product;
	}

	// get products by their color
	@GetMapping("color")
	public List<Product> getProductByColor(@RequestParam String color) {
		List<Product> product = (List<Product>) productrepositorystring.findByColor(color);
		return product;
	}

	// get products by their createdDate
	@GetMapping("createdDate")
	public List<Product> getProductByCreatedDate(@RequestParam String createdDate) {
		 try {
			Date parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(createdDate);
			List<Product> product = (List<Product>) productrepositorystring.findByCreatedDate(parsedDate);
			return product;
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return null;
	}

	// update existing product
	@PutMapping("update/{id}")
	public Product updateProduct(@RequestBody Product product) {
		return productrepository.save(product);
	}

	// delete particular product from database
	@DeleteMapping("delete/{id}")
	public void deleteProduct(@PathVariable int id) {
		productrepository.deleteById(id);
	}
	
	@GetMapping("productDetail")
	public List<Product> getProductOrder() {
		List<Product> product = (List<Product>) productrepositorystring.findByProductOrderDetails();
		return product;
	}
	
	
}
