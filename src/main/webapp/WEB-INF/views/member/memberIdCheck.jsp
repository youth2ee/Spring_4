<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member id check</title>
	<c:import url="../layout/bootStrap.jsp" />
</head>

<body>


	<div class="container">
		<h2>중복확인</h2>
		
		<form action="./memberIdCheck">
		
			<h1>${param.id}: ${msg}</h1>
			
			<div class="form-group">
				<label for="id">ID:</label> 
				<input type="text" class="form-control" id="id" name="id" value="${param.id}">
			</div>

			<button type="submit" class="btn btn-default">확인</button>

			<c:if test="${empty vo}">
				<input type="button" class="btn btn-default" value="사용하기" id="useId">
			</c:if>

		</form>
	</div>
	
<script type="text/javascript">
	$("#useId").click(function() {
		var id = $("#id").val();
		
		//javascript로 보내기
		//opener.document.getElementById("id").value = id;
		
		//jquery로 보내기
		$("#id", opener.document).val(id);
		
		window.self.close();
	});
	



</script>



</body>
</html>