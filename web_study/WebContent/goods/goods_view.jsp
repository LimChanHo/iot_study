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
				<th colspan="2" class="text-center"><h5 class="form-signin-heading">상품상세 페이지</h5></th>
			</tr>
			<tr>
				<td class="col-md-2">상품번호</td>
				<td class="col-md-4"><%=request.getParameter("giNum") %></td>
			<tr>
				<td>상품이름</td>
				<td></td>
			</tr>
			<tr>
				<td>상품설명</td>
				<td></td>
			</tr>
			<tr>
				<td>생산자번호</td>
				<td></td>
			</tr>
			<tr>
				<td>생산자이름</td>
				<td></td>
			</tr>
			<tr>
				<td colspan="2">
					<button id="btn2" class="btn btn-lg btn-primary btn-block" 	type="button">리스트 이동</button>
				</td>
			</tr>
		</table>
	</div>
	<!-- /container -->
<script>
</script>
</body>
</html>