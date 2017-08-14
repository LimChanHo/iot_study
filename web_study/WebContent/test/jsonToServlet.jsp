<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<title>Insert title here</title>
</head>
<body>
<script>
var testParam = {};
testParam["giNum1"] = "1";
testParam["giName"] = "상품";
testParam["giDesc"] = "상품설명";
testParam["viNum"] = "1";
testParam["viName"] = "회사명";
function callback(result){
	alert(result.giDesc);
}
movePageWithAjax(testParam, "/test.goods", callback);
</script>
</body>
</html>