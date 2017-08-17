<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.UserInfo"%>
	<div class="container-view"> 
		<table id="table"  data-height="460"	class="table table-bordered table-hover">
		<thead>
			<tr> 
				<th colspan="3" class="text-center"><h5 class="form-signin-heading">회사상세 페이지</h5></th>
			</tr>
			<tr>
				<td class="col-md-2">회사번호</td>
				<td class="col-md-4" colspan="2"><%=request.getParameter("viNum") %></td>
			<tr>
				<td>회사이름</td>
				<td colspan="2"><%=request.getParameter("viName") %></td>
			</tr>
			<tr>
				<td>회사설명</td>
				<td colspan="2"><%=request.getParameter("viDesc") %></td>
			</tr>
			<tr>
				<td>회사주소</td>
				<td colspan="2"><%=request.getParameter("viAddress") %></td>
			</tr>
			<tr>
				<td>회사번호</td>
				<td colspan="2"><%=request.getParameter("viPhone") %></td>
			</tr>
			<tr>
				<td>
					<button id="btnUpdate" class="btn btn-md-2 btn-block" 	type="button">수정</button>
				</td>
				<td>
					<button id="btnDelete" class="btn btn-md-2 btn-block" 	type="button">삭제</button>
				</td>
				<td>
					<button id="btnGoList" class="btn btn-md-2 btn-block" 	type="button">리스트 이동</button>
				</td>
			</tr>
		</table>
	</div>
	<!-- /container -->
<script>
$("#btnDelete").click(function(){
	var isDelete = confirm("해당 회사 정보를 제거 하시겠습니까?");
	if(isDelete){
		var viNum = <%=request.getParameter("viNum") %>;
		var params = "command=delete&viNum=" + viNum;
		$.ajax({ 
    		type     : "POST"
	    ,   url      : "/list.vendor"
	    ,   dataType : "json" 
	    ,   data     : params
	    ,   success : function(result){
	    	alert(result.msg);
	    	location.href = result.url;
// 	    	location.href = result.url + "?nowPage=" + result.page.nowPage;
	    }
	    ,   error : function(xhr, status, e) {
		    	alert("에러 : "+e);
		},
		complete  : function() {
		}
	});
		
		
		
	}
	
});

$("#btnUpdate").click(function(){
	var viName = "<%=request.getParameter("viName")%>";
	location.href="/vendor/vendor_update.jsp?nowPage=" + <%=request.getParameter("nowPage")%> + "&viNum=" + <%=request.getParameter("viNum")%> +"&viName=" + viName; 
});
$("#btnGoList").click(function(){
	location.href="/vendor/vendor_list.jsp?nowPage=" + <%=request.getParameter("nowPage")%>
});
</script>
</body>
</html>