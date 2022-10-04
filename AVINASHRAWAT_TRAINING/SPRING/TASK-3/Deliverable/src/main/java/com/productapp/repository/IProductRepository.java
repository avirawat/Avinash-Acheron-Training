package com.productapp.repository;

import java.util.List;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;

public interface IProductRepository {
	
	void addProduct(Product product);
	void updateProduct(int productId,double price);
	void deleteProduct(int productId);
	
	Product findById(int productid) throws ProductNotFoundException;
	List<Product>findAll();
	List<Product>findByCategory(String category) throws ProductNotFoundException;
	List<Product>getByLessPrice(double price) throws ProductNotFoundException;
}
