<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%> 
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form>
  <div class="form-group">
    <label for="username">Username:</label>
    <input type="username"  class="form-control" placeholder="Enter name" id="username">
  </div>
  <div class="form-group">
    <label for="password">Password:</label>
    <input type="password" class="form-control" placeholder="Enter password" id="password">
  </div>
  <div class="form-group">
    <label for="email">Email:</label>
    <input type="email" class="form-control" placeholder="Enter email" id="email">
  </div>
</form>
<button type="button" id="btn-save" class="btn btn-primary">회원가입완료</button>
</div>
<br>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>
</body> 
</html>
