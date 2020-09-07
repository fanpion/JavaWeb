package com.huixingtao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huixingtao.pojo.Shoppinger;

public interface ShoppingerMapper {
	public Shoppinger get(String shoppingerId);
	public void setPicture(@Param("picturePath")String picturePath,@Param("id")String id);
	public int check(String username);
	public void add(Shoppinger shoppinger);
	
	// 用户管理模块
	List<Shoppinger> getList();
	void delete(String shoppingerId);
	void modify(@Param("shoppingerId")String shoppingerId,@Param("shoppingerPassword")String shoppingerPassword,@Param("shoppingerName")String shoppingerName);
}
