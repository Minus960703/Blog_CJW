<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>운동하는 개발자 CJW | 회원가입</title>
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
					<input type="text" id="userId" name="userId" placeholder="아이디를 입력해주세요" required="required" />
					<br/>
					
					<label for="userPass">비밀번호</label>
					<input type="password" id="userPass" name="userPass" required="required" />
					<br/>
					
					<label for="userName">이름</label>
					<input type="text" id="userName" name="userName" placeholder="이름을 입력해주세요" required="required" />
					<br/>
					
					<label for="userNick">닉네임</label>
					<input type="text" id="userNick" name="userNick" placeholder="닉네임을 입력해주세요" required="required" />
					<br/>
					
					<label for="userPhone">연락처</label>
					<input type="text" id="userPhone" name="userPhone" placeholder="연락처를 입력해주세요" required="required" />
					<br/>
					
					<label for="userEmail">이메일</label>
					<input type="email" id="userEmail" name="userEmail" placeholder="이메일을 입력해주세요" required="required" />
					<br/>
					<button type="submit" id="join_btn" name="join_btn">회원가입</button>
					
				</form>
			</div>
		</section>
	</div>
	
	<!-- Footer -->
	<%@ include file="../include/footer.jsp" %>
</body>
</html>