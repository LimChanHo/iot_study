<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header2.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!--<style>
div{
border-style: solid;
    border-color: red;
}
</style>-->
<body>
<br>
<br>
<br>
<br>
<br>

<p>get parameter방식</p>
<form action="test.formtest" method="get">
	아이디 : <input type="text" name="id"><br>
	비밀번호 : <input type="text" name="pwd"><br>
	<input type="submit" value="전송">
</form>

<p>POST JSON방식</p>
<form action="test.formtest" method="post">
	아이디 : <input type="text" id="id"><br>
	비밀번호 : <input type="text" id="pwd"><br>
	<input type="button" value="전송" onclick="postTest()">
</form>

<div id ="div1"></div>
<script>
function postTest(){
	var params={}
	params["id"] = $("#id").val();
	params["pwd"] = $("#pwd").val();
	params = JSON.stringify(params);
	$.ajax({ 
			type     : "POST"
	    ,   url      : "test.formtest"
	    ,   dataType : "json" 
	    ,   beforeSend: function(xhr) {
	        xhr.setRequestHeader("Accept", "application/json");
	        xhr.setRequestHeader("Content-Type", "application/json");
	    }
	    ,   data     : params
	    ,   success : function(result){
	    	var id = result.id;
	    	var pwd = result.pwd;
	    	var obj = document.getElementById("div1");
	    	obj.insertAdjacentHTML("afterend","<div><br> 입력한 아이디= "+id+"<br> 입력한 비밀번호= "+pwd+"</div>");
	    	
	    }
	    ,   error : function(xhr, status, e) {
		    	alert("에러 : "+e);
		},
		complete  : function() {
		}
	});
}
</script>
</body>
</html>