package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class TestServlet extends HttpServlet{
	
	private Gson g = new Gson();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{	
		String id= request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println("id : " + id);
		System.out.println("pwd : " + pwd);
		String result = "니가 입력한 아이디 는 " + id;
		result += "니가 입력한 비밀번호 는 " + pwd;
//		String str = request.getQueryString();
//		str = URLDecoder.decode(str, "UTF-8");
//		HashMap hm = g.fromJson(str, HashMap.class);
//		System.out.println(hm); 
		 
		doProcess(response, result);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{	
		HashMap hm = g.fromJson(request.getReader(), HashMap.class);
		System.out.println(hm); 
		String id= request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println("id : " + id);
		System.out.println("pwd : " + pwd);
		String result="";
		if(hm==null){
			result = "니가 입력한 아이디 는 " + id;
			result += "니가 입력한 비밀번호 는 " + pwd;
		}else{
			id = (String)hm.get("id");
			pwd = (String)hm.get("pwd");
//			HashMap r = new HashMap();
//			r.put("msg1", "니가입력한 아이디는");
//			r.put("value1", id);
//			r.put("msg2", "니가 입력한 비밀번호는");
//			r.put("value2", pwd);
//			result = g.toJson(r);
//			System.out.println(result);
			result = "{\"msg1\":\"니가입력한 아이디는\",\"value1\":\"" +id + "\",";
			result += "\"msg2\":\"니가 입력한 비밀번호는\",\"value2\":\"" +pwd+"\"}";
		}
		doProcess(response, result);
	}

	public void doProcess(HttpServletResponse resq, String writeStr) throws IOException {
		PrintWriter out = resq.getWriter();
		out.print(writeStr);
	}
}
