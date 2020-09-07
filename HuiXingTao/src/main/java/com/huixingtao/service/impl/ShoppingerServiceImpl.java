package com.huixingtao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huixingtao.mapper.ShoppingerMapper;
import com.huixingtao.pojo.Shoppinger;
import com.huixingtao.service.ShoppingerService;
@Service
public class ShoppingerServiceImpl implements ShoppingerService {
	@Autowired
	ShoppingerMapper shoppingerMapper;
	@Override
	public Shoppinger get(String shoppingerId) {
		return shoppingerMapper.get(shoppingerId);
	}
	@Override
	public void setPicture(String picturePath, String id) {
		shoppingerMapper.setPicture(picturePath, id);
	}
	@Override
	public int check(String username) {
		// TODO Auto-generated method stub
		return shoppingerMapper.check(username);
	}
	@Override
	public void add(Shoppinger shoppinger) {
		shoppingerMapper.add(shoppinger);
		
	}
	@Override
	public List<Shoppinger> getList() {
		// TODO Auto-generated method stub
		return shoppingerMapper.getList();
	}
	@Override
	public void delete(String shoppingerId) {
		// TODO Auto-generated method stub
		shoppingerMapper.delete(shoppingerId);
		
	}
	@Override
	public void modify(String shoppingerId, String shoppingerPassword, String shoppingerName) {
		// TODO Auto-generated method stub
		shoppingerMapper.modify(shoppingerId, shoppingerPassword, shoppingerName);
	}

}
