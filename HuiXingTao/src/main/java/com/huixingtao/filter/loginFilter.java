package com.huixingtao.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huixingtao.pojo.Shoppinger;

@WebFilter(filterName = "loginFilter", urlPatterns = { "/showCart", "/info", "/addToCart" })
public class loginFilter extends HttpFilter  {
	protected FilterConfig config;
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.config = fConfig;
	}

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		Shoppinger shoppinger = (Shoppinger) req.getSession().getAttribute("shoppinger");
		if (shoppinger != null) {
			String[] uri = req.getRequestURI().split("/");
			String target = uri[uri.length - 1];
			req.getRequestDispatcher(target).forward(req, res);
			return;
		} else {
			res.sendRedirect("login");
		}
	}
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}
}
