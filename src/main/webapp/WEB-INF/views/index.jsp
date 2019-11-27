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
	<button id="btn2">Get Json2</button>
	<button id="btn3">Get Json3</button>
	
	<div style="padding-left: 30px; font-weight: bolder; font-size: 20px;" id="movie"></div>
	
	
	
	<script type="text/javascript">
		//summernote
		$('#index').summernote();
		
		
		//json
		$('#btn').click(function() {
/* 			$.get("./getJson1", function(data) {
				data = data.trim();
				//alert(typeof data); //data의 데이터타입을 묻는다. -> 여기서는 String타입임
				data = JSON.parse(data); //형변환해야한다. json object로  -> json object로 형이 변환됨
				
				//
				alert(data.name); //json object에서 키를 불러온다.
				
				
			}); */
			
			/*
			$.get("./getJson2?num=439", function(data) {
				data = data.trim();
				data = JSON.parse(data); //형변환해야한다. json object로  -> json object로 형이 변환됨
				
				//
				alert("writer : "+ data.writer); //json object에서 키를 불러온다.
				alert("title : "+ data.title);
				alert("contents : "+data.contents);
				
			}); */
			
			
			/*
			$.get("./getJson2?num=439", function(data) {
				alert(typeof data);
				//jsonController에서 데이터를 바로 보낸다면 여기서 받는 data도 바로 jsonObject형으로 받는다. 형변환 필요없다.
				alert(data.title);
				alert(data.contents);
				alert(data.writer);
			}); */
			
			$.get("./getJson3", function(data) {
				//alert(data[0].num);
				
				//for(var i = 0 ; i<data.length ; i++){
				//	console.log(data[i].num);
				//}
				
				$.each(data, function(i, vo) {
					console.log(i);
					console.log(vo.num);
				});
				
			}); 
			
		});
		
		
		//json : 외부 api
		$('#btn2').click(function() {
			/*
			$.get("https://api.manana.kr/exchange/price/KRW/1000/KRW,USD,JPY.json", function(data) {
					alert(typeof data);
					console.log(data);
					alert(data.KRW);
					alert(data.USD);
					alert(data.JPY);
			});
			*/
			
			$.ajax({
				type : "GET",
				url : "https://api.manana.kr/exchange/price.json",
				data : {
					base : "USD",
					price : 1,
					code : "KRW"
				},
				success : function(data) {
					console.log(data.KRW);
				}
				
			});
			
		});
		
		
		$('#btn3').click(function() {
			$.ajax({
				type : "GET",
				url : "https://yts.lt/api/v2/list_movies.json",
				data : {
					movie_count : 1000,
					limit : "20",
					page_number : 1
				},
				success : function(data) {
					//console.log(data.data.movies[0].title);
					
					$.each(data.data.movies, function(i, vo) {
						//console.log(vo.title);
						$("#movie").append(vo.title_long + "<br>" +"<img src=\""+vo.medium_cover_image +"\">" + "<br>");
						$("#movie").append(vo.runtime + "<br><br>");
						
					});
					
				}
				
			});
			
		});
		
		
		
		
		
	</script>


</body>
</html>

