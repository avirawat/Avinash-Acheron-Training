package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.repository.IProductRepository;


@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	IProductRepository productReository;
	
	public void setProductReository(IProductRepository productReository) {
		this.productReository = productReository;
	}
	
	@Override
	public void addProduct(Product product) {
		productReository.addProduct(product);
	}

	@Override
	public void updateProduct(int productId, double price) {
		productReository.updateProduct(productId, price);
		
	}

	@Override
	public void deleteProduct(int productId) {
		productReository.deleteProduct(productId);
		
	}

	@Override
	public Product getById(int productid) throws ProductNotFoundException {
		Product product=productReository.findById(productid);
		if(product==null) {
			throw new ProductNotFoundException("id not found");
		}
		return product;
	}

	@Override
	public List<Product> getAll() {
		return productReository.findAll();
		
	}

	@Override
	public List<Product> getByCategory(String category) throws ProductNotFoundException {
		List<Product> bookByCategory=productReository.findByCategory(category);
		if(bookByCategory.isEmpty()) {
			throw new ProductNotFoundException("Category not found");
		}
		return bookByCategory;
	}

	@Override
	public List<Product> getByLessPrice(double price) throws ProductNotFoundException {
		List<Product> bookByLessPrice=productReository.getByLessPrice(price);
		if(bookByLessPrice.isEmpty()) {
			throw new ProductNotFoundException("book not found");
		}
		return bookByLessPrice;
	}

	
	

}
