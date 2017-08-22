<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
div{
border-style: solid;
    border-color: red;
}
</style>
<body>
<p>get parameter방식</p>
<form action="test.formtest" method="get">
	아이디 : <input type="text" name="id"><br>
	비밀번호 : <input type="text" name="pwd"><br>
	<input type="submit" value="전송">
</form>

<p>POST JSON방식</p>
<form action="test.formtest" method="post">
	아이디 : <input type="text" name="id"><br>
	비밀번호 : <input type="text" name="pwd"><br>
	<input type="button" value="전송" onclick="testAdjacent()">
</form>
div시작
<div id="div1">
test
</div>
div종료
<script>
function testAdjacent(){
	var obj = document.getElementById("div1");
	obj.insertAdjacentHTML("afterend","<div>test div바로 위</div>")
}
</script>
</body>
</html>