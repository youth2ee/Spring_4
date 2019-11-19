<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Login</title>
<c:import url="../layout/bootStrap.jsp" />
</head>
<body>
<c:import url="../layout/nav.jsp" />

<div class="container">
		<h2>Mypage</h2>

		<form action="#">
		
			<div class="form-group">
				<label for="id">Id:</label> 
				<input type="text" class="form-control" id="id" name="id" value="${member.id}" readonly="readonly">
			</div>

			<div class="form-group">
				<label for="pw">Password:</label> 
				<input type="password" class="form-control" id="pw" name="pw">
			</div>

			<div class="form-group">
				<label for="name">Name:</label> 
				<input type="text" class="form-control" id="name" name="name" value="${member.name}" readonly="readonly">
			</div>

			<div class="form-group">
				<label for="email">Email:</label> 
				<input type="text" class="form-control" id="email" name="email" value="${member.email}" readonly="readonly">
			</div>

			<div class="form-group">
				<label for="birth">Birth:</label> 
				<input type="text" class="form-control" id="birth" name="birth" value="${member.birth}" readonly="readonly">
			</div>

			<div class="form-group">
				<label for="gender">Gender: </label> 
				<input type="text" class="form-control" id="gender" name="gender" value="${member.gender}" readonly="readonly">
			</div>
			
			<div>
				<img style="width: 400px;" alt="" src="../resources/upload/member/${member.filename}"><br>
			</div>
			
			<div style="padding: 15px 0;">
				<input type="button" id="del" class="btn btn-default" value="회원탈퇴">
				<input type="button" id="up" class="btn btn-default" value="회원정보 수정">
			</div>

		</form>
	</div>

	<script type="text/javascript">
		$("#del").click(function() {
			location.href = "./memberDelete";
		});

		$("#up").click(function() {
			location.href = "./memberUpdate";
		});
	</script>


</body>
</html>