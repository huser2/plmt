package com.plm.conn.tags;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TableDataModelTag extends SimpleTagSupport {

	private String list;

	/**
	 * @return the list
	 */
	public String getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(String list) {
		this.list = list;
	}

	@Override
	public void doTag() throws JspException, IOException {

		StringWriter sw = new StringWriter();
		if (list != null) {
			System.out.println("in loop >>"+list);
			/* Use message from attribute */
			JspWriter out = getJspContext().getOut();
			out.println(list);
		} else {
			/* use message from the body */
			getJspBody().invoke(sw);
			getJspContext().getOut().println(sw.toString());
		}
	}

}
