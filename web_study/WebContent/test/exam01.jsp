<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="exam01_ok.jsp">
<input type="text" name="id"  id="id"/><br/>
<input type="text" name="name"  id="name"/><br/>
<input type="text" name="age"  id="age"/><br/>
<input type="text" name="address"  id="address"/><br/>
<input type="text" name="address2"  id="address2"/><br/>
<input type="text" name="hp1"  id="hp1"/><br/>
<input type="text" name="hp2"  id="hp2"/><br/>
<input type="text" name="hp3"  id="hp3"/><br/>
<input type="text" name="zipcode"  id="zipcode"/><br/>
<input type="text" name="password"  id="password"/><br/>
<input type="button" value="값확인" onclick="doCheckValue()"/>
</form>
<script>
var ABC = function(){
	call : function (abc){
		alert(abc);
	}
}
function ddd(abc,a,b,c,d,e3,f,a){
	alert(abc);
}
function doCheckValue(){
	var a = new ABC();
	var abc["msg"] = "메세지";
	var abc["list"] = "메세지";
	a.call(); 
} 
</script>
<div id="result_div"></div>
</body>
</html>