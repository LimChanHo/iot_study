<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

String result = "login=ok&msg=" + id + "님 로그인에 성공하셨습니다.";
out.write(result);
%>