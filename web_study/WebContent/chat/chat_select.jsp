<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn" %>
<%@ page import="com.test.dto.UserInfo" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.*" %>
<%
String id = null;
String pwd = null;
List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
HashMap<String,String> ui = null;
ui = new Gson().fromJson(request.getReader(), HashMap.class);
 
String result = "";
String login = "false";
if(ui!=null){
	
	Connection con = null;
	PreparedStatement ps = null;
	try{
		con = DBConn.getCon();
		String sql = "select * from chat where chatnum > ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, ui.get("chatnum"));
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			String chatnum = rs.getString("chatnum");
			String name = rs.getString("name");
			String content = rs.getString("content");
			HashMap<String, String> hm = new HashMap<String, String>();
			hm.put("chatnum", chatnum);
			hm.put("name", name);
			hm.put("content", content);
			list.add(hm);
		}
	}catch(Exception e){
		System.out.println(e);
	}finally{
		if(ps!=null){
			ps.close();
			ps = null;
		}
		DBConn.closeCon();
	}
}
String json = new Gson().toJson(list);
out.write(json);
%>