<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
	<c:import url="./layout/bootStrap.jsp" />
	<c:import url="./layout/summernote.jsp" />
</head>

<body>
	<c:import url="./layout/nav.jsp" />

	<div style="padding-left: 20px;">
		<h1>Hello world!</h1>
		<P>The time on the server is ${serverTime}.</P>
	</div>
	
	
	<div id="index"></div>
	
	<button id="btn">Get Json1</button>
	
	
	<script type="text/javascript">
		//summernote
		$('#index').summernote();
		
		//json
		$('#btn').click(function() {
			$.get("./getJson1", function(data) {
				data = data.trim();
				//alert(typeof data); //data의 데이터타입을 묻는다. -> 여기서는 String타입임
				data = JSON.parse(data); //형변환해야한다. json object로  -> json object로 형이 변환됨
				
				
				//
				alert(data.name); //json object에서 키를 불러온다.
				
				
			});
		});
		
		
	</script>


</body>
</html>

