<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<body>
아이디 : <input type="text" id="id" data-label="아이디"><br>
비밀번호 : <input type="text" id="pwd" data-label="비밀번호"><br>
<input type="button" value="로그인">
<script>
$("input[type='button']").click(function(){
	//var params="id=" + $("#id").val() + "&pwd=" + $("#pwd").val();

	var params={};
	params["id"] = $("#id").val();
	params["pwd"] = $("#pwd").val();
	params = JSON.stringify(params);
	params = encodeURIComponent(params);
	$.ajax({ 
			type     : "GET"
	    ,   url      : "/list.test"
	    ,   dataType : "json" 
	    ,   data     : params
	    ,   beforeSend: function(xhr) {
	        xhr.setRequestHeader("Accept", "application/json");
	        xhr.setRequestHeader("Content-Type", "application/json");
	    }
	    ,   success : function(result){
	    	alert(result);
	    }
	    ,   error : function(xhr, status, e) {
		    	alert("에러 : "+xhr.responseText);
		},
		complete  : function() {
		}
	});
});
</script>
</body>
</html>