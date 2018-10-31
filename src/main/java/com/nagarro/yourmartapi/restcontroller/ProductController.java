package com.nagarro.yourmartapi.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.yourmartapi.model.Product;
import com.nagarro.yourmartapi.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/product")
	public List<Product> getAllProduct(@RequestParam(value="offset",required=false,defaultValue="0") int offset,
			   @RequestParam(value="limit",required=false,defaultValue="0") int limit,
			   @RequestParam(value="sortBy",required=false) String sortBy,
			   @RequestParam(value="searchKey",required=false) String searchKey,
			   @RequestParam(value="searchQuery",required=false) String searchQuery,
			   @RequestParam(value="status",required=false) String status,
			   @RequestParam(value="category",required=false) String category) {
		return productRepository.getAllProduct(offset,limit,sortBy,searchKey,searchQuery,status,category);
	}
	
	@PostMapping(path = "/product")
	public void addProduct(@RequestBody Product product) {
		System.out.println(product);
		productRepository.save(product);
	}
	
	@GetMapping(path="/product/{id}")
	public Product getProductById(@PathVariable("id") int id) {
		return productRepository.getProduct(id);
	}
	
	@PutMapping(path="/product/{id}")
	public Product updateProduct(@PathVariable("id") int id,@RequestBody Product product) {
		return productRepository.updateProduct(product);
	}
	
	@DeleteMapping(path="/product/{id}")
	public void deleteProduct(@PathVariable("id") int id) {
		productRepository.deleteProduct(id);
	}
}