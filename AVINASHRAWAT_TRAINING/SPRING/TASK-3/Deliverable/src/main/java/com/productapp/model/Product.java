package com.productapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
	
	private String productName;
	private Integer productId;
	private double price;
	private String category;
	
	public Product(String productName, double price, String category) {
		super();
		this.productName = productName;
		this.price = price;
		this.category = category;
	}
	
	
	
}
