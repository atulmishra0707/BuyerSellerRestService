package com.rest.service;

import java.util.List;

import com.rest.domain.ProductVO;



public interface BuyerService {
 
	public List<ProductVO> getProducts(String category) ;

	public List<ProductVO> getProducts(Integer minPrice,Integer maxPrice) ;
	
	public void buyProduct(Integer id);

	ProductVO getProductsById(Integer id);
	
}
