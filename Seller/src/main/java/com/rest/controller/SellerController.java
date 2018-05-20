package com.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.domain.ProductListVO;
import com.rest.domain.ProductVO;
import com.rest.service.SellerService;

@RestController
public class SellerController {
	
	@Autowired(required=true)
	@Qualifier(value="sellerService")
	private SellerService sellerService;

	Logger logger = Logger.getLogger(SellerController.class);
	//-------------------Add a Product--------------------------------------------------------
	@RequestMapping(value = "/products/product", method = RequestMethod.POST)
	public ResponseEntity<Void> addProduct(@RequestBody ProductVO productVO){
		
		sellerService.addProduct(productVO);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	 //------------------- Update a Product --------------------------------------------------------
    
    @RequestMapping(value = "/products/product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ProductVO> updateProduct(@PathVariable("id") Integer id, @RequestBody ProductVO productVO) {
        logger.info("Updating Product " + id);
          
        ProductVO product = sellerService.getProduct(id);
          
        if (product==null) {
            logger.info("Product with id " + id + " not found");
            return new ResponseEntity<ProductVO>(HttpStatus.NOT_FOUND);
        }
  
        sellerService.updateProduct(productVO);
        return new ResponseEntity<ProductVO>(productVO, HttpStatus.OK);
    }
    
    //-------------------Retrieve Single Product--------------------------------------------------------
    
    @RequestMapping(value = "/products/product/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ProductVO> getProduct(@PathVariable("id") Integer id) {
    	logger.info("Fetching Product with id " + id);
        ProductVO productVO = sellerService.getProduct(id);
        if (productVO==null) {
            logger.info("Product with id " + id + " not found");
            return new ResponseEntity<ProductVO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ProductVO>(productVO, HttpStatus.OK);
       
    }
      
    
    //-------------------Retrieve All Products--------------------------------------------------------
    @RequestMapping(value = "/products", method = RequestMethod.GET,produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ProductListVO> listAllProducts() {
    	ProductListVO list = null;
    	list=sellerService.getAllProducts();
    	ResponseEntity<ProductListVO> response=null;
    	if(list != null ){
    		response=new ResponseEntity<ProductListVO>(list,HttpStatus.OK);
    	}else{
    		response=new ResponseEntity<ProductListVO>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	return response;
    }
    

  //------------------- Delete a Product --------------------------------------------------------
    
    @RequestMapping(value = "/products/product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ProductVO> deleteProduct(@PathVariable("id") Integer id) {
       logger.info("Fetching & Deleting Product with id " + id);
  
        ProductVO product = sellerService.getProduct(id);
        
        if (product==null) {
            System.out.println("Product with id " + id + " not found");
            return new ResponseEntity<ProductVO>(HttpStatus.NOT_FOUND);
        }
        sellerService.deleteProduct(product);
        return new ResponseEntity<ProductVO>(HttpStatus.OK);
        
    }
    
}
