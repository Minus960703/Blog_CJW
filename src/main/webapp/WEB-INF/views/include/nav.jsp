<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<nav id="nav">
       <div id="content">
        <div id="logo">
            <a href="/"><img src="img/logo.png" alt="로고부분입니다."></a>
        </div>
	    <div id="login">
            <ul>
            <c:if test="${user == null}">
                <li><a href="/user/login">관리자</a></li>
			</c:if>
			<c:if test="${user != null}">
				<li><a href="/user/logout">Logout</a></li>
			</c:if>
            </ul>
        </div>
       </div>
	    <div id="part">
            <ul>
                <li>
                    <a href="/introduce"><span>Introduce</span></a>
                </li>
                <li>
                    <a href="/show/list"><span>Personal</span></a>
                </li>
                <li>
                    <a href="/portfolio/list?c=portfolio"><span>PortFolio</span></a>   
                </li>
            </ul>
        </div>
	</nav>