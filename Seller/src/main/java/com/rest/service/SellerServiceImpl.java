package com.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.rest.converter.ProductConverter;
import com.rest.dao.ProductDAOImpl;
import com.rest.domain.ProductListVO;
import com.rest.domain.ProductVO;
import com.rest.persistence.Product;



public class SellerServiceImpl implements SellerService {

	@Autowired(required=true)
	private ProductDAOImpl productDao;
	

	public ProductDAOImpl getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDAOImpl productDao) {
		this.productDao = productDao;
	}

	public void addProduct(ProductVO productVO) {
		Product product =ProductConverter.convert(productVO);
		productDao.addProduct(product);
		
	}

	public void updateProduct(ProductVO productVO) {
		Product product =ProductConverter.convert(productVO);
		productDao.updateProduct(product);
	}

	public ProductVO getProduct(Integer productId) {
		Product product =productDao.getProduct(productId);
		if(product !=null){
			return ProductConverter.convert(product);
		}
		return null;
	}

	public ProductListVO getAllProducts() {
		// TODO Auto-generated method stub
		List<Product> products= productDao.getAllProducts();
		List<ProductVO> productsVO= new ArrayList<ProductVO>();
		for(Product product:products){
			productsVO.add(ProductConverter.convert(product));
		}
		ProductListVO list =new ProductListVO();
		list.setProducts(productsVO);
		return list;
	}

	@Override
	public void deleteProduct(ProductVO productVO) {
		Product product =ProductConverter.convert(productVO);
		productDao.delete(product);
		
	}


	

}
