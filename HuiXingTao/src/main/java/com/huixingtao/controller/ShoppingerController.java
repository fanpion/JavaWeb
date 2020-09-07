package com.huixingtao.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.huixingtao.pojo.Shoppinger;
import com.huixingtao.service.ShoppingerService;

@Controller
@RequestMapping("")
public class ShoppingerController {
	@Autowired
	ShoppingerService shoppingerService;
	
	@RequestMapping(value="shoppingerManage")
	public ModelAndView shoppingerManage(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		view.setViewName("shoppinger");
		getShoopinger(request);
		return view;
	}
	
	@RequestMapping(value="addShoppinger")
	public ModelAndView addshoppinger(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		view.setViewName("addShoppinger");
		return view;
	}
	
	@RequestMapping("viewShoppinger")
	public ModelAndView viewShoppinger(String shoppingerID) {
		ModelAndView view = new ModelAndView();
		if (shoppingerID.equals("")) {
			view.setViewName("shoppinger");
		} else {
			Shoppinger shoppinger = shoppingerService.get(shoppingerID);
			view.addObject("shoppinger", shoppinger);
			view.setViewName("viewShoppinger");
		}
		return view;
	}
	
	@RequestMapping(value = "getShoopinger")
	public void getShoopinger(HttpServletRequest request) {
		List<Shoppinger> list = shoppingerService.getList();
		request.getSession().setAttribute("shoppingerList", list);
	}
	
	@RequestMapping("modifyShoopinger")
	public ModelAndView modifyShoopinger(String shoppingerID, String shoppingerPassword, String shoppingerName) {
		ModelAndView view = new ModelAndView();
		view.setViewName("viewShoppinger");
		shoppingerService.modify(shoppingerID, shoppingerPassword, shoppingerName);
		return view;
	}
	
	@RequestMapping("deleteShoopinger")
	public ModelAndView deleteShoopinger(String shoppingerID) {
		ModelAndView view = new ModelAndView();
		view.setViewName("viewShoppinger");
		shoppingerService.delete(shoppingerID);
		return view;
	}
}
