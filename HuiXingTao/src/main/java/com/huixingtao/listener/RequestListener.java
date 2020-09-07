package com.huixingtao.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
@WebListener
public class RequestListener implements ServletRequestListener {
	private int count = 0;
	
	
	
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {

	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		HttpServletRequest request = (HttpServletRequest)arg0.getServletRequest();
		if (request.getRequestURI().endsWith("login")) {
			count++;
			request.getServletContext().setAttribute("count", count);
		}

	}

}
