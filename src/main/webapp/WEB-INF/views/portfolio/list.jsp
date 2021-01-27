<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>운동하는 개발자 | 글 목록</title>
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
			<div id="boardlist">
				<c:forEach items="${list}" var="list">
				<p id="font_date"><fmt:formatDate value="${list.bDate}" pattern="yyyyMMdd"></fmt:formatDate></p>
			    <div><img src="${list.bThumbnail}"></div>
			    <div><a href="/portfolio/view?n=${list.bno}">${list.title}</a></div>
				<p>${list.userNick}</p>
				</c:forEach>
			</div>
			<c:if test="${user != null and user.grade == 1}">
				<a href="/admin/board/write">글 작성</a>
			</c:if>
		</section>
	</div>
	
	<!-- Footer -->
	<%@ include file="../include/footer.jsp" %>

</body>
</html>