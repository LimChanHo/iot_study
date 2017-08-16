package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.dto.Goods;
import com.test.dto.Page;
import com.test.dto.Vendor;
import com.test.service.GoodsService;

public class GoodsServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	private GoodsService gs = new GoodsService();
	private Gson g = new Gson();	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{	
		request.setCharacterEncoding("UTF-8");
		String resultStr = "";
		String params = request.getParameter("param");
	    Goods goods = g.fromJson(params, Goods.class);
	    String command = goods.getCommand();
    	Page page = goods.getPage();
		if(command.equals("view")){
	    	Goods resultGoods = gs.selectGoods(goods);
	    	request.setAttribute("page", page);
	    	request.setAttribute("goods", resultGoods);
	    	request.setAttribute("url", "/goods/goods_view.jsp");
	    	RequestDispatcher rd=request.getRequestDispatcher("/goods/goods_view2.jsp");
	    	try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8");
	    
	    Goods goods = g.fromJson(request.getReader(), Goods.class);
	    String command = goods.getCommand();
    	Page page = goods.getPage();
	    if(command.equals("list")){
	    	int totalCnt = gs.getTotalCount(goods);
	    	page.setTotalCnt(totalCnt);
	    	List<Goods> list = gs.selectGoodsList(goods);
	    	List<Vendor> vendorList = gs.selectVendorsList();
	    	HashMap resultMap = new HashMap();
	    	resultMap.put("page", page);
	    	resultMap.put("list", list);
	    	resultMap.put("search", goods);
	    	resultMap.put("vendorList", vendorList);
	    	String jsonStr = g.toJson(resultMap);
	    	doProcess(response, jsonStr);
	    }else if(command.equals("view")){
	    	Goods resultGoods = gs.selectGoods(goods);
	    	HashMap resultMap = new HashMap();
	    	resultMap.put("page", page);
	    	resultMap.put("goods", resultGoods);
	    	resultMap.put("url", "/goods/goods_view.jsp");
	    	String jsonStr = g.toJson(resultMap);
	    	doProcess(response, jsonStr);
	    }else if(command.equals("delete")){
	    	int result = gs.deleteGoods(goods);
	    	HashMap resultMap = new HashMap();
	    	resultMap.put("page", page);
	    	resultMap.put("msg", "삭제가 완료 되었습니다.");
	    	resultMap.put("url", "/goods/goods_list.jsp");
	    	if(result!=1){
		    	resultMap.put("msg", "삭제가 실패하였습니다.");
		    	resultMap.put("url", "");
	    	}
	    	String jsonStr = g.toJson(resultMap);
	    	doProcess(response, jsonStr);
	    }else if(command.equals("vendorlist")){
	    	List<Vendor> vendorList = gs.selectVendorsList();
	    	HashMap resultMap = new HashMap();
	    	resultMap.put("vendorList", vendorList);
	    	String jsonStr = g.toJson(resultMap);
	    	doProcess(response, jsonStr);
	    }else if(command.equals("insert")){
	    	int result = gs.insertGoods(goods);
	    	HashMap resultMap = new HashMap();
	    	resultMap.put("msg", "저장이 완료 되었습니다.");
	    	resultMap.put("url", "/goods/goods_list.jsp");
	    	if(result!=1){
		    	resultMap.put("msg", "저장이 실패하였습니다.");
		    	resultMap.put("url", "");
	    	}
	    	String jsonStr = g.toJson(resultMap);
	    	doProcess(response, jsonStr);
	    }else if(command.equals("update")){
	    	int result = gs.updateGoods(goods);
	    	HashMap resultMap = new HashMap();
	    	resultMap.put("msg", "수정이 완료 되었습니다.");
	    	resultMap.put("url", "/goods/goods_list.jsp");
	    	if(result!=1){
		    	resultMap.put("msg", "수정이 실패하였습니다.");
		    	resultMap.put("url", "");
	    	}
	    	String jsonStr = g.toJson(resultMap);
	    	doProcess(response, jsonStr);
	    	
	    }
	}
	
	public void doProcess(HttpServletResponse response, String writeStr) throws IOException {
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		out.print(writeStr);
	}
}