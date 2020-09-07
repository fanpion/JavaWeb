package com.huixingtao.mytag;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

/**
 * Servlet implementation class MyFirstTag
 */
@WebServlet("/MyFirstTag")
public class MyFirstTag extends HttpServlet implements SimpleTag {
	private static final long serialVersionUID = 1L;
	JspContext jspContext;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyFirstTag() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see SimpleTag#setJspContext(JspContext)
	 */
	public void setJspContext(JspContext arg0) {
		this.jspContext = arg0;
	}

	/**
	 * @see SimpleTag#setParent(JspTag)
	 */
	public void setParent(JspTag arg0) {
	}

	/**
	 * @see SimpleTag#setJspBody(JspFragment)
	 */
	public void setJspBody(JspFragment arg0) {
	}

	/**
	 * @see SimpleTag#getParent()
	 */
	public JspTag getParent() {
		return null;
	}

	/**
	 * @see SimpleTag#doTag()
	 */
	public void doTag() throws javax.servlet.jsp.JspException, java.io.IOException {
		jspContext.getOut().print("*");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
