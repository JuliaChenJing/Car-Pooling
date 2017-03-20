<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/flatly/bootstrap.min.css" />
<style>
.container>.row {
	margin-top: 15%;
}

#link-signup {
	text-align: center;
	font-size: 24px;
	margin-left: 35%;
}
</style>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please sign in</h3>

					</div>
					<div class="panel-body">
						<form action="login" method="post" class="form-horizontal">
							<c:if test="${error}">
								<div class="alert alert-danger" id="errorBody">
									<p>Invalid username and password</p>
								</div>
							</c:if>
							<c:if test="${logout}">
								<div class="alert alert-success">
									<p>You have been logged out successfully</p>
								</div>
							</c:if>

							<div class="input-group input-sm">
								<label class="input-group-addon"> <i class="fa fa-user"></i></label>
								<input type="text" class="form-control" name="email"
									placeholder="Enter Email" required>
							</div>
							<div class="input-group input-sm">
								<label class="input-group-addon"> <i class="fa fa-lock"></i></label>
								<input type="password" class="form-control" name="password"
									placeholder="Enter password" required>
							</div>
							<div class="form-actions">
								<input type="submit"
									class="btn btn-block btn-primary btn-default" value="Log In">
							</div>
						</form>

					</div>
				</div>
				<span id="link-signup"> <a href="SignUp">Create
						account</a>
				</span>
			</div>

		</div>

	</div>
	<script src="//code.jquery.com/jquery-1.12.4.js"></script>
	<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
		$(document).ready(function() {
			$("#errorBody").effect("shake");
		});
	</script>

</body>
</html>