package com.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.domain.ProductListVO;
import com.rest.domain.ProductVO;
import com.rest.service.ApiService;
import com.rest.service.ApiServiceImpl;

/*public List<ProductVO> getProducts(String category) ;
public List<ProductVO> getProducts(Integer minPrice,Integer maxPrice) ;	
public void buyProduct(Integer id);
public ProductVO getProductsById(Integer id);
public void addProduct(ProductVO product);
public void updateProduct(ProductVO product);
public ProductVO getProduct(Integer productId);
public ProductListVO getAllProducts();
public void deleteProduct(ProductVO productVO);*/

/*<td></td>
<td><a href="addProduct">Add a product</a></td>
</tr>
<tr>
<td></td>
<td><a href="updateProduct" >Update a product</a></td>
</tr>
<tr>
<td></td>
<td><a href="getProducts">Get Products</a>
</td>
<td></td>
<td><a href="deleteProduct">Delete a Product</a></td>
</tr>
<tr>
<td></td>
<td><a href="categoryBasedProduct" >Get category based Product</a></td>
</tr>
<tr>
<td></td>
<td><a href="priceBasedProduct">Get price based product</a>
</td>
<td></td>
<td><a href="buyProduct">Buy a product</a></td>
</tr>
</tr>*/

@RestController
public class ApiController {

	private ApiService service=new ApiServiceImpl();
	
	
	@RequestMapping(value="/categoryBasedProduct",method=RequestMethod.GET)
	public ResponseEntity<List<ProductVO>> getCategoryBasedProducts(){
		return service.getCategoryBasedProducts("Electronics");
	}
	
	@RequestMapping(value="/priceBasedProduct",method=RequestMethod.GET)
	public ResponseEntity<List<ProductVO>> getProductsInPriceRange(){
		return service.getPriceBasedProducts(600, 800);
	}
	
	@RequestMapping(value="/buyProduct",method=RequestMethod.GET)
	public ResponseEntity<ProductVO> buyProduct(){
		return service.buyProduct(1);
	}
	
	
	
	
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public ResponseEntity<Void> addProduct(){
		ProductVO prod1 =  new ProductVO(4,"Electronics", 999, "iPhone X Plus","Best Product in Market",6);
		return service.addProduct(prod1);
	}
	
	 //------------------- Update a Product --------------------------------------------------------
    
    @RequestMapping(value = "/updateProduct", method = RequestMethod.GET)
    public ResponseEntity<ProductVO> updateProduct() {
    	ProductVO prod1 =  new ProductVO(4,"Electronics", 999, "iPhone X Plus","Best Product in Market",15);
		return service.updateProduct(prod1);

    }
    
    
    //-------------------Retrieve All Products--------------------------------------------------------
    @RequestMapping(value = "/getProducts", method = RequestMethod.GET,produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ProductListVO> listAllProducts() {
    	return service.getAllProducts();
    }
    

  //------------------- Delete a Product --------------------------------------------------------
    
    @RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
    public ResponseEntity<ProductVO> deleteProduct() {
    	return service.deleteProduct(4);      
    }
	
    @RequestMapping(value = "/getProductUsingId", method = RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ProductVO> getProduct() {
    	      return service.getProduct(3) ;
    }
}
