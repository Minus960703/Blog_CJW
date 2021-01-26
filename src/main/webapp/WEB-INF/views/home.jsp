<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>운동하는 개발자 CJW</title>
	
	<!-- css -->
	<link href="${pageContext.request.contextPath}/resources/css/index.css" rel="stylesheet" type="text/css">
	
	<!-- icon -->
	<link rel="shortcut icon" type="image⁄x-icon" href="${pageContext.request.contextPath}/resources/images/stepIcon.png">
</head>
<body>
	<!-- NAV -->
	<%@ include file="include/nav.jsp" %>
	
	<!-- main -->
	<div id="wrap">
		<!-- aside -->
		<aside>
			<%@ include file="include/aside.jsp" %>
		</aside>
		<section id="content">
			
		</section>
	</div>
	
	<!-- Footer -->
	<%@ include file="include/footer.jsp" %>

</body>
</html>
