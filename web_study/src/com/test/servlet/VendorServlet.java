package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.dto.Goods;
import com.test.dto.Page;
import com.test.dto.Vendor;
import com.test.service.VendorService;

public class VendorServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private VendorService vs = new VendorService();
	private Gson g = new Gson();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		Vendor vendor = g.fromJson(request.getReader(), Vendor.class);
		String command = vendor.getCommand();
		Page page = vendor.getPage();
		if (command.equals("list")) {
			int totalCnt = vs.getTotalCount(vendor);
			page.setTotalCnt(totalCnt);
			List<Vendor> vendorList = vs.selectVendorList(vendor);
			HashMap resultMap = new HashMap();
			resultMap.put("page", page);
			resultMap.put("vendorList", vendorList);
			resultMap.put("search", vendor);
			String jsonStr = g.toJson(resultMap);
			System.out.println("resultMap = " + resultMap);
			System.out.println("jsonStr = " + jsonStr);
			doProcess(response, jsonStr);
		}else if(command.equals("view")){
			Vendor resultGoods = vs.selectVendor(vendor);
	    	HashMap resultMap = new HashMap();
	    	resultMap.put("page", page);
	    	resultMap.put("vendor", resultGoods);
	    	resultMap.put("url", "/vendor/vendor_view.jsp");
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