package com.test.servlet.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class CommonServlet extends HttpServlet{
	protected Gson g = new Gson();	
	protected void doProcess(HttpServletResponse response, String writeStr) throws IOException {
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		out.print(writeStr);
	}

}
