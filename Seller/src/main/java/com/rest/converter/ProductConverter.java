package com.rest.converter;

import com.rest.domain.ProductVO;
import com.rest.persistence.Product;

public class ProductConverter {

	
	public static ProductVO convert(Product product){
		
		ProductVO pVO =  new ProductVO(product.getId(),product.getCategory(),product.getPrice(),product.getProductName(),
				product.getRemarks(),product.getStockNumber());
		return pVO;
	}
	
	public static Product convert(ProductVO productVO){
		Product product =  new Product(productVO.getId(),productVO.getCategory(),productVO.getPrice(),productVO.getProductName(),
				productVO.getRemarks(),productVO.getStockNumber());
		return product;
	}
}
