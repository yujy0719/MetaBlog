
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!-- 
	스프링시큐리티 사용법
	https://docs.spring.io/spring-security/site/docs/3.0.x/reference/el-access.html 
-->
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal"/>
</sec:authorize>
<%-- <sec:authorize access="!isAuthenticated()">
	<script>
		alert("로그인 안된 사용자입니다.")
	</script>
</sec:authorize> --%>

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
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<!-- include summernote css/js -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
</head> 
<body> 
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
 <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="/">HOME</a>
    </li>
    <c:choose>
    	<c:when test="${empty principal}"> 
		    <li class="nav-item">
		      <a class="nav-link" href="/auth/loginForm">로그인</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link" href="/auth/joinForm">회원가입</a>
		    </li>
	    </c:when>
	    <c:otherwise>
	    	<li class="nav-item">
		      <a class="nav-link" href="/board/saveForm">글쓰기</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link" href="/user/updateForm">회원정보</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link" href="/logout">로그아웃</a>
		    </li>
		</c:otherwise>
    </c:choose>
  </ul>
</nav>
</body>
</html>