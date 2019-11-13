<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/">SPRING4</a>
		</div>

		<ul class="nav navbar-nav">
			<li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>

			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">NOTICE<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a
						href="${pageContext.request.contextPath}/notice/noticeList">List</a></li>
					<li><a
						href="${pageContext.request.contextPath}/notice/noticeWrite">Write</a></li>
				</ul></li>

			<li><a href="${pageContext.request.contextPath}/qna/qnaList">QNA</a></li>
		</ul>

		<ul class="nav navbar-nav navbar-right">


			<li>
			<a href="${pageContext.request.contextPath}/member/MemberMypage.jsp">
			<span class="glyphicon glyphicon-user"></span>My page
			</a>
			</li>
			
			<li><a
				href="${pageContext.request.contextPath}/member/MemberLogout.jsp"><span
					class="glyphicon glyphicon-log-out"></span> Logout </a></li>

			<li><a
				href="${pageContext.request.contextPath}/member/MemberJoinForm.jsp"><span
					class="glyphicon glyphicon-user"></span>Sign Up</a></li>
			<li><a
				href="${pageContext.request.contextPath}/member/MemberLoginForm.jsp"><span
					class="glyphicon glyphicon-log-in"></span>Login</a></li>


		</ul>
	</div>

</nav>



