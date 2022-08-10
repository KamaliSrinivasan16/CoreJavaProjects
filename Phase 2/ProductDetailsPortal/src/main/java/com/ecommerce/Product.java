package com.ecommerce;

public class Product 
{
	private long Id;
	private String name;
	private float price;
	
	public Product(long id, String name, float price) {
		super();
		Id = id;
		this.name = name;
		this.price = price;
	}
	

	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	

}
