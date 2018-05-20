package com.rest.service;


import com.rest.domain.ProductListVO;
import com.rest.domain.ProductVO;



/*#1. To add a new Product
#2. To update details(like Price, stock,etc...) of an existing Product
#3. To view details of one or more products of this Seller.
#4. To delete a Product
*/

public interface SellerService {
 
	public void addProduct(ProductVO product);
	public void updateProduct(ProductVO product);
	public ProductVO getProduct(Integer productId);
	public ProductListVO getAllProducts();
	public void deleteProduct(ProductVO productVO);
	
}
