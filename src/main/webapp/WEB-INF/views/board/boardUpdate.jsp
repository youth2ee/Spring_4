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
	
	<form action="./${board}Update" method="post" style="width: 70%; margin: 0 auto;" enctype="multipart/form-data">
	
				<input type="hidden" name="num" value="${dto.num}">
		
				<div class="form-group">
					<label for="title">Title:</label> 
					<input type="text" name="title" class="form-control" id="title" placeholder="Enter title" value="${dto.title}">
				</div>

				<div class="form-group">
					<label for="contents">Contents:</label>
					<textarea rows="20" cols="" name="contents" class="form-control" id="contents" placeholder="Enter contents">${dto.contents}</textarea>
				</div>


				<div>
				<c:forEach items="${dto.files}" var="file">
					<div class="form-group">
						<p>${file.oname}<input type="button" id="${file.fnum}" value="del" class="del"></p>
						
<%-- 					<div style="width: 100px; float: left;"><label for="file">File:</label></div>
						<div style="width: 100px; float: left;"><a href="../resources/upload/${board}/${file.fname}">${file.oname}</a></div>
						<input type="button" class="btn btn-default" value="수정">	 --%>
					
					</div>				
				 </c:forEach>
				</div>

				<button>Update</button>
				
	</form>
	
	<script type="text/javascript">
		$(".del").click(function() {
			var fnum = $(this).attr("id");

			$.post("./fileDelete", {fnum:fnum}, function(data) {
				alert(data);			
			});

		});
	
	</script>
	

</body>
</html>