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
import com.test.dto.Page;
import com.test.dto.Vendor;
import com.test.service.VendorService;

public class VendorServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	private VendorService vs = new VendorService();
	private Gson g = new Gson();	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{	
		request.setCharacterEncoding("UTF-8");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8");

		
	    String command = request.getParameter("command");
	    String result = "";
	    if(command.equals("list")){
	    	Page page = new Page();
	    	String viName = request.getParameter("viName");
	    	String nowPage1 = request.getParameter("nowPage");
	    	int nowPage = Integer.parseInt(nowPage1);
	    	page.setNowPage(nowPage);
	    	int totalCnt = vs.getTotalCount();
	    	page.setTotalCnt(totalCnt);
	    	HashMap hm = new HashMap();
	    	List<Vendor> vendorList = vs.selectVendorsList(viName,page);
	    	hm.put("page", page);
	    	hm.put("vendorList", vendorList);
	    	result = g.toJson(hm);
//	    	for(Vendor v : vendorList){
//	    		result += "<tr>";
//	    		result += "<td>" + v.getViNum() + "</td>";
//	    		result += "<td>" + v.getViName() + "</td>";
//	    		result += "<td>" + v.getViDesc() + "</td>";
//	    		result += "<td>" + v.getViAddress() + "</td>";
//	    		result += "<td>" + v.getViPhone() + "</td>";
//	    		result += "</tr>";
//	    	}
	    }else if(command.equals("view")){
	    	String viNum1 = request.getParameter("viNum");
	    	int viNum = Integer.parseInt(viNum1);
	    	Vendor resultVendor = vs.viewVendor(viNum);
	    	HashMap resultMap = new HashMap();
//	    	resultMap.put("page", page);
	    	resultMap.put("vendor", resultVendor);
	    	resultMap.put("url", "/vendor/vendor_view.jsp");
	    	result = g.toJson(resultMap);
	    }else if(command.equals("delete")){
	    	String viNum1 = request.getParameter("viNum");
	    	int viNum = Integer.parseInt(viNum1);
	    	int result1 = vs.deleteVendor(viNum);
	    	HashMap resultMap = new HashMap();
//	    	resultMap.put("page", page);
	    	resultMap.put("msg", "삭제가 완료 되었습니다.");
	    	resultMap.put("url", "/vendor/vendor_list.jsp");
	    	if(result1!=1){
		    	resultMap.put("msg", "삭제가 실패하였습니다.");
		    	resultMap.put("url", "");
	    	}
	    	result = g.toJson(resultMap);
	    }else if(command.equals("insert")){
	    	String viName = request.getParameter("viName");
	    	String viDesc = request.getParameter("viDesc");
	    	String viAddress = request.getParameter("viAddress");
	    	String viPhone = request.getParameter("viPhone");
	    	int results = vs.insertVendor(viName,viDesc,viAddress,viPhone);
	    	HashMap resultMap = new HashMap();
	    	resultMap.put("msg", "저장이 완료 되었습니다.");
	    	resultMap.put("url", "/vendor/vendor_list.jsp");
	    	if(results!=1){
		    	resultMap.put("msg", "저장이 실패하였습니다.");
		    	resultMap.put("url", "");
		    result = g.toJson(resultMap);
	    	}
	    	result = g.toJson(resultMap);
	    }else if(command.equals("update")){
	    	String viNum1 =  request.getParameter("viNum");
	    	int viNum = Integer.parseInt(viNum1);
	    	String viName = request.getParameter("viName");
	    	String viDesc = request.getParameter("viDesc");
	    	String viAddress = request.getParameter("viAddress");
	    	String viPhone = request.getParameter("viPhone");
	    	int results1 = vs.updateVendor(viNum,viName,viDesc,viAddress,viPhone);
	    	HashMap resultMap = new HashMap();
	    	resultMap.put("msg", "수정이 완료 되었습니다.");
	    	resultMap.put("url", "/vendor/vendor_list.jsp");
	    	if(results1!=1){
		    	resultMap.put("msg", "수정이 실패하였습니다.");
		    	resultMap.put("url", "");
		    result = g.toJson(resultMap);
	    	}
	    	result = g.toJson(resultMap);
	    }
	    doProcess(response, result);
	}
	
	public void doProcess(HttpServletResponse response, String writeStr) throws IOException {
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		out.print(writeStr);
	}
}
