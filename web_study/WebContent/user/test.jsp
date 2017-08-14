<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>New Document</TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
</HEAD>
<style>
/* div태그 전체에 대한 스타일을 지정해 줍니다. div{}  <--요안에 명시해주면 "<div"로 시작하는 전체가 같은 스타일이 적용됩니다.*/
div {
	position: absolute;
	width: 60px;
	height: 60px;
	float: left;
}
/* 태그안에 class속성값이 "first" 인 녀석들의 스타일속성을 지정해줍니다. 앞에보면 "."이 붙어 있죠? 위의 div와의 차이를 아시겠죠?*/
.first {
	background-color: #3f3;
	left: 0;
}
/* 마찬가지로 class속성값이 "second"인 녀석들의 스타일속성을 지정해줍니다.*/
.second {
	background-color: #33f;
	left: 80px;
}
</style>
<BODY>
	<p>
		<input type="button" value="Run" id="runBtn">
	</p>
	<!-- div태그에 class속성값이 "first입니다. 즉 위의 스타일에서 지정해준 div스타일과 .frist의 스타일이 같이 먹힌단 이야깁니다.-->
	<div class="first"></div>
	<!-- 위와 마찬가지로 div스타일와 .second의 스타일이 같이 적용되게 됩니다.-->
	<div class="second"></div>

	<SCRIPT LANGUAGE="JavaScript">
 // 첫번째 div객체로 받을 변수를 선언합니다.
 var slideUpObj1 = null;
 // 두번째니까 당근 second겠죠?
 var sildeUpObj2 = null;
 
 // first div객체에 슬라이드업 효과를 줄 함수입니다.
 function slideUp1(){
  var divObjHeight = parseInt(slideUpObj1.currentStyle.height);
  divObjHeight = divObjHeight-1;
  if(divObjHeight>0){
   slideUpObj1.style.height = divObjHeight + "px";
   setTimeout(slideUp1, 15);
  }else{
   slideUpObj1.style.display="none";
  }
 }
 
 // second div객체에 슬라이드업 효과를 줄 함수입니다.
 function slideUp2(){
  var divObjHeight = parseInt(slideUpObj2.currentStyle.height);
  divObjHeight = divObjHeight-1;
  if(divObjHeight>0){
   slideUpObj2.style.height = divObjHeight + "px";
   setTimeout(slideUp2, 15);
  }else{
   slideUpObj2.style.display="none";
  }
 }
 // button onclick 이벤트시에 일어나는 일을 정의해줍니다.
 document.getElementById("runBtn").onclick=function(e){
  var divObjs = document.getElementsByTagName("div");
  for(var i=0;i<divObjs.length;i++){
   var divObj = divObjs[i];
   var classStr = divObj.className;
   if(classStr == "first"){
    slideUpObj1 = divObj;
    slideUp1();
   }else if(classStr == "second"){
    slideUpObj2 = divObj;
    slideUp2();
   }
  }
 }
</SCRIPT>
</BODY>
</HTML>