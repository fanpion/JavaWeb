package com.huixingtao.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huixingtao.pojo.Shoppinger;

public interface ShoppingerService {
	Shoppinger get(String shoppingerId);
	public void setPicture(String picturePath,String id);
	int check(String username);
	void add(Shoppinger shoppinger);
	
	// 用户管理模块
	List<Shoppinger> getList();
	void delete(String shoppingerId);
	void modify(String shoppingerId,String shoppingerPassword,String shoppingerName);
}
