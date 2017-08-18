<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<body>
아이디 : <input type="text" id="id"><br>
비밀번호 : <input type="text" id="pwd"><br>
<input type="button" value="로그인">
<script>
$("input[type='button']").click(function(){
	var params="id=" + $("#id").val() + "&pwd=" + $("#pwd").val();
	$.ajax({ 
			type     : "GET"
	    ,   url      : "/list.test"
	    ,   dataType : "json" 
	    ,   data     : params
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