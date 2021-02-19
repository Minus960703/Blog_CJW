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
	<script>
		function commentList(){
			var bno = ${list.bno};
			$.getJSON("/personal/view/commentList" + "?n=" + bno, function (data){
				var str = "";

				$(data).each(function (){
					console.log(data);

					var cDate = new Date(this.cDate);
					cDate = cDate.toLocaleDateString("ko-US")

					str += "<li data-bno='" + this.bno + "'>"
							+ "<span class='userNick'>" + this.userNick + "</span>"
							+ "<span class='cDate'>" + cDate + "</span>"
							+ "<div class='cCon'>" + this.cCon + "</div>"

							+ "<div class='commentFooter'>"
							+ "<button type='button' class='modify' data-cno='" + this.cno + "'>수정</button>"
							+ "<button type='button' class='delete' data-cno='" + this.cno + "'>삭제</button>"
							+ "</li>";
				});

				$("div.commentList ol").html(str);
			});
		}
	</script>
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
						<div id="writer_column">
							작성자 : ${list.userNick}(${list.userId})
							<span id="date_column"><fmt:formatDate value="${list.bDate}" pattern="yyyy-MM-dd" /></span>
						</div>
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
		<section id="comment">
			<c:if test="${user == null}">
				<p>댓글 등록은 <a href="/user/login">로그인</a> 후에 가능합니다.</p>
			</c:if>
			<c:if test="${user != null}">
				<div class="commentForm">
					<form role="form" method="post" autocomplete="off">
						<input type="hidden" name="bno" id="bno" value="${list.bno}" >
						<textarea name="cCon" id="cCon"></textarea>
						<button type="button" id="comment_btn">댓글 등록</button>

						<script>
								$("#comment_btn").click(function(){

								var formObj = $(".commentForm form[role='form']");
								var bno = $("#bno").val();
								var cCon = $("#cCon").val()

								var data = {
								bno : bno,
								cCon : cCon
							};

								$.ajax({
								url : "/personal/view/commentregist",
								type : "post",
								data : data,
								success : function(){
								commentList();
								$("#cCon").val("");
							}
							});
							});
						</script>
					</form>
				</div>
			</c:if>
			<div class="commentList">
				<ol>
					<%--
					<c:forEach items="${commentlist}" var="commentlist">
						<li>
							<div id="">
								<span>${commentlist.userNick}</span>
								<span><fmt:formatDate value="${commentlist.cDate}" pattern="yyyy-MM-dd"/></span>
							</div>
							<div>${commentlist.cCon}</div>
						</li>
					</c:forEach>
					--%>
				</ol>

				<script>
					commentList();
				</script>

				<script>
					$(document).on("click", ".delete", function (){

						var deleteConfirm = confirm("정말 삭제하시겠습니까?");

						if(deleteConfirm){
							var data = { cno : $(this).attr("data-cno")};

							$.ajax({
								url : "/personal/view/commentdelete",
								type : "post",
								data : data,
								success : function (result){
									if(result == 1){
									commentList();
									}else {
										alert("작성자 본인만 삭제 가능 합니다.")
									}
								},
								error : function (){
									alert("로그인하셔야합니다.")
								}
							});
						}
					});
				</script>

			</div>
		</section>
	</div>
	
	<!-- Footer -->
	<%@ include file="../include/footer.jsp" %>
	
</body>
</html>