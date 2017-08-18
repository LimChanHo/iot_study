<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<body>
아이디 : <input type="text" id="id"><br>
비밀번호 : <input type="text" id="pwd"><br>
<input type="button" value="로그인">
<script>
$("input[type='button']").click(function(){
	var params={};
	params["id"] = $("#id").val();
	params["pwd"] = $("#pwd").val();
	params = JSON.stringify(params);
	$.ajax({ 
			type     : "POST"
	    ,   url      : "/list.test"
	    ,   dataType : "json" 
	    ,   beforeSend: function(xhr) {
	        xhr.setRequestHeader("Accept", "application/json");
	        xhr.setRequestHeader("Content-Type", "application/json");
	    }
	    ,   data     : params
	    ,   success : function(result){
	    	alert(result);
	    }
	    ,   error : function(xhr, status, e) {
		    	alert("에러 : "+e);
		},
		complete  : function() {
		}
	});
});
</script>
</body>
</html>