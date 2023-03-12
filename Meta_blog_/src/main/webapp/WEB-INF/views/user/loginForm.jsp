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
<%@ include file="../layout/header.jsp" %>
<br>
<div class="container">
<form action="/auth/loginProc" method="post">
  <div class="form-group">
    <label for="username">Username:</label>
    <input type="username" name="username" class="form-control" placeholder="Enter name" id="username">
  </div>
  <div class="form-group">
    <label for="password">Password:</label>
    <input type="password" name="password" class="form-control" placeholder="Enter password" id="password">
  </div>
  <div class="form-group form-check">
    <label class="form-check-label">
      <input class="form-check-input" type="checkbox"> Remember me
    </label>
  </div>
	<button id="btn-login" class="btn btn-primary">로그인</button>
</form>
</div>
<br>
<script src="/js/user.js?ver=3"></script>
<%@ include file="../layout/footer.jsp" %>
</body> 
</html>
