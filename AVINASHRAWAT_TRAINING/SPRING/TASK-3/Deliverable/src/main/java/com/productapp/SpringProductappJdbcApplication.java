package com.productapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.model.Product;
import com.productapp.service.IProductService;

@SpringBootApplication
public class SpringProductappJdbcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringProductappJdbcApplication.class, args);
	
	}
	@Autowired
	IProductService productService;
	
	@Override
	public void run(String... args) throws Exception {
		
		//Product product=new Product("Pencil",8000,"Gadgets");
//		System.out.println(product.getProductName());
		//productService.addProduct(product);
		//productService.updateProduct(1, 10000);
		//productService.deleteProduct(3);
		productService.getAll().forEach(System.out::println);
		System.out.println(productService.getById(1));
		productService.getByCategory("Gadgets").forEach(System.out::println);
		productService.getByLessPrice(10000).forEach(System.out::println);
		
	}

}
