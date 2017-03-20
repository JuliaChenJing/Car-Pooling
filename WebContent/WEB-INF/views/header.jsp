<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<header class="main-header">
		<nav class="navbar navbar-inverse">
		<div class="navbar-header">
			<a href="/" class="navbar-brand"> Car Pool </a>


		</div>
		<ul class="nav navbar-nav">
			<li><a href="/" class="navbar-brand"> 	 </a></li>
			
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a class="navbar-brand"><span class="glyphicon glyphicon-user"></span>${user.fullname}</a></li>
			<li><a href="<%=request.getContextPath()%>/logout"
				class="navbar-brand"> <span class="glyphicon glyphicon-off"></span> Logout </a></li>
		</ul>
		</nav>
</header>
