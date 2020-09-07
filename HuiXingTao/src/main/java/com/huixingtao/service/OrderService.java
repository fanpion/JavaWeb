package com.huixingtao.service;

import java.util.List;

import com.huixingtao.pojo.Order;

public interface OrderService {
	List<Order> getList();

	List<Order> getSingleList(String shoppingerId);

	void delete(int oID);

	void modify(int oID);

	void add(String shoppingerId, String pname, int oQuality, double oSum);
}
