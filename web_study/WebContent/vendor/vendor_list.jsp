<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<div class="container">
	<div class="container" style="text-align: center; padding-top: 20px;padding-bottom: 20px;">
		<select id="s_vendor" class="selectpicker">
		</select> 
		<label>회사이름 : </label> <input type="text" id="giName" /> 
		<input type="button" id="searchGoods" value="검색" />
	</div>
	<table id="table" data-height="460"
		class="table table-bordered table-hover">
		<thead>
			<tr>
				<th data-field="viNum" class="text-center">회사번호</th>
				<th data-field="viName" class="text-center">회사이름</th>
				<th data-field="viDesc" class="text-center">회사설명</th>
				<th data-field="viAddress" class="text-center">회사주소</th>
				<th data-field="viPhone" class="text-center">회사번호</th>
			</tr>
		</thead>
		<tbody id="result_tbody">
		</tbody>
	</table>
	<button id="btnInsert" class="btn btn-primary"  type="button">회사등록</button>
</div>
<div class="jb-center" style="text-align: center">
	<ul class="pagination" id="page">
	</ul>
</div>

<script>
var pageInfo = {};
var nowPage = "";
if(nowPage==""){
	nowPage = "1";
}
function callback(results) {
	var vendorList = results.vendorList;
	pageInfo = results.page;
	var resultStr = "";
	for(var i=0, max=vendorList.length;i<max;i++){
		var vendor = vendorList[i];
		resultStr += "<tr data-view='" + vendor.viNum + "'>";
		resultStr +="<td class='text-center'>" + vendor.viNum + "</td>";
		resultStr +="<td class='text-center'>" + vendor.viName + "</td>";
		resultStr +="<td class='text-center'>" + vendor.viDesc + "</td>";
		resultStr +="<td class='text-center'>" + vendor.viAddress + "</td>";
		resultStr +="<td class='text-center'>" + vendor.viPhone + "</td>";
		resultStr +="</tr>";
	}
	$('#result_tbody').html(resultStr);
	
	var search = results.search;
	var params = {};
	if(search.viNum!=0){
		params["viNum"] = search.viNum;
	}
	if(search.giName){
		params["viName"] = search.viName;
	}
	makePagination(pageInfo,"page");
	setEvent(pageInfo,params , "/list.vendor");
	
	$("tbody[id='result_tbody']>tr[data-view]").click(function(){
		var params = {};
		params["viNum"] = this.getAttribute("data-view");
		params["command"] = "view";
		var page = {};
		page["nowPage"] = pageInfo.nowPage;
		params["page"] = page;
		movePageWithAjax(params, "/list.vendor", callBackView);
	});
}
function callBackView(result){
	var url = result.url + "?nowPage=" + result.page.nowPage;
	url += "&giNum=" + result.goods.giNum;
	url += "&giName=" + result.goods.giName;
	url += "&giDesc=" + result.goods.giDesc;
	url += "&viNum=" + result.goods.viNum;
	url += "&viName=" + result.goods.viName;
	location.href=url;
}

$(document).ready(function() {
	var page = {};
	page["nowPage"] = nowPage;
	var params = {};
	params["page"] = page;
	params["command"] = "list";
	movePageWithAjax(params, "/list.vendor", callback);
});
</script>
</body>
</html>