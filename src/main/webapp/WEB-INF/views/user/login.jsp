<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>운동하는 개발자 CJW | 로그인</title>
	<!-- css -->
	<link href="${pageContext.request.contextPath}/resources/css/index.css" rel="stylesheet" type="text/css">
	
	<!-- icon -->
	<link rel="shortcut icon" type="image⁄x-icon" href="${pageContext.request.contextPath}/resources/images/stepIcon.png">
</head>
<body>
	<!-- NAV -->
	<%@ include file="../include/nav.jsp" %>
	
	<!-- main -->
	<div id="wrap">
		<section id="content">
			<div id="loginArea">
				<form role="form" method="post" autocomplete="off">
					<label for="userId">아이디</label>
					<input type="text" id="userId" name="userId" required="required" />
					
					<br/>
					
					<label for="userPass">비밀번호</label>
					<input type="password" id="userPass" name="userPass" required="required" />
					
					<button type="submit" id="login_btn" name="login_btn">Login</button>
					
					<c:if test="${msg == false}">
						<p style="color:#f00;">로그인에 실패했습니다.</p>
					</c:if>
				</form>
			</div>
		</section>
	</div>
	
	<!-- Footer -->
	<%@ include file="../include/footer.jsp" %>
</body>
</html>