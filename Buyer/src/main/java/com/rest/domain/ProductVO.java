package com.rest.domain;

import java.io.Serializable;

public class ProductVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String productName;
	private String category;
	private Integer price;
	private Integer stockNumber;
	private String remarks;
	
	
	public ProductVO(){
		
	}
	
	public ProductVO(Integer id, String category, Integer price, String productName, String remarks,
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getStockNumber() {
		return stockNumber;
	}
	public void setStockNumber(Integer stockNumber) {
		this.stockNumber = stockNumber;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
