<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%
String test1 = request.getParameter("test1");
String test2 = request.getParameter("test2");
String test3 = request.getParameter("test3");
String test4 = request.getParameter("test4");
String test5 = request.getParameter("test5");
String test6 = request.getParameter("test6");
String test7 = request.getParameter("test7");
String test8 = request.getParameter("test8");
String test9 = request.getParameter("test9");
String test10 = request.getParameter("test10");

Map<String, String[]> map = request.getParameterMap();
Iterator<String> it = map.keySet().iterator();
while(it.hasNext()){
	String name = it.next();
	String value = request.getParameter(name); 
	out.println("입력하신 " + name + "의 값은 " + value + " 입니다.<br/>");
}
%>