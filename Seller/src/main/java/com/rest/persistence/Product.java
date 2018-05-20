package com.rest.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*a) Product Name
b) Product ID(should be unique)
c) Product Category
d) price
c) Current stock numbers
d) Remarks*/

@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_id")
	private Integer id;
	
	private String productName;
	private String category;
	private Integer price;
	private Integer stockNumber;
	private String remarks;
	
	public Product(){
		
	}
	
	public Product(Integer id, String category, Integer price, String productName, String remarks,
			Integer stockNumber) {
		this.id=id;
		this.category=category;
		this.price=price;
		this.productName=productName;
		this.remarks=remarks;
		this.stockNumber=stockNumber;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getStockNumber() {
		return stockNumber;
	}
	public void setStockNumber(Integer stockNumber) {
		this.stockNumber = stockNumber;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	
}
