package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.dto.Test;
import com.test.service.GoodsService;

public class TestServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	private GoodsService gs = new GoodsService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{	
		request.setCharacterEncoding("UTF-8");
		String resultStr = "";
		doProcess(response, resultStr);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8");
	    Gson g = new Gson();
	    Test hm = g.fromJson(request.getReader(), Test.class);
	    List<Test> list = new ArrayList<Test>();
	    list.add(hm);
	    System.out.println(list);
	    System.out.println(hm);
	    System.out.println(list);
	    String resultStr = g.toJson(hm);
	    System.out.println(resultStr);
	    System.out.println(resultStr);
	    doProcess(response, resultStr);
//	    Goods goods = g.fromJson(request.getReader(), Goods.class);
//	    System.out.println(goods);
//	    String command = goods.getCommand();
//	    if(command.equals("list")){
//	    	int totalCnt = gs.getTotalCount(goods);
//	    	Page page = goods.getPage();
//	    	page.setTotalCnt(totalCnt);
//	    	List<Goods> list = gs.selectGoodsList(goods);
//	    	HashMap resultMap = new HashMap();
//	    	resultMap.put("page", page);
//	    	resultMap.put("list", list);
//	    	String jsonStr = g.toJson(resultMap);
//	    	System.out.println(jsonStr);
//	    	doProcess(response, jsonStr);
//	    }
	}
	
	public void doProcess(HttpServletResponse response, String writeStr) throws IOException {
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		out.print(writeStr);
	}
}