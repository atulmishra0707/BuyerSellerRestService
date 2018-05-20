package com.rest.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="products")
public class ProductListVO implements Serializable{

	private static final long serialVersionUID = 1L;
    
    private List<ProductVO> products = new ArrayList<ProductVO>();
 
    public List<ProductVO> getProducts() {
        return products;
    }
 
    public void setProducts(List<ProductVO> products) {
        this.products = products;
    }
}
