<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Join</title>
<c:import url="../layout/bootStrap.jsp" />
</head>
<body>
<c:import url="../layout/nav.jsp" />

	<div class="container">
		<h2>Member Join</h2>

		<form action="./memberJoin" method="post">

			<div class="form-group">
				<label for="id">Id:</label> 
				<input type="text" class="form-control" id="id" name="id">
				
				<input type="button" class="btn btn-default" id="checkId" value="중복확인">
			</div>

			<div class="form-group">
				<label for="pw">Password:</label> 
				<input type="password" class="form-control" id="pw" name="pw">
			</div>

			<div class="form-group">
				<label for="pw">Password:</label> 
				<input type="password" class="form-control" id="pw2" name="pw2">
			</div>

			<div class="form-group">
				<label for="name">Name:</label> 
				<input type="text" class="form-control" id="name" name="name">
			</div>

			<div class="form-group">
				<label for="email">Email:</label> 
				<input type="email" class="form-control" id="email" name="email">
			</div>

			<div class="form-group">
				<label for="birth">Birth:</label> 
				<input type="date" class="form-control" id="birth" name="birth">
			</div>

			<div class="form-group">
				<label for="gender">Gender: </label> 
				
				<label class="radio-inline">
					<input type="radio" name="gender" checked value="F">F
				</label> 
				
				<label class="radio-inline"> 
					<input type="radio" name="gender" value="M">M
				</label>
			</div>

			<button class="btn btn-default">JOIN</button>

		</form>
	</div>


<script type="text/javascript">

	$("#checkId").click(function() { //callback함수
		var id = $("#id").val();
		window.open("./memberIdCheck?id="+id, "", "width=600, height=300, top=200, left=600");
	});
	
</script>


</body>
</html>