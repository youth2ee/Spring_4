<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board} write</title>
<c:import url="../layout/bootStrap.jsp" />
</head>
<body>
	<c:import url="../layout/nav.jsp" />
	
	<h1>${board} Write</h1>
	
	<form action="./${board}Write" method="post" style="width: 70%; margin: 0 auto;" enctype="multipart/form-data">
		
				<div class="form-group">
					<label for="title">Title:</label> 
					<input type="text" name="title" class="form-control" id="title" placeholder="Enter title">
				</div>

				<div class="form-group">
					<label for="writer">Writer:</label>
					<input type="text" name="writer" class="form-control" id="writer" placeholder="Enter writer">
				</div>

				<div class="form-group">
					<label for="contents">Contents:</label>
					<textarea rows="10" cols="" name="contents" class="form-control" id="contents" placeholder="Enter contents"></textarea>
				</div>


		<div id="files">
			<div class="form-group" title="parent">
				<label for="file">File:</label> 
				<input type="file" name="file" class="form-control"> 
				<input type="button" class="btn btn-danger del" value="del">
			</div>
		</div>


		<input type="button" class="btn btn-success" value="ADD FILE" id="add">
		
		<button>Write</button>
	
	</form>
	
	<script type="text/javascript">

	var files = $("#files").html();
	var count = 0;
	var index = 0; //인덱스번호 사용하기
	$("#files").empty();
	
	

/* 		$("#files").delegate(".del", "click", function(){
			alert("add");
		}); */
		
		
		$("#files").on("click", ".del", function() {
				count--;
				//$(this).closest("div").remove();
				//$(this).parent().attr("title");
				//$(this).parents("div").attr("class");
				$(this).parents(".form-group").remove();				
		});
		

		$("#add").click(function() {
			if (count < 5) {
				$("#files").append(files);
				count++;
			} else {
				alert("파일추가는 최대 5개까지 가능합니다.")
			}
		});
		

	</script>
	

</body>
</html>