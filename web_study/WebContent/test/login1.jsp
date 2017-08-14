<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="login_ok.jsp" method="post">
<input type="text" name="id"/>
<input type="text" name="pwd"/>
<input type="button" value="click"onclick="doLogin()"/>
</form>
<script>

var AjaxUtil = function(p_url, params){
	this.params = "";
	var oldSend  = this;
	getHttpXmlObj = function(){
		if(window.XMLHttpRequest){
	  		return new XMLHttpRequest();
	 	}else if(window.ActiveXObject){
	  		return new ActiveXObject("Microsoft.XMLHTTP");
	 	}
		alert("해당 브라우져가  Ajax를 지원하지 않습니다.");
	}
	this.xhr = getHttpXmlObj();
	this.xhr.p = oldSend;
	var method = "get";
	var url = p_url;
	var aSync = true;
	this.xhr.onreadystatechange=function(){
   		if (this.readyState==4){
   			if(this.status==200){
	   			var result = decodeURIComponent(this.responseText);
	   			this.p.success(result);  
   			}else{
   				this.p.error(result);
   			}
   		}
	}
	this.success = function(abc){
		alert(abc);
	}
	this.error = function(abc){
		alert("에러입니다.");
	}
	this.changeCallBack = function(func){
		this.xhr.onreadystatechange = func;
	}
   	this.xhr.open(method, url+this.params, aSync);
   	this.send = function(){
   		this.xhr.send();
   	}
} 
function doLogin(){ 
	var au = new AjaxUtil("/test/login_ok1.jsp","id,pwd");
	au.success = function(result){
		alert("성공이다!!!!!");
	}
	au.send();
}
</script>
</body>
</html>