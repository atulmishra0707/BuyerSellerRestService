package com.rest.converter;

import java.util.ArrayList;
import java.util.List;

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
	
	public static List<ProductVO> convert(List<Product> products){
		List<ProductVO> productVOs= new ArrayList<ProductVO>();
		for(Product product:products){
			ProductVO pVO =  new ProductVO(product.getId(),product.getCategory(),product.getPrice(),product.getProductName(),
				product.getRemarks(),product.getStockNumber());
			productVOs.add(pVO);
		}
		return productVOs;
	}
}
