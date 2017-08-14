<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>jQuery Exam 01</TITLE>
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
/* 태그안에 class속성값이 "first" 인 녀석들의 스타일속성을 지정해줍니다. 앞에보면 "."이 붙어 있죠? 위의 div와의
 차이를 아시겠죠?*/
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
<!--  아까 exam폴더안에 js라는 폴더안에 다운받은 js파일을 넣어 놓았었지요?
       아래의 내용은 그걸 명시해준겁니다. 내가 참조하는 js가 어디있는지를 알려주는 것이지요 -->
<script type="text/javascript" src="/js/jquery-1.12.1.min.js"> </script>
<script type="text/javascript" src="/js/jquery-2.2.1.min.js"> </script>
<BODY>
	<p>
		<button>Run</button>
	</p>
	<!-- div태그에 class속성값이 "first입니다. 즉 위의 스타일에서 지정해준 div스타일과 .frist의 스타일이 같이 먹힌단
 이야깁니다.-->
	<div class="first"></div>
	<!-- 위와 마찬가지로 div스타일와 .second의 스타일이 같이 적용되게 됩니다.-->
	<div class="second"></div>

<script type="text/javascript">    
 	$("button").click(function() {
  		$("div.first").slideUp(1000);      
  		$("div.second").slideUp(300);    
  	});
     
</script>


</BODY>
</HTML>