<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<!-- Latest compiled and minified CSS -->
</head> 
<body> 
<%@ include file="../layout/header.jsp" %>
<br>
<div class="container">
<input type="hidden" id="id" value="${board.id }" />
<button id="btn-back" class="btn btn-secondary" onclick="history.back()">돌아가기</button>
<c:if test="${board.user.id == principal.user.id }">
	<a href="/board/${board.id }/updateForm" class="btn btn-warning">수정</a>
	<button id="btn-delete" class="btn btn-danger" >삭제</button>
</c:if>
<br>
<div>
	글 번호 : <span><i>${board.id }</i></span>
	작성자 : <span><i>${board.user.username }</i></span>
</div>
<br>
	<div>
	  <h3>${board.title}</h3>
	</div>
	<hr>
	<div>
	  <div> ${board.content}</div>
	</div>
</div>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp" %>
</body> 
</html>
 