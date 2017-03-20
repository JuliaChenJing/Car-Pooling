<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Profile</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/flatly/bootstrap.min.css" />

</head>
<body>

	

		<nav class="navbar navbar-inverse">
		<div class="navbar-header">
			<a href="/" class="navbar-brand"> Car Pool </a>


		</div>
		<ul class="nav navbar-nav">
			<li><a href="/" class="navbar-brand"> Home </a></li>
			<li><a href="/about.jsp" class="navbar-brand"> About </a></li>
			<li><a href="/contact.jsp" class="navbar-brand"> Contact </a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a class="navbar-brand">${username}</a></li>
			<li><a href="<%=request.getContextPath()%>/logout"
				class="navbar-brand"> Logout </a></li>
		</ul>
		</nav>
<div class="container">

		<div class="col-sm-12">
			<div class="col-sm-4">
				<div class="jumbotron">Profile pic ....</div>
			</div>
			<div class="col-sm-8">
				<div class="jumbotron">
					
					<h3>FullName: ${user.fullname}</h3>
					<h3>${user.street }</h3>

					Description .....

				</div>
			</div>
		</div>
	</div>

</body>
</html>