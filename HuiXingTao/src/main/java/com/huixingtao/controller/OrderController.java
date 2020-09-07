package com.huixingtao.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.huixingtao.pojo.Order;
import com.huixingtao.pojo.ShoppingCart;
import com.huixingtao.pojo.Shoppinger;
import com.huixingtao.service.OrderService;

@Controller
@RequestMapping("")
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value = "orderManage",method = RequestMethod.GET)
	public ModelAndView orderManage(HttpServletRequest request,String shoppingerId) {
		ModelAndView view = new ModelAndView();
		view.setViewName("order");
		List<Order> list = null;
		if (shoppingerId.equals("admin")) {
			list = orderService.getList();
		}else {
			list = orderService.getSingleList(shoppingerId);
		}
		view.addObject("orderList", list);
		return view;
	}
	
	@RequestMapping(value = "orderDelete" , method = RequestMethod.POST)
	public ModelAndView orderDelete(HttpServletRequest request,String oID,String shoppingerId) {
		orderService.delete(Integer.parseInt(oID));
		return orderManage(request,shoppingerId);
	}
	
	@RequestMapping(value = "orderModify", method = RequestMethod.POST)
	public ModelAndView orderModify(HttpServletRequest request,String oID,String shoppingerId) {
		orderService.modify(Integer.parseInt(oID));
		return orderManage(request,shoppingerId);
	}
	
	@RequestMapping(value = "orderAdd", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public ModelAndView orderAdd(HttpServletRequest request,@RequestBody String[][] data) {
		request.getSession().removeAttribute("cart");
		request.getSession().setAttribute("cart", new ShoppingCart());
		Object shoppingerObj = request.getSession().getAttribute("shoppinger");
		String shoppingerId = null;
		if (shoppingerObj != null) {
			shoppingerId = ((Shoppinger)shoppingerObj).getShoppingerID();
		}
		for (String[] datas : data) {
			orderService.add(shoppingerId, datas[0], Integer.parseInt(datas[1]),Double.parseDouble(datas[3]));
		}
		return orderManage(request,shoppingerId);
	}
	
	
}
