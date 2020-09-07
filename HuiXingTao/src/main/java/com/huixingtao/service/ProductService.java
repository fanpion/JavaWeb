package com.huixingtao.service;

import java.util.List;

import com.huixingtao.pojo.Product;

public interface ProductService {
	List<Product> getList();
	Product getByPname(String pname);
	void add(Product product);
	void modify(String pname, String newProductName, double newProductPrice);
	void delete(String pname);
}
