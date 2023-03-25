<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<!-- Latest compiled and minified CSS -->
</head> 
<body> 
<input type="hidden" id="id" value="${board.id }" />
<%@ include file="../layout/header.jsp" %>
<br>
<div class="container">
<form>
	<div class="form-group">
	  <label for="title">Title</label>
	  <input type="text" class="form-control" placeholder="Enter title" id="title"  value="${board.title}">
	</div>
	<div class="form-group">
	  <label for="content">Content</label>
	  <textarea class="form-control summernote" rows="5" id="content">${board.content}</textarea>
	</div>
</form>
<button id="btn-update" class="btn btn-primary">글수정</button>
<button class="btn btn-primary" onclick="history.back()">돌아가기</button>
</div>
 <script>
   $('.summernote').summernote({
     tabsize: 20,
     height: 300
   });
 </script>
 <script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp" %>
</body> 
</html>
