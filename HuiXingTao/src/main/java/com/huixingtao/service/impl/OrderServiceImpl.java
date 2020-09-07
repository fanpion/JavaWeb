package com.huixingtao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huixingtao.mapper.OrderMapper;
import com.huixingtao.pojo.Order;
import com.huixingtao.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderMapper orderMapper;
	
	@Override
	public List<Order> getList() {
		return orderMapper.getList();
	}

	@Override
	public List<Order> getSingleList(String shoppingerId) {
		return orderMapper.getSingleList(shoppingerId);
	}

	@Override
	public void delete(int oID) {
		orderMapper.delete(oID);
	}

	@Override
	public void modify(int oID) {
		orderMapper.modify(oID);
	}

	@Override
	public void add(String shoppingerId, String pname, int oQuality, double oSum) {
		orderMapper.add(shoppingerId, pname, oQuality, oSum);
	}

}
