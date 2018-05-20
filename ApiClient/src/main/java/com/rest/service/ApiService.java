package com.rest.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.rest.domain.ProductListVO;
import com.rest.domain.ProductVO;

/*#1. To add a new Product
#2. To update details(like Price, stock,etc...) of an existing Product
#3. To view details of one or more products of this Seller.
#4. To delete a Product


#1. To List Products specific to a category
(a collection of Product objects need to be returned)

#2. To List products based on Price Range
(a collection of Product objects need to be returned)

#3. To buy a Product based on Product ID*/

public interface ApiService {

	public ResponseEntity<List<ProductVO>> getCategoryBasedProducts(String category) ;
	public ResponseEntity<List<ProductVO>> getPriceBasedProducts(Integer minPrice,Integer maxPrice) ;	
	public ResponseEntity<ProductVO> buyProduct(Integer id);
	public ResponseEntity<Void> addProduct(ProductVO product);
	public ResponseEntity<ProductVO> updateProduct(ProductVO product);
	public ResponseEntity<ProductVO> getProduct(Integer productId);
	public ResponseEntity<ProductListVO> getAllProducts();
	public ResponseEntity<ProductVO> deleteProduct(Integer id);
}
