<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>운동하는 개발자 | 글 보기</title>
	<!-- css -->
	<link href="${pageContext.request.contextPath}/resources/css/index.css" rel="stylesheet" type="text/css">
	
	<!-- icon -->
	<link rel="shortcut icon" type="image⁄x-icon" href="${pageContext.request.contextPath}/resources/img/stepIcon.png">

	<!-- 제이쿼리 -->
	<script src='https://code.jquery.com/jquery-3.5.1.min.js'></script>
</head>
<body>
	<!-- NAV -->
	<%@ include file="../include/nav.jsp" %>
	
	<!-- main -->
	<div id="wrap">
		<!-- aside -->
			<%@ include file="../include/aside.jsp" %>
			<section id="content">
				<form role="form" method="post" autocomplete="off" enctype="multipart/form-data">
				<div id="viewBox">
					<div id="titlebar">
						<h2>${list.title}</h2>
					</div>
					<div id="sub">
						<h4>${list.userNick}(${list.userId})</h4>
						<span id="datebar"><fmt:formatDate value="${list.bDate}" pattern="yyyyMMdd" /></span>
					</div>
					<div id="con">
						${list.bCon}
					</div>
					<c:if test="${user != null and user.grade == 1}">
					<button type="button" id="modify_Btn">수정</button>
			 		<button type="button" id="delete_Btn">삭제</button>
			 		</c:if>
			 		<script>
					  var formObj = $("form[role='form']");
					  
					  $("#modify_Btn").click(function(){
					   formObj.attr("action", "/admin/board/modify");
					   formObj.attr("method", "get")
					   formObj.submit();
					  });
					  
					  $("#delete_Btn").click(function(){    
						  var con = confirm("정말로 삭제 하시겠습니까?");	//true, false 반환
						  
						  if(con){
							  formObj.attr("action", "/admin/board/delete");
							  formObj.submit();
						  }
					  });
					 </script>
					 <input type="hidden" name="n" value="${list.bno}">
				</div>
				</form>
		</section>
	</div>
	
	<!-- Footer -->
	<%@ include file="../include/footer.jsp" %>
	
</body>
</html>