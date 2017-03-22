<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<header class="main-header">
		<nav class="navbar navbar-inverse">
		<div class="navbar-header">
			<a href="/" class="navbar-brand"> Car Pool </a>
      <a href="#" onclick="displayWeatherMapWindow('')" class="navbar-brand"> Weather Search </a>

		</div>
		<ul class="nav navbar-nav">
			<li><a href="/" class="navbar-brand"> 	 </a></li>
			
		</ul>
		
		<ul class="nav navbar-nav navbar-right">

			<li><a  href="<%=request.getContextPath()%>/updateProfile?id=1" class="navbar-brand"><span class="glyphicon glyphicon-user"></span>${user.fullname}</a></li>
			 <li><a href="profile"  id="messageButton">Messages <span id="messageNumer" class="badge">0</span></a></li>
			<li><a href="<%=request.getContextPath()%>/logout"
				class="navbar-brand"> <span class="glyphicon glyphicon-off"></span> Logout </a></li>
		</ul>
		</nav>
</header>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
function GetNotification() {
	console.log("call setInterval");
	$.ajax({
		"url": "notification",
		"type": "GET",
		"success": function(data){
			console.log(data);
	        $("#messageNumer").text(data);
	        window.setTimeout(GetNotification,2000);
	    },
		"error": function(xhr, status, exception) {
			console.log(xhr, status, exception);
		}
	});
}
$(document).ready(function() {
		window.setTimeout(GetNotification,2000);
	 	
});
	 	
</script>

