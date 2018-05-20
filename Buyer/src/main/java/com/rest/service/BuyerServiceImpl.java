package com.rest.service;

import java.util.List;

import com.rest.converter.ProductConverter;
import com.rest.dao.ProductDAOImpl;
import com.rest.domain.ProductVO;
import com.rest.persistence.Product;



public class BuyerServiceImpl implements BuyerService {

	private ProductDAOImpl productDao;

	@Override
	public List<ProductVO> getProducts(String category) {
		List<Product> product=productDao.getProducts(category);
		if(product !=null)
			return ProductConverter.convert(product);
		
		return null;
	}

	@Override
	public List<ProductVO> getProducts(Integer minPrice, Integer maxPrice) {
		List<Product> product=productDao.getProducts(minPrice,maxPrice);
		if(product !=null)
			return ProductConverter.convert(product);
		return ProductConverter.convert(product);
	}
	
	@Override
	public ProductVO getProductsById(Integer id) {
		Product product=productDao.getProductsById(id);
		if(product !=null)
			return ProductConverter.convert(product);
		return ProductConverter.convert(product);
	}

	@Override
	public void buyProduct(Integer id) {
		productDao.buyProduct(id);
		
	}

	public ProductDAOImpl getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDAOImpl productDao) {
		this.productDao = productDao;
	}
	



	

}
