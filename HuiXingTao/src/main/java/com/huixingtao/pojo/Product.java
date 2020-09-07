package com.huixingtao.pojo;

import java.io.Serializable;

public class Product implements Serializable{
	private String pname;
	private double price;
	
	public Product() {
		super();
	}
	public Product(String pname, double price) {
		super();
		this.pname = pname;
		this.price = price;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [pname=" + pname + ", price=" + price + "]";
	}
	
	
}
