package com.huixingtao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huixingtao.pojo.Product;

public interface ProductMapper {
	List<Product> getList();
	Product getByPname(String pname);
	void add(Product product);
	void delete(String pname);
	void modify(@Param("pname")String pname, @Param("newProductName")String newProductName, @Param("newProductPrice")double newProductPrice);
}
