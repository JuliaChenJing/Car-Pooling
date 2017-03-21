<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Profile</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/flatly/bootstrap.min.css" />
<style>
.btn-circle-like {
	width: 50px;
	height: 50px;
	text-align: center;
	padding: 13px 0;
	font-size: 20px;
	line-height: 2.00;
	border-radius: 45px;
}

.media-body>.well {
	margin-left: 206px;
}

b {
	font-weight: 700;
	font-size: 20px;
}
</style>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="container">
		<form class="form-horizontal" role="form" method="post" action="post">

			<div class="form-group">
				<label class="col-lg-2 control-label">Post Type</label>
				<div class="col-lg-10">
					<div class="radio">
						<label> <input type="radio" name="postType" value="1"
							checked> Offer Ride
						</label> <label> <input type="radio" name="postType" value="2">
							Ask Ride
						</label>
					</div>
				</div>
			</div>

			<div class="form-group">
				<label for="select" class="col-lg-2 control-label">From</label>
				<div class="col-lg-2">
					<select class="form-control" id="select" name="stateFrom">
						<option value="AL">Alabama</option>
						<option value="AK">Alaska</option>
						<option value="AZ">Arizona</option>
						<option value="AR">Arkansas</option>
						<option value="CA">California</option>
						<option value="CO">Colorado</option>
						<option value="CT">Connecticut</option>
						<option value="DE">Delaware</option>
						<option value="DC">District of Columbia</option>
						<option value="FL">Florida</option>
						<option value="GA">Georgia</option>
						<option value="HI">Hawaii</option>
						<option value="ID">Idaho</option>
						<option value="IL">Illinois</option>
						<option value="IN">Indiana</option>
						<option value="IA" selected>Iowa</option>
						<option value="KS">Kansas</option>
						<option value="KY">Kentucky</option>
						<option value="LA">Louisiana</option>
						<option value="ME">Maine</option>
						<option value="MD">Maryland</option>
						<option value="MA">Massachusetts</option>
						<option value="MI">Michigan</option>
						<option value="MN">Minnesota</option>
						<option value="MS">Mississippi</option>
						<option value="MO">Missouri</option>
						<option value="MT">Montana</option>
						<option value="NE">Nebraska</option>
						<option value="NV">Nevada</option>
						<option value="NH">New Hampshire</option>
						<option value="NJ">New Jersey</option>
						<option value="NM">New Mexico</option>
						<option value="NY">New York</option>
						<option value="NC">North Carolina</option>
						<option value="ND">North Dakota</option>
						<option value="OH">Ohio</option>
						<option value="OK">Oklahoma</option>
						<option value="OR">Oregon</option>
						<option value="PA">Pennsylvania</option>
						<option value="RI">Rhode Island</option>
						<option value="SC">South Carolina</option>
						<option value="SD">South Dakota</option>
						<option value="TN">Tennessee</option>
						<option value="TX">Texas</option>
						<option value="UT">Utah</option>
						<option value="VT">Vermont</option>
						<option value="VA">Virginia</option>
						<option value="WA">Washington</option>
						<option value="WV">West Virginia</option>
						<option value="WI">Wisconsin</option>
						<option value="WY">Wyoming</option>
					</select>
				</div>

				<div class="col-lg-2">
					<input type="text" class="form-control" name="cityFrom"
						placeholder="Enter city From">
				</div>


				<label for="select" class="col-lg-2 control-label">To</label>
				<div class="col-lg-2">
					<select class="form-control" id="select" name="stateTo">
						<option value="AL">Alabama</option>
						<option value="AK">Alaska</option>
						<option value="AZ">Arizona</option>
						<option value="AR">Arkansas</option>
						<option value="CA">California</option>
						<option value="CO">Colorado</option>
						<option value="CT">Connecticut</option>
						<option value="DE">Delaware</option>
						<option value="DC">District of Columbia</option>
						<option value="FL">Florida</option>
						<option value="GA">Georgia</option>
						<option value="HI">Hawaii</option>
						<option value="ID">Idaho</option>
						<option value="IL">Illinois</option>
						<option value="IN">Indiana</option>
						<option value="IA" selected>Iowa</option>
						<option value="KS">Kansas</option>
						<option value="KY">Kentucky</option>
						<option value="LA">Louisiana</option>
						<option value="ME">Maine</option>
						<option value="MD">Maryland</option>
						<option value="MA">Massachusetts</option>
						<option value="MI">Michigan</option>
						<option value="MN">Minnesota</option>
						<option value="MS">Mississippi</option>
						<option value="MO">Missouri</option>
						<option value="MT">Montana</option>
						<option value="NE">Nebraska</option>
						<option value="NV">Nevada</option>
						<option value="NH">New Hampshire</option>
						<option value="NJ">New Jersey</option>
						<option value="NM">New Mexico</option>
						<option value="NY">New York</option>
						<option value="NC">North Carolina</option>
						<option value="ND">North Dakota</option>
						<option value="OH">Ohio</option>
						<option value="OK">Oklahoma</option>
						<option value="OR">Oregon</option>
						<option value="PA">Pennsylvania</option>
						<option value="RI">Rhode Island</option>
						<option value="SC">South Carolina</option>
						<option value="SD">South Dakota</option>
						<option value="TN">Tennessee</option>
						<option value="TX">Texas</option>
						<option value="UT">Utah</option>
						<option value="VT">Vermont</option>
						<option value="VA">Virginia</option>
						<option value="WA">Washington</option>
						<option value="WV">West Virginia</option>
						<option value="WI">Wisconsin</option>
						<option value="WY">Wyoming</option>
					</select>
				</div>
				<div class="col-lg-2">
					<input type="text" class="form-control" name="cityTo"
						placeholder="Enter city To">
				</div>

			</div>


			<!-- update new messages here: POST----------- -->
			<div class="form-group">
				<label for="message" class="col-lg-2 control-label">Message</label>
				<div class="col-lg-10">
					<textarea class="form-control" rows="4" name="post"></textarea>
				</div>
			</div>
			<input type="text" name="userIdHidden" id="loggedInUserId"
				value="${user.userId}" hidden>

			<input type="text" name="userIdHidden" id="userId"
				value="${user.userId}" hidden> <input type="text"
				name="email" value="${user.email}" hidden>

			<div class="form-group">
				<div class="col-lg-10 col-lg-offset-2">
					<input id="submit" name="submit" type="submit" value="Post"
						class="btn btn-primary">
				</div>
			</div>
		</form>


		<!-- Posted things visible here----------- -->

		<c:forEach var="post" items="${postList}">

			<div class="row">
				<div class="media-body">
					<div class="well well-lg">
						<h4 class="media-heading text-uppercase reviews">${post.username}</h4>
						<ul class="media-date text-uppercase reviews list-inline">
							<li class="dd">${post.dateUpdated}</li>
							<br />
							<li class="dd">${post.cityFrom}<a>to</a> ${post.cityTo}
							</li>
						</ul>
						<input type="text" id="postId${post.postId}" value="${post.postId}" hidden>
						<input type="text" id="userIdInPost${post.userId}" value="${post.userId}" hidden>
						
						<p class="media-comment">${post.post}</p>
						<!-- LIKE----------- -->
						<p>
							<i class="likeButton${post.postId}"><a class="btn btn-default btn-circle-like">
								<span class="glyphicon glyphicon-thumbs-up"> </span>
							</a></i>
							<!--REPLY----------- -->
							<a class="btn btn-success btn-circle text-uppercase" href="#">
								<span class="glyphicon glyphicon-share-alt"></span>Reply
							</a>

							<!-- COMMENTS----------- -->
							<a class="btn btn-warning btn-circle text-uppercase"
								data-toggle="collapse" href="#replyOne"> <span
								class="glyphicon glyphicon-comment"></span> 2 comments
							</a>
						</p>

						<p id="ajaxSuccessReturn${post.postId}"></p>
					</div>

				</div>
			</div>
			<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			
			$(".likeButton${post.postId}").click(function() {
				let postId = $('#postId${post.postId}').attr('value');
				let userId = $('#userIdInPost${post.userId}').attr('value');
				let loggedInUserId = $('#loggedInUserId').attr('value');
				console.log(userId);
				console.log(postId);
				console.log(loggedInUserId);
				$.ajax({
					url : "like",
					type : "POST",
					data : {
						'userId' : userId,
						'postId' : postId,
						'loggedInUserId': loggedInUserId
					},
					success : ajaxSuccess,
					error : ajaxFailure
				});
			});

			function ajaxSuccess(responseText) {
				console.log('ajax success');
				$("#ajaxSuccessReturn${post.postId}").text(responseText);
			}

			function ajaxFailure(xhr, status, exception) {
				console.log(xhr, status, exception);
			}
		});
	</script>
			
		</c:forEach>

	</div>
	<%@include file="footer.jsp"%>
</body>
</html>