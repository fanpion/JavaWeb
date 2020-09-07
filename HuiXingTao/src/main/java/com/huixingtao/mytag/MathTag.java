package com.huixingtao.mytag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class MathTag extends SimpleTagSupport {
	double x;

	public void setX(String x) {
		double num = 0;
		try {
			num = Double.parseDouble(x);
		} catch (NumberFormatException e) {
		}
		this.x = num;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.print("sqrt(" + x + ") = " + Math.sqrt(x));
	}
}
