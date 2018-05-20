package com.rest.dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.rest.persistence.Product;


public class ProductDAOImpl implements ProductDAO{


	private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);
	
	@Autowired(required=true)
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	public void addProduct(Product product) {
		logger.info("Adding Product");
		Session session=null;
		try{
			session = this.sessionFactory.openSession();		
			session.save(product);
			session.flush();
			logger.info("Product saved successfully");
			}
			catch(Exception ex){
				ex.printStackTrace();
			}finally{
				if(session !=null) 	session.close();
			}
		
	}

	public void updateProduct(Product product) {
		logger.info("Product update");
		Session session=null;
		try{
			session = this.sessionFactory.openSession();
			session.update(product);
			session.flush();
			logger.info("Product updated successfully");
			}
			catch(Exception ex){
				ex.printStackTrace();
			}finally{
				if(session !=null) 	session.close();
			}
		
	}

	public Product getProduct(Integer productId) {
		logger.info("Returning product");
		Session session=null;
		Product prod=null;
		try{
			session = this.sessionFactory.openSession();
			Criteria cr = session.createCriteria(Product.class);
			cr.add(Restrictions.eq("id", productId));
			List response= cr.list();
			if(response != null && !response.isEmpty()){
				prod=(Product) response.get(0);
			}
			}
			catch(Exception ex){
				ex.printStackTrace();
			}finally{
				if(session !=null) 	session.close();
				
			}
		return prod;
	}

	public List<Product> getAllProducts() {
		logger.info("Getting all products");
		List<Product> products=new ArrayList<Product>();
		Session session=null;
		try{
			session = this.sessionFactory.openSession();
			Criteria cr = session.createCriteria(Product.class);
			List response= cr.list();
			
			if(response != null && !response.isEmpty()){
				products=response;
			}
		}
			catch(Exception ex){
				ex.printStackTrace();
			}finally{
				if(session !=null) 	session.close();
			}
		return products;
	}

	public void delete(Product product) {
		logger.info("Deleting product with id" + product.getId());
		Session session=null;
		try{
			session = this.sessionFactory.openSession();
			session.delete(product);
			session.flush();
			logger.info("Product deleted successfully");
			}
			catch(Exception ex){
				ex.printStackTrace();
			}finally{
				if(session !=null) 	session.close();
			}
		
	}
}
