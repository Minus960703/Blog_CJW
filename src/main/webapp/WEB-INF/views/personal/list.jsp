<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
		<!-- aside -->
		<%@ include file="../include/aside.jsp" %>
		<section id="content">
			<div id="boardlist">
				<c:forEach items="${list}" var="list">
				<div id="child">
					<div class="date_column">
						<fmt:formatDate value="${list.bDate}" pattern="yyyyMMdd"></fmt:formatDate>
					</div>
					<div id="sub">
						<div class="thumbnail_column">
							<img src="${list.bThumbnail}">	
						</div>
						<div class="title_column">
							<a href="/personal/view?n=${list.bno}">${list.title}</a>
							
							<span id="con_column"> <!-- 글자수 200 이상이 되면 200자 까지 제한 ~ -->
							<c:if test="${fn:length(list.bCon)>200}">
								${fn:substring(list.bCon,0,200)}...
							</c:if>
							<c:if test="${fn:length(list.bCon)<=200}">
								${list.bCon}
							</c:if>
							</span>	
						</div>
					</div>
				</div>
				</c:forEach>
			</div>
			<c:if test="${user.grade != 1}">
				<p>글을 쓸수 있는 권한이 없습니다.</p>
			</c:if>
			<c:if test="${user.grade == 1}">
				<a href="/admin/board/write">글 작성</a>
			</c:if>
		</section>
	</div>
	
	<!-- Footer -->
	<%@ include file="../include/footer.jsp" %>

</body>
</html>