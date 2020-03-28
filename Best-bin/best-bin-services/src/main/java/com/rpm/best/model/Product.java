package com.rpm.best.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3154778466915946709L;

	@Id
	private int productId;
	
	private String productName;
	
	private double price;
	
	private String description;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
