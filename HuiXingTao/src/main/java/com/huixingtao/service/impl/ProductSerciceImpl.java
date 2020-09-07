package com.huixingtao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huixingtao.mapper.ProductMapper;
import com.huixingtao.pojo.Product;
import com.huixingtao.service.ProductService;

@Service
public class ProductSerciceImpl implements ProductService {
	@Autowired
	ProductMapper productMapper;

	@Override
	public List<Product> getList() {
		return productMapper.getList();
	}

	@Override
	public Product getByPname(String pname) {
		return productMapper.getByPname(pname);
	}

	@Override
	public void add(Product product) {
		productMapper.add(product);
	}

	@Override
	public void delete(String pname) {
		productMapper.delete(pname);
	}

	@Override
	public void modify(String pname, String newProductName, double newProductPrice) {
		productMapper.modify(pname, newProductName, newProductPrice);
		
	}

}
