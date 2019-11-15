<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<nav class="navbar navbar-inverse">

	<div class="container-fluid">
	
		<div class="navbar-header">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/">SPRING4</a>
		</div>

		<ul class="nav navbar-nav">
			<li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
			
			<li class="dropdown">
			<a class="dropdown-toggle" data-toggle="dropdown" href="#">NOTICE<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="${pageContext.request.contextPath}/notice/noticeList">List</a></li>
					<li><a href="${pageContext.request.contextPath}/notice/noticeWrite">Write</a></li>
				</ul>
			</li>
			
			<li class="dropdown">
			<a class="dropdown-toggle" data-toggle="dropdown" href="#">QNA<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="${pageContext.request.contextPath}/qna/qnaList">List</a></li>
					<li><a href="${pageContext.request.contextPath}/qna/qnaWrite">Write</a></li>
				</ul>
			</li>
			
			<li class="dropdown">
			<a class="dropdown-toggle" data-toggle="dropdown" href="#">MEMBER<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="${pageContext.request.contextPath}/member/memberJoin">Join</a></li>
				</ul>
			</li>
		
		
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<li><a href="${pageContext.request.contextPath}/member/memberMypage">
			<span class="glyphicon glyphicon-user"></span>My page</a></li>
			
			<li><a href="${pageContext.request.contextPath}/member/memberLogout">
			<span class="glyphicon glyphicon-log-out"></span> Logout </a></li>

			<li><a href="${pageContext.request.contextPath}/member/memberJoin">
			<span class="glyphicon glyphicon-user"></span>Sign Up</a></li>
			
			<li><a href="${pageContext.request.contextPath}/member/memberLogin">
			<span class="glyphicon glyphicon-log-in"></span>Login</a></li>
		</ul>
	</div>

</nav>



