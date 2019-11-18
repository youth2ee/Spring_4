
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
				<div id="checkId" style="padding-top: 10px; "></div>
			
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
				<label for="phone">Phone:</label> 
				<input type="number" class="form-control" id="phone" name="phone">
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

			<!-- <button class="btn btn-default">JOIN</button> -->
			<input type="button" class="btn btn-default" value="회원가입" id="join">

		</form>
	</div>


	<script type="text/javascript">
		var idCheck = false;
		//false면 중복된 아이디 가지거나 중복검사를 하지 않았다.
		//true면 중복되지 않은 아이디를 가진다.

		$("#join").click(function() {
			alert(idCheck);
		});

		//

		$("#id").blur(function() {
			check();
		});

		$("#id").change(function() {
			$("#checkId").html("");
			check();
		});

		function check() {
			var id = $('#id').val();
			$.get("./memberIdCheck?id=" + id, function(data) {
				/*  $("#checkId").html(data);  */

				if (data == 1) {
					/* 중복 가능 */
					/* $("#checkId").css("color","green"); */

					if (id == "") {
						alert("아이디를 입력하세요")
					} else {
						$("#checkId").prop("class", "text-success");
						$("#checkId").html("사용가능한 아이디입니다.");
						idCheck = true;
					}
				} else {
					/* 중복 불가능 */
					$('#id').val("");
					/* $("#checkId").css("color","red"); */
					$("#checkId").prop("class", "text-danger");
					$("#checkId").html("사용불가능한 아이디입니다.");
					$('#id').focus();
					idCheck = false;
				}
			});
		}

		//모든 칸 입력하기
		
		//비밀번호 확인
		
		//이메일 확인 (=아이디확인)
		
	</script>


</body>
</html>