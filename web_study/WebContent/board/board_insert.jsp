<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
    <div class="container">
      <div class="starter-template">
<form method="get" action="<%=rootPath%>/board/board_insert_ok.jsp" >
<table class='table table-bordered table-hover'>
<tr>
<td>제목</td>
<td> <input type="text" name="bititle" id="bititle"/></td>
</tr>
<tr>
<td> 내용 </td>
<td> <textarea name="bicontent" id="bicontent"></textarea></td>
</tr>
<tr>
<td> 글쓴이 </td>
<td> <input type="text" name="creusr" id="creusr" value="<%=userId%>"/></td>
</tr>
<tr>
<td> 비밀번호 </td>
<td> <input type="password" name="bipwd" id="bipwd" /></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="글쓰기"/>
</td>
</table>
</form>
</div>
</div>
</body>
</html>