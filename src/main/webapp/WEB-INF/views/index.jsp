<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
	<c:import url="./layout/bootStrap.jsp" />
</head>

<body>
	<c:import url="./layout/nav.jsp" />

	<div style="padding-left: 20px;">
		<h1>Hello world!</h1>
		<P>The time on the server is ${serverTime}.</P>

		<!--  -->
		
		<input type="text" id="num"> 
		<div><button id="btn">NUMBER</button></div>
		<div id="result" style="height: 30px;"></div>
		
		<!--  -->
		
		<div>
			<select id="select">
				<option value="dog">Dog</option>
				<option value="cat">Cat</option>
				<option value="bird">Bird</option>
			</select>
			
			<div id="kind">
				<select>
					<option>강아지1</option>
					<option>강아지2</option>
					<option>강아지3</option>
				</select>
			</div>
		</div>
		
		<!--  -->
		
		<div id="noticeResult"></div>
		
	</div>
	
	<!-- script -->
	
	<script type="text/javascript">

	//1. 클릭하면 번호뜨게하기
		$("#btn").click(function() {

			//var xhttp라고 선언을 꼭 안해주고 변수를 바로 사용해도 가능하다. 
			//script언어는 좀 자유롭다.

			var xhttp;

			if (window.XMLHttpRequest) {
				// code for modern browsers
				xhttp = new XMLHttpRequest();
			} else {
				// code for IE6, IE5
				xhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}

			//위의 input의 num값 받아오기
			var num = $("#num").val();
			
			
			//request 정보 : GET	
			/* xhttp.open("GET", "./testAjax?num="+num); */
			
			//send 보내기 : GET방식
			/* xhttp.send(); */
			
			
			//request 정보 : POST	
			xhttp.open("POST", "./testAjax");
			
			//send 보내기 : POST방식 -()안에 파라미터값 넣어준다.
			xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhttp.send("num="+num);
			

			//사실상 send 후에 발생하지만, 일종의 이벤트이므로 작성의 위치는 상관없다.
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					/* document.getElementById("result").innerHTML = this.responseText; */
					$("#result").html(this.responseText);

					/* alert(this.responseText); */
					/* document.getElementById("demo").innerHTML = this.responseText; */
				}
			};
		});
		
		
		//2. select 연계하기 
			$("#select").change(function() {
				//1. xmlhttp 객체생성
				var xhttp;
				if (XMLHttpRequest) {
					xhttp = new XMLHttpRequest();
				} else {
					xhttp = new ActiveXObject("Microsoft.XMLHTTP");
				}

				//2. 요청정보 작성
				xhttp.open("GET", "./selectAnimal?animal="+$("#select").val());
				
				//3. 요청정보 전송 : GET
				xhttp.send();
				
				
				xhttp.onreadystatechange = function() {
					if (this.readyState == 4 && this.status == 200) {
						$("#kind").html(this.responseText);
					}
				};
				
			});
		
		
		//3. list 불러오기 
				var xhttp;
				if (XMLHttpRequest) {
					xhttp = new XMLHttpRequest();
				} else {
					xhttp = new ActiveXObject("Microsoft.XMLHTTP");
				}

				/* xhttp.open("GET", "notice/noticeList?result=5"); */
				xhttp.open("GET", "notice/noticeResult");
				xhttp.send();
				
				xhttp.onreadystatechange = function() {
					if (this.readyState == 4 && this.status == 200) {
						$("#noticeResult").html(this.responseText);
					}
				};
				
		
	</script>

</body>
</html>
