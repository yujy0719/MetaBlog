<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>Hello JSP</title> 
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head> 
<body> 
<%@ include file="layout/header.jsp" %>
<br>
<div class="container">
	<div class="card m-2" >
	  <div class="card-body">
	    <h4 class="card-title">제목적는부분</h4>
	    <p class="card-text">내용적는부분</p>
	    <a href="#" class="btn btn-primary">상세보기</a>
	  </div>
	</div>
	<div class="card m-2" >
	  <div class="card-body">
	    <h4 class="card-title">제목적는부분</h4>
	    <p class="card-text">내용적는부분</p>
	    <a href="#" class="btn btn-primary">상세보기</a>
	  </div>
	</div>
	<div class="card m-2" >
	  <div class="card-body">
	    <h4 class="card-title">제목적는부분</h4>
	    <p class="card-text">내용적는부분</p>
	    <a href="#" class="btn btn-primary">상세보기</a>
	  </div>
	</div>
</div>
<%@ include file="layout/footer.jsp" %>
</body> 
</html>
