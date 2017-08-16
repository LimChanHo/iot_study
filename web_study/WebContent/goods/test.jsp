<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<title>Insert title here</title>
</head>
<body>
<input type="button" id="btn" value="서블릿이동"/>
<script>
var globalResult = {};
$("#btn").click(function(){
	var params = {};
	params["num"] = "1";
	params["name"] = "홍길동";
	params["command"] = "test";
	params["struct"] = {"a":"1","b":"2"};
	var pData = "";
	if(globalResult.struct){
		globalResult.struct.a="2";
		pData = JSON.stringify(globalResult);
		
	}else{
		pData = JSON.stringify(params);
	}
	alert(params.struct.a);
	$.ajax({ 
			type     : "POST"
	    ,   url      : "/list.goods"
	    ,   dataType : "json" 
	    ,   beforeSend: function(xhr) {
	        xhr.setRequestHeader("Accept", "application/json");
	        xhr.setRequestHeader("Content-Type", "application/json");
	    }
	    ,   data     : pData
	    ,   success : function(result){
	    	alert(result.struct.a);
	    	globalResult = result;
	    }
	});
});
</script>
</body>
</html>