package com.huixingtao.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.huixingtao.listener.deleteAsyncListener;
import com.huixingtao.pojo.GoodsItem;
import com.huixingtao.pojo.Product;
import com.huixingtao.pojo.ShoppingCart;
import com.huixingtao.service.ProductService;

@Controller
@RequestMapping("")
public class ProductController {
	@Autowired
	ProductService productService;

	@RequestMapping("search")
	public ModelAndView search(String searchInfo, HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		List<Product> product = new ArrayList<>();
		if (searchInfo.equals("0")) {
			product = productService.getList();
		} else {
			product.add(productService.getByPname(searchInfo));
		}
		request.getSession().setAttribute("searchList", product);
		view.setViewName("index");
		return view;
	}

	@RequestMapping("viewProduct")
	public ModelAndView viewProduct(String pname) {
		ModelAndView view = new ModelAndView();
		if (pname.equals("")) {
			view.setViewName("index");
		} else {
			Product product = productService.getByPname(pname);
			view.addObject("product", product);
			view.setViewName("viewProduct");
		}
		return view;
	}

	@RequestMapping(value = "getProduct")
	public void getProduct(HttpServletRequest request) {
		List<Product> list = productService.getList();
		request.getSession().setAttribute("productList", list);
	}

	@RequestMapping("showCart")
	public ModelAndView showCart() {
		ModelAndView view = new ModelAndView();
		view.setViewName("showCart");
		return view;
	}

	@RequestMapping("addToCart")
	public ModelAndView addToCart(HttpServletRequest request, String pname, String quantity) {
		ModelAndView view = new ModelAndView();
		view.setViewName("showCart");
		if (quantity.equals("")) {
			return view;
		}
		int num = Integer.parseInt(quantity);
		Product product = productService.getByPname(pname);
		if (num > 0) {
			GoodsItem goodsItem = new GoodsItem(product, num);
			ShoppingCart sCart = (ShoppingCart) request.getSession().getAttribute("cart");
			if (sCart == null) {
				sCart = new ShoppingCart();
				request.getSession().setAttribute("cart", sCart);
			}
			sCart.add(goodsItem);
			countSum(request);

		}
		return view;
	}

	public void countSum(HttpServletRequest request) {
		ShoppingCart sCart = (ShoppingCart) request.getSession().getAttribute("cart");
		if (sCart == null) {
			sCart = new ShoppingCart();
			request.getSession().setAttribute("cart", sCart);
			return;
		}
		request.getSession().setAttribute("items", sCart.getItems());
		request.getSession().setAttribute("sum", sCart.getTotal());
	}

	@RequestMapping("deleteItem")
	public ModelAndView deleteItem(HttpServletRequest request, String pname) {
		ModelAndView view = new ModelAndView();
		view.setViewName("showCart");
		AsyncContext startAsync = request.startAsync();
		startAsync.addListener(new deleteAsyncListener());
		startAsync.start(new Runnable() {
			@Override
			public void run() {
				ShoppingCart sCart = (ShoppingCart) request.getSession().getAttribute("cart");
				if (sCart == null) {
					sCart = new ShoppingCart();
					request.getSession().setAttribute("cart", sCart);
					return;
				}
				sCart.remove(pname);
				countSum(request);
			}
		});
		startAsync.complete();
		return view;
	}

	@RequestMapping("addProduct")
	public ModelAndView addProduct(String newProductName, String newProductPrice) {
		ModelAndView view = new ModelAndView();
		view.setViewName("index");
		productService.add(new Product(newProductName, Double.parseDouble(newProductPrice)));
		return view;
	}

	@RequestMapping("modifyProduct")
	public ModelAndView modifyProduct(String pname, String newProductName, String newProductPrice) {
		ModelAndView view = new ModelAndView();
		view.setViewName("index");
		productService.modify(pname, newProductName, Double.parseDouble(newProductPrice));
		return view;
	}

	@RequestMapping("deleteProduct")
	public ModelAndView deleteProduct(String pname) {
		ModelAndView view = new ModelAndView();
		view.setViewName("index");
		productService.delete(pname);
		return view;
	}
}
