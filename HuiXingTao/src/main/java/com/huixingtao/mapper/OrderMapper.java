package com.huixingtao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huixingtao.pojo.Order;

public interface OrderMapper {
	List<Order> getList();

	List<Order> getSingleList(String shoppingerId);

	void delete(int oID);

	void modify(@Param("oID") int oID);

	void add(@Param("shoppingerId") String shoppingerId, @Param("pname") String pname,
			@Param("oQuality") int oQuality, @Param("oSum") double oSum);
}
