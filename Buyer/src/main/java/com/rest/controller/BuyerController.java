package com.rest.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.domain.ProductVO;
import com.rest.service.BuyerService;

/*#1. To List Products specific to a category
(a collection of Product objects need to be returned)

#2. To List products based on Price Range
(a collection of Product objects need to be returned)

#3. To buy a Product based on Product ID*/

@RestController
public class BuyerController {
	
	@Autowired(required=true)
	@Qualifier(value="buyerService")
	private BuyerService buyerService;

	Logger logger= Logger.getLogger(BuyerController.class);
	@RequestMapping(value="/products",params ="category",method=RequestMethod.GET)
	public ResponseEntity<List<ProductVO>> getProducts(@RequestParam("category") String category){		
		logger.info("Get Product Call based on category");
		ResponseEntity<List<ProductVO>> rs = null;
		List <ProductVO> prodlist = buyerService.getProducts(category);
		
		if(prodlist != null &&  prodlist.size() > 0){
			rs = new ResponseEntity<List<ProductVO>>(prodlist,HttpStatus.OK);
		}else{
			rs = new ResponseEntity<List<ProductVO>>(prodlist,HttpStatus.NOT_FOUND);
		}
		return rs;
	}
	
	@RequestMapping(value="/products",params = { "minprice", "maxprice" },method=RequestMethod.GET)
	public ResponseEntity<List<ProductVO>> getProductsInPriceRange(@RequestParam("minprice") Integer minPrice,@RequestParam("maxprice") Integer maxPrice){
		
		logger.info("Get getProductsInPriceRange Call");
		
		ResponseEntity<List<ProductVO>> rs = null;
		List <ProductVO> prodlist = buyerService.getProducts(minPrice, maxPrice);
		
		if(prodlist != null &&  prodlist.size() > 0){
			rs = new ResponseEntity<List<ProductVO>>(prodlist,HttpStatus.OK);
		}else{
			rs = new ResponseEntity<List<ProductVO>>(prodlist,HttpStatus.NOT_FOUND);
		}
		return rs;
	}
	
	@RequestMapping(value="/products/buyproduct/{id}",method=RequestMethod.PUT)
	public ResponseEntity<ProductVO> buyProduct(@PathVariable Integer id){
		
		logger.info("buyProduct Call");
		
		ResponseEntity<ProductVO> rs = null;
		ProductVO prod = buyerService.getProductsById(id);
		buyerService.buyProduct(id);
		if(prod != null){
			rs = new ResponseEntity<ProductVO>(prod,HttpStatus.OK);
		}else{
			rs = new ResponseEntity<ProductVO>(prod,HttpStatus.NOT_FOUND);
		}
		return rs;
	}
}
