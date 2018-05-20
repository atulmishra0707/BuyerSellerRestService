package com.rest.service;


import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.rest.domain.ProductListVO;
import com.rest.domain.ProductVO;


public class ApiServiceImpl implements ApiService{

	
	protected RestTemplate restTemplate;
	private static final String baseBuyerUrl="http://localhost:8080/Buyer/"; 
	private static final String baseSellerUrl="http://localhost:8080/Seller/";
	public ApiServiceImpl() {
		restTemplate = new RestTemplate();
	}

protected HttpEntity<?> getHttpEntity() {
	return new HttpEntity<ProductVO>(getHttpHeaders());
}

protected HttpHeaders getHttpHeaders() {
	HttpHeaders requestHeaders = new HttpHeaders();
	//requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	//	requestHeaders.set("Authorization", "Basic ABC==");
	String auth = "admin" + ":" + "root123";
    byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes());
    String authHeader = "Basic " + new String( encodedAuth );
    requestHeaders.set("Authorization", authHeader);
	return requestHeaders;
}

	public ResponseEntity<Void> addProduct(ProductVO prod1) {
		String url= baseSellerUrl + "products/product";
		HttpEntity<ProductVO> httpEntity = new HttpEntity<>(prod1, getHttpHeaders());
		ResponseEntity<Void> result = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Void.class);
		return result;
	}

	public ResponseEntity<ProductVO> updateProduct(ProductVO product) {
		String url= baseSellerUrl + "products/product/" + product.getId();
		HttpEntity<ProductVO> httpEntity = new HttpEntity<>(product, getHttpHeaders());
		
		ResponseEntity<ProductVO> result = restTemplate.exchange(url, HttpMethod.PUT, httpEntity, ProductVO.class);
		return result;
		
	}

	public ResponseEntity<ProductVO> getProduct(Integer productId) {
     	String url= baseSellerUrl + "products/product/"+ productId;
		ResponseEntity<ProductVO> result=restTemplate.exchange(url, HttpMethod.GET, getHttpEntity(), ProductVO.class);
		return result;
	}

	public ResponseEntity<ProductListVO> getAllProducts() {
		String url= baseSellerUrl + "products";
		ResponseEntity<ProductListVO> result=restTemplate.exchange(url, HttpMethod.GET, getHttpEntity(), ProductListVO.class);
		return result;
	}

	public ResponseEntity<ProductVO> deleteProduct(Integer id) {
		String url= baseSellerUrl + "/products/product/" + id;
		ResponseEntity<ProductVO> result=restTemplate.exchange(url, HttpMethod.DELETE, getHttpEntity(), ProductVO.class);
		return result;
		
	}

	@Override
	public ResponseEntity<List<ProductVO>> getCategoryBasedProducts(String category) {
		String url= baseBuyerUrl + "products?category=" + category;
		ResponseEntity<ProductVO[]> result=restTemplate.exchange(url, HttpMethod.GET, getHttpEntity(), ProductVO[].class);
		List<ProductVO> productList= Arrays.asList(result.getBody());
		return new ResponseEntity<List<ProductVO>>(productList,result.getStatusCode());
	}

	@Override
	public ResponseEntity<List<ProductVO>> getPriceBasedProducts(Integer minPrice, Integer maxPrice) {
		String url= baseBuyerUrl + "products?minprice=" + minPrice + "&maxprice=" + maxPrice;
		ResponseEntity<ProductVO[]> result=restTemplate.exchange(url, HttpMethod.GET, getHttpEntity(), ProductVO[].class);
		List<ProductVO> productList= Arrays.asList(result.getBody());
		return new ResponseEntity<List<ProductVO>>(productList,result.getStatusCode());
	}
	
	@Override
	public ResponseEntity<ProductVO> buyProduct(Integer id) {
		String url= baseBuyerUrl + "products/buyproduct/" + id;
		HttpEntity<ProductVO> httpEntity = new HttpEntity<>(getHttpHeaders());
		ResponseEntity<ProductVO> result = restTemplate.exchange(url, HttpMethod.PUT, httpEntity, ProductVO.class);
		return result;
	}

}
