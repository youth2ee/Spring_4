<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board} update</title>
<c:import url="../layout/bootStrap.jsp" />
</head>
<body>
<c:import url="../layout/nav.jsp" />
	
	<h1>${board} Update</h1>
	
	<form action="./${board}Update" method="post"  style="width: 70%; margin: 0 auto;">
	
				<input type="hidden" name="num" value="${dto.num}">
		
				<div class="form-group">
					<label for="title">Title:</label> 
					<input type="text" name="title" class="form-control" id="title" placeholder="Enter title" value="${dto.title}">
				</div>

				<div class="form-group">
					<label for="contents">Contents:</label>
					<textarea rows="20" cols="" name="contents" class="form-control" id="contents" placeholder="Enter contents">${dto.contents}</textarea>
				</div>

				<c:forEach items="${dto.files}" var="file">
				<div class="form-group">
					<label for="file">File:</label>
			
				<a style="width: 200px;" href="../resources/upload/${board}/${file.fname}">${file.oname}</a>
			
					<input type="button" class="btn btn-default" value="수정">
				</div>				
				 </c:forEach>


				<button>Update</button>
				
	</form>
	
	<button id="aa">reak</button>
	
	<script type="text/javascript">
	

	
	</script>
	

</body>
</html>