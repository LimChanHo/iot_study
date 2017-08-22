<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<%!
public void printStr(String str){
	System.out.println("adsfsfad");
}
%>
<%
String userId = (String) session.getAttribute("userid");
String userName = "";
int age =  0;
String address =  "";
String hp1 =  "";
String hp2 =  "";
String hp3 =  "";

boolean login = true;
if(userId!=null){
	userName =  (String) session.getAttribute("username");
	age =  (int) session.getAttribute("age");
	address =  (String) session.getAttribute("address");
	hp1 =  (String) session.getAttribute("hp1");
	hp2 =  (String) session.getAttribute("hp2");
	hp3 =  (String) session.getAttribute("hp3");
	login = true;
}
String rootPath = request.getContextPath();
Date toDate = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
String toDateStr = sdf.format(toDate); 
String init = request.getParameter("init");
String defaultUrl = "";
if(init==null && !login){
	defaultUrl = rootPath + "/user/login.jsp?init=2";
	response.sendRedirect(defaultUrl);
}
String nowUrl = request.getRequestURI();
String loginStr = "로그인";
if(login){
	loginStr = "로그아웃";
}
String version = "1.3.2";
%>
<script src="<%=rootPath%>/js/jquery-3.2.1.js?version=<%=version%>"></script>
<script src="<%=rootPath%>/ui/common.js?version=<%=version%>"></script>
<script src="<%=rootPath%>/ui/btsp3.7.7/js/bootstrap.min.js?version=<%=version%>"></script>
<script src="<%=rootPath%>/ui/btsp3.7.7/js/bootstrap-table.js?version=<%=version%>"></script>
<script src="<%=rootPath%>/ui/btsp3.7.7/js/bootstrap-table.js?version=<%=version%>"></script>
<link rel="stylesheet" href="<%=rootPath%>/ui/btsp3.7.7/css/bootstrap-theme.min.css?version=<%=version%>"/>
<link rel="stylesheet" href="<%=rootPath%>/ui/btsp3.7.7/css/bootstrap.min.css?version=<%=version%>"/>
<link rel="stylesheet" href="<%=rootPath%>/ui/btsp3.7.7/css/bootstrap-table.css?version=<%=version%>"/>
<link rel="stylesheet" href="<%=rootPath%>/ui/common.css?version=<%=version%>"/>
<script>


var rootPath = "<%=rootPath%>";
$(document).ready(function(){
	var nowUrl = "<%=nowUrl%>";
	var obj = $("a[href='" + nowUrl + "']").parent().attr("class","active");
})
function doMovePage(pageId){
	var url = "<%=rootPath%>";
	if(pageId=="board"){
		url += "/board/board_select.jsp";
	}else if(pageId=="main"){
		url += "/";
	}else if(pageId=="insertBoard"){
		url += "/board/board_insert.jsp";
	}
	location.href=url;
}

function alertOp(){
	alert($("#op").val());
}
</script>
<body>