package com.rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rest.persistence.Product;


public class ProductDAOImpl implements ProductDAO{


	private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);
	
	
	@Override
	public List<Product> getProducts(String category) {
		logger.info("getProducts call based on category");
		List<Product> products= new ArrayList<Product>();
		
		Product prod1 =  new Product(1,"Electronics", 999, "iPhone X","Best Product in Market",6);
		Product prod2 =  new Product(2,"Electronics", 699, "iPhone 7","iPhone 7 Series",6);
		Product prod3 =  new Product(3,"Electronics", 799, "iPhone 8 Plus","Buy 1 get 1 BOGO applied.",6);
		products.add(prod1);
		products.add(prod2);
		products.add(prod3);
		return products;
	}

	@Override
	public List<Product> getProducts(Integer minPrice, Integer maxPrice) {
		logger.info("getProducts call based on price range");
		List<Product> products= new ArrayList<Product>();
		
		Product prod1 =  new Product(1,"Electronics", 999, "iPhone X","Best Product in Market",6);
		Product prod3 =  new Product(3,"Electronics", 799, "iPhone 8 Plus","Buy 1 get 1 BOGO applied.",6);
		products.add(prod1);
//		products.add(prod2);
		products.add(prod3);
		return products;
	}

	@Override
	public void buyProduct(Integer id) {
		logger.info("buyProduct call");
	}

	public Product getProductsById(Integer id) {
		
		Product prod1 =  new Product(1,"Electronics", 999, "iPhone X","Best Product in Market bought by you.",6);
		
 		return prod1;
	}
	
}
