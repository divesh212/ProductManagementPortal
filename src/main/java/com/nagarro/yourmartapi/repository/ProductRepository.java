package com.nagarro.yourmartapi.repository;

import java.util.List;

import com.nagarro.yourmartapi.model.Product;

public interface ProductRepository {

	public void save(Product product);
	public Product getProduct(int id);
	public Product updateProduct(Product product);
	public void deleteProduct(int id);
	public List<Product> getAllProduct();
}