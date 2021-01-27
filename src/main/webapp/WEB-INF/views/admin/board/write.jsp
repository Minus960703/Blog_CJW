<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>운동하는 개발자 | 글 작성</title>
	<!-- css -->
	<link href="${pageContext.request.contextPath}/resources/css/index.css" rel="stylesheet" type="text/css">
	
	<!-- icon -->
	<link rel="shortcut icon" type="image⁄x-icon" href="${pageContext.request.contextPath}/resources/img/stepIcon.png">
	
	<!-- 제이쿼리 -->
	<script src='https://code.jquery.com/jquery-3.5.1.min.js'></script>
	
	<!-- 썸머노트 -->
	<script src="${pageContext.request.contextPath}/resources/js/summernote/summernote-lite.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/summernote/lang/summernote-ko-KR.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/summernote/summernote-lite.css">
	
	<script type="text/javascript">
		function uploadImageFile(file, editor) {
			data = new FormData();
			data.append("file", file);
			
			$.ajax({
				data : data,
				type : "POST",
				url : "./img",	
				dataType:'json',
			    async: true,
				processData: false,		
				contentType: false,				
				success : function(data) {
			    	//항상 업로드된 파일의 url이 있어야 한다.
			    	alert("업로드에 지연시간이 있습니다..");
			    	setTimeout(function(){
			    		   // 1초 후 작동해야할 코드
			    		alert(data.url);
			    		$(editor).summernote('insertImage', data.url);
			    		if(document.getElementById('bThumbnail').value=="null"){
			    			document.getElementById('bThumbnail').value=data.url;	
			    		}
			    		
			    		   }, 1000);  	
			    	
				},
				error:function(request,status,error){			
					alert("code = "+ request.status);
					alert(" message = " + request.responseText);
					alert(" error = " + error);			 	
					$(editor).summernote('insertImage', '');
				}
			
			});
			}
			
		$(document).ready(function() {
			$('#summernote').summernote({
				height: 300,                 // 에디터 높이
				minHeight: null,             // 최소 높이
				maxHeight: null,             // 최대 높이
				focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
				lang: "ko-KR",					// 한글 설정
				placeholder: '최대 2048자까지 쓸 수 있습니다',	//placeholder 설정
				callbacks: {	//여기 부분이 이미지를 첨부하는 부분
					onImageUpload : function(files) {
						uploadImageFile(files[0],this);				
					},
					onPaste: function (e) {
						var clipboardData = e.originalEvent.clipboardData;
						if (clipboardData && clipboardData.items && clipboardData.items.length) {
							var item = clipboardData.items[0];
							if (item.kind === 'file' && item.type.indexOf('image/') !== -1) {
								e.preventDefault();
							}
						}
					}
				}
		});
		
		});
	</script>
</head>
<body>
	<!-- NAV -->
	<%@ include file="../../include/nav.jsp" %>
	
	<!-- main -->
	<div id="wrap">
		<!-- aside -->
		<aside>
			<%@ include file="../../include/aside.jsp" %>
		</aside>
			<section id="content">
				<form role="form" method="post" autocomplete="off" enctype="multipart/form-data">
					<h2>게시글 등록</h2> <br /> 
					<label>분류</label>
					<select name="bPart" id="bPart">
						<option value="portfolio">포트폴리오</option>
						<option value="backend">백엔드</option>
						<option value="frontend">프론트엔드</option>
						<option value="exercise">운동</option>
					</select> <br /> 				
					 
					<label>제목</label>
					<input type="text" name="title" id="title"/><br />
					
					<label>내용</label>
					<textarea id="summernote" name="bCon" class="editordata"></textarea>
					
					<input type="hidden" id="bThumbnail" name="bThumbnail" value="null"/>
					
					<button type="submit">등록</button>
				</form>
		</section>
	</div>
	
	<!-- Footer -->
	<%@ include file="../../include/footer.jsp" %>
	
</body>
</html>