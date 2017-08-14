<%@ include file="/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<textarea id="chat" rows=20 cols=60 style="resize:none"></textarea><br/><br/>
<input type="text" name="name" id="name"/>
<input type="text" name="content" id="content"/>
<input type="hidden" name="chatnum" id="chatnum" value="0"/>
<input type="button" value="전송" onclick="doInsertChat()"/>
<script>
$(document).ready(function(){
	setInterval(doGetChat,1000);
}); 
function doGetChat(){ 
	var au = new AjaxUtil("chat_select.jsp", "it_chatnum");
	au.setCallbackSuccess(callbackChat);
	au.send();
}
var callbackChat = function (list){
	for(var i=0, max = list.length;i<max;i++){
		var chat = list[i];
		var str = chat.name + ":" + chat.content;
		$("#chatnum").val(chat.chatnum);
		$("#chat").append(str+"\n\r");
	}
}
function doInsertChat(){
	var au = new AjaxUtil("chat_insert_ok.jsp", "it_name,it_content");
	au.send();
}
var AjaxUtil = function (url, params, type, dataType){
	if(!url){
		alert("url정보가 없습니다.");
		return null;
	}
	this.url = url;
	var initData = {}
	initData["projectName"] = "spring4";
	
	this.param = JSON.stringify(initData);
	if(params){
		var paramArr = params.split(",");

		var data = {};
		for(var i=0,max=paramArr.length;i<max;i++){
			var objType =  paramArr[i].split("_")[0];
			var objName = paramArr[i].split("_")[1];
			
			if(objType=="it"){
				data[objName] = $("input[name=" + objName +"]").val();
			}else if(objType=="s"){
				data[objName] = $("select[name=" + objName +"]").val();
			}
		}
		this.param = JSON.stringify(data);
		
	}
	this.type = type?type:"POST";
	this.dataType = dataType?dataType:"json";
	this.callbackSuccess = function(json){
    	var url = json.url;
    	var data = json.data;
    	var msg = json.msg;
    	if(msg){
    		alert(msg);
    	}
    	if(url){
        	pageMove(url);
    	}
	}
	
	this.setCallbackSuccess = function(callback){
		this.callbackSuccess = callback;
	}
	
	this.send = function(){
		$.ajax({ 
	        type     : this.type
	    ,   url      : this.url
	    ,   dataType : this.dataType 
	    ,   data     : this.param
	    ,   success : this.callbackSuccess
	    ,   error : function(xhr, status, e) {
		    	alert("에러 : "+e);
		},
		done : function(e) {
		}
		});
	}
}

</script>
</body>
</html>