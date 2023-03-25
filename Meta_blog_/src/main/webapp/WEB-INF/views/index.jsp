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
	<c:forEach items="${boardList.content}" var="board">
		<div class="card m-2" >
		  <div class="card-body">
		    <h4 class="card-title">${board.title }</h4>
		     <%-- <p class="card-text">${board.content }</p> --%>
		    <a href="/board/${board.id}" class="btn btn-primary">상세보기</a>
		  </div>
		</div>
	</c:forEach>
</div>
<ul class="pagination justify-content-center">
	<c:choose>
		<c:when test="${boardList.first }">
			<li class="page-item disabled"><a class="page-link" href="?page=${boardList.number-1}">Previous</a></li>
		<!--   <li class="page-item"><a class="page-link" href="#">1</a></li> -->
		</c:when>
		<c:otherwise>
			<li class="page-item"><a class="page-link" href="?page=${boardList.number-1}">Previous</a></li>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${boardList.last }">
		  <li class="page-item disabled"><a class="page-link" href="?page=${boardList.number+1}">Next</a></li>
		</c:when>
		<c:otherwise>
		  <li class="page-item"><a class="page-link" href="?page=${boardList.number+1}">Next</a></li>
		</c:otherwise>
	</c:choose>
</ul>
<%@ include file="layout/footer.jsp" %>
</body> 

</html>
