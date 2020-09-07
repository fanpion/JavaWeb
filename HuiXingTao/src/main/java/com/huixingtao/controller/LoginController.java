package com.huixingtao.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.huixingtao.pojo.Notice;
import com.huixingtao.pojo.Product;
import com.huixingtao.pojo.Shoppinger;
import com.huixingtao.service.NoticeService;
import com.huixingtao.service.ProductService;
import com.huixingtao.service.ShoppingerService;

@Controller
@RequestMapping("")
public class LoginController {
	@Autowired
	ShoppingerService ShoppingerService;
	@Autowired
	ProductService productService;
	@Autowired
	NoticeService noticeService;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView loginGet() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value = "check")
	public void check(@RequestParam(value = "username") String username, HttpServletResponse response) {
		int check = ShoppingerService.check(username);
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		try {
			response.getWriter().write("" + check);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView loginPost(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();

		Shoppinger shoppinger = ShoppingerService.get(username);
		if (shoppinger != null && shoppinger.getShoppingerPassword().equals(password)) {
			request.getSession().setMaxInactiveInterval(0);
			request.getSession().setAttribute("shoppinger", shoppinger);
			modelAndView = product(request);
			String recordPwd = request.getParameter("recordPwd");
			if (recordPwd != null) {
				Cookie shoppingerId = new Cookie("shoppingerId", shoppinger.getShoppingerID());
				Cookie shoppingerPwd = new Cookie("shoppingerPwd", shoppinger.getShoppingerPassword());
				response.addCookie(shoppingerPwd);
				response.addCookie(shoppingerId);
			}
			return modelAndView;
		}
		modelAndView.setViewName("login");
		modelAndView.addObject("error", "用户名或密码错误");
		return modelAndView;
	}

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView view = new ModelAndView();
		view.setViewName("register");
		return view;
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public void registerTest(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password, @RequestParam(value = "id") String id,
			@RequestParam(value = "way") String way, HttpServletResponse response, HttpServletRequest request)
			throws UnsupportedEncodingException {
		Shoppinger shoppinger = ShoppingerService.get(username);
		try {
			if (shoppinger != null) {
				request.getSession().setAttribute("registererror", "该用户名已存在");
				response.sendRedirect("register");
				return;
			}
			request.getSession().setAttribute("registererror", "");
			ShoppingerService.add(new Shoppinger(username, password, new String(id.getBytes("8859_1"), "utf-8"), null));
			String uri = request.getRequestURI();
			if (Integer.parseInt(way) == 0) {
				response.sendRedirect("login");

			} else {
				response.sendRedirect("addShoppinger");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "loginSuccess")
	public ModelAndView product(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		List<Product> list = productService.getList();
		modelAndView.addObject("productTypeList", new String[] { "女装精品", "精品男装", "童鞋玩具", "家电数码", "鲜花宠物" });
//		request.getSession().setAttribute("productList", list);
		List<Notice> list2 = noticeService.getList();
		modelAndView.addObject("productList", list);
		modelAndView.addObject("noticeList", list2);
		modelAndView.setViewName("index");

		return modelAndView;

	}

}
