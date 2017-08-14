<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String id = (String) session.getAttribute("id");
if(id!=null){
	out.println(id + "님 환영해요~");
}
//out.println("아마추어같이 왜이래??");
String guCnt = request.getParameter("gucnt");
if(guCnt!=null){
	int maxNum = Integer.parseInt(guCnt);
	out.println(guCnt +" X " + guCnt + "단을 생성할게요<br/>");
	String str = "<table border='1'>";
	for(int i=1;i<=maxNum;i++){
		str += "<tr>";
		for(int j=1;j<=maxNum;j++){
			str +="<td>" + i +" * " + j + " = " + (i*j) + "</td>";
		}
		str += "</tr>";
	}
	str += "</table>";
	out.println(str); 
}
%>

<form action="/user/make_gugudan.jsp">
	구구단 생성 갯수 : <input type="text" name="gucnt"/><br/>
	<input type="submit" value="생성!"/>
</form>
</body>
</html>