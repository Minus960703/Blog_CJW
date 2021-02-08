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
	<%@ include file="../../include/nav.jsp" %>
	
	<!-- main -->
	<div id="wrap">
		<!-- aside -->
		<aside id="aside">
			<%@ include file="../../include/aside.jsp" %>
		</aside>
		<section id="content">
			<table>
			 <thead>
			  <tr>
			   <th>썸네일</th>
			   <th>제목</th>
			   <th>작성자</th>
			   <th>카테고리</th>
			   <th>날짜</th>
			  </tr>
			 </thead>
			 <tbody>
			  <c:forEach items="${list}" var="list">
			  <tr>
			   <td><img src="${list.bThumbnail}"></td>
			   <td><a href="/admin/board/view?n=${list.bno}">${list.title}</a></td>
			   <td>${list.userNick}</td>
			   <td>${list.bPart}</td>
			   <td>
			   	<fmt:formatDate value="${list.bDate}" pattern="yyyy-MM-dd"></fmt:formatDate>
			   </td>
			  </tr>   
			  </c:forEach>
			 </tbody>
			</table>
			<c:if test="${user != null and user.grade == 1}">
				<a href="/admin/board/write">글 작성</a>
			</c:if>
		</section>
	</div>
	
	<!-- Footer -->
	<%@ include file="../../include/footer.jsp" %>
</body>
</html>