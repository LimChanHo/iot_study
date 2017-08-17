<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<div class="container-view"> 
		<table id="table"  data-height="460"	class="table table-bordered table-hover">
		<thead> 
			<tr> 
				<th colspan="2" class="text-center"><h5 class="form-signin-heading">회사 등록 페이지</h5></th>
			</tr>
			<tr>
				<td class="col-md-2">회사이름</td>
				<td class="col-md-4"><input type="text" name="viName" id="viName"></td>
			</tr>
			<tr>
				<td>회사설명</td>
				<td><input type="text" name="viDesc" id="viDesc"></td>
			</tr>
			<tr>
				<td>회사주소</td>
				<td><input type="text" name="viAddress" id="viAddress"></td>
			</tr>
			<tr>
				<td>회사번호</td>
				<td><input type="text" name="viPhone" id="viPhone"></td>
			</tr>
		
			<tr>
				<td colspan="2" align="center">
					<button id="btnInsert" class="btn btn-primary" 	type="button">회사등록</button>
					<button id="goList" class="btn" 	type="button">취소</button>
				</td>
			</tr>
		</table>
	</div>
	<!-- /container -->

<script>
	$("#btnInsert").click(function(){
		var viName = $("#viName").val().trim();
		if(viName==""){
			alert("회사명을 입력해주세요.");
			return;
		}
		var viDesc = $("#viDesc").val().trim();
		if(viDesc==""){
			alert("회사설명을 입력해주세요.");
			return;
		}
		var viAddress = $("#viAddress").val().trim();
		if(viAddress==""){
			alert("회사주소를 입력해주세요.");
			return;
		}
		var viPhone = $("#viPhone").val().trim();
		if(viPhone==""){
			alert("회사번호를 입력해주세요.");
			return;
		}
		var params = "command=insert&viName=" + viName + "&viDesc=" + viDesc + "&viAddress=" + viAddress +"&viPhone=" + viPhone;
		$.ajax({ 
	    		type     : "POST"
		    ,   url      : "/list.vendor"
		    ,   dataType : "json" 
		    ,   data     : params
		    ,   success : function(result){
		    	alert(result.msg);
				location.href = result.url;
		    }
		    ,   error : function(xhr, status, e) {
			    	alert("에러 : "+e);
			},
			complete  : function() {
			}
		});
		
	});
	
	$("#goList").click(function(){
		location.href = "/vendor/vendor_list.jsp";
		})
	
// 	$(document).ready(function(){
// 		var params = {};
// 		params["command"] = "vendorlist";
// 		movePageWithAjax(params, "/list.goods", callback);
// 	})
	
// 	function callback(result){
// 		var vendorList = result.vendorList;
// 		var selStr = "<option value=''>회사선택</option>";
// 		for (var i = 0, max = vendorList.length; i < max; i++) {
// 			var vendor = vendorList[i];
// 			selStr += "<option value='" + vendor.viNum + "' >" + vendor.viName
// 					+ "</option>";
// 		}
// 		$("#s_vendor").html(selStr);
// 	}
</script>
</body>
</html>