
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>Hello JSP</title> 
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
 <script src="https://code.jquery.com/jquery-latest.min.js"></script>
 
</head> 
<body> 
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
 <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="/blog">HOME</a>
    </li>
    <c:choose>
    	<c:when test="${empty sessionScope.principal}"> 
		    <li class="nav-item">
		      <a class="nav-link" href="/loginForm">로그인</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link" href="/joinForm">회원가입</a>
		    </li>
	    </c:when>
	    <c:otherwise>
	    	<li class="nav-item">
		      <a class="nav-link" href="/board/form">글쓰기</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link" href="user/form">회원정보</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link disabled" href="/logout">로그아웃</a>
		    </li>
		</c:otherwise>
    </c:choose>
  </ul>
</nav>
</body>
</html>