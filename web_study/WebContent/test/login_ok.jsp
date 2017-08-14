<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

out.println(id + "," + pwd);
%>
<script>
alert("<%=id%>님 로그인에 성공하셨군요.");
location.href = "login.jsp"
</script>