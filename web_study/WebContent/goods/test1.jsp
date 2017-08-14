<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<title>Insert title here</title>
</head>
<body>
<input type="button" id="btn" value = "서블릿이동">
<script>
var globalResult = {};
$("#btn").click(function(){
	if(globalResult.struct){
// 		alert(globalResult.struct.a);
	}
	
	var params = {};
	params["num"] = "1";
	params["name"] = "홍길동";
	params["command"] = "test";
	params["struct"] = {"a":"1","b":"2"};
	if(globalResult.struct){
		globalResult.struct.a="2";
		pData= JSON.stringify(globalResult);
		alert(params);
	}else{
		pData= JSON.stringify(params);
		alert(params);
	}
	
	$.ajax({ 
		type     : "POST"
    ,   url      : "/list.test"
    ,   dataType : "json" 
    ,   beforeSend: function(xhr) {
        xhr.setRequestHeader("Accept", "application/json");
        xhr.setRequestHeader("Content-Type", "application/json");
    }
    ,   data     : pData
    ,   success : function(result){
    	alert(result.struct.a);
    	globalResult=result;
//     	alert(result.struct.a);
//     	result.struct.a="2";
    }
    ,   error : function(xhr, status, e) {
	    	alert("에러 : "+e);
	},
	complete  : function() {
	}});
});


</script>
</body>
</html>