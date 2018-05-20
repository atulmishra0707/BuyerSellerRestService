package com.rest.dao;

import java.util.List;

import com.rest.persistence.Product;

public interface ProductDAO {

	public List<Product> getProducts(String category) ;

	public List<Product> getProducts(Integer minPrice,Integer maxPrice) ;
	
	public void buyProduct(Integer id);
}
