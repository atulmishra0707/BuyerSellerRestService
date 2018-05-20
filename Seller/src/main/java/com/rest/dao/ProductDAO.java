package com.rest.dao;

import java.util.List;

import com.rest.persistence.Product;

public interface ProductDAO {

	public void addProduct(Product product);
		
	public void updateProduct(Product product);

	public Product getProduct(Integer productId);

	public List<Product> getAllProducts() ;

	public void delete(Product product);
}
