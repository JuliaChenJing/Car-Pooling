<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign Up Form</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/flatly/bootstrap.min.css" />

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Register Form</h3>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" action="SignUp" method="post">
							<fieldset>
								<div class="form-group">
								
									<label class="col-lg-2 control-label">Full
										Name</label>
									<div class="col-lg-10">
										<input type="text" name="fullname" class="form-control"
											placeholder="Enter Full name" pattern="^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$" 
											 title=" username is 8-20 characters long ">
									</div>
								</div>
								<div class="form-group">
								
									<label class="col-lg-2 control-label">Email</label>
									<div class="col-lg-10">
										<input type="text" name="email" class="form-control"
											placeholder="Enter your Email" pattern="^[a-zA-Z_\-]+@(([a-zA-Z_\-])+\.)+[a-zA-Z]{2,4}$" 
											 title=" email address ">
									</div>
								</div>
								<div class="form-group">
									<label for="inputPassword" class="col-lg-2 control-label">Password</label>
									<div class="col-lg-10">
										<input type="password" name="password" class="form-control"
											placeholder="Password">
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 control-label">Gender</label>
									<div class="col-lg-10">
										<div class="radio">
											<label> <input type="radio" name="gender" value="1"
												checked> Male
											</label> <label> <input type="radio" name="gender" value="2">
												FeMale
											</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label for="select" class="col-lg-2 control-label">State</label>
									<div class="col-lg-10">
										<select class="form-control" id="select" name="state">
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
								</div>
								
								<div class="form-group">
									<label class="col-lg-2 control-label">ZipCode</label>
									<div class="col-lg-10">
										<input type="text" class="form-control" name="zipcode"
											placeholder="Enter Zip Code" pattern="[0-9]{5}" 
											 title=" 5 digit zip code ">
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-lg-2 control-label">Street</label>
									<div class="col-lg-10">
										<input type="text" class="form-control" name="street"
											placeholder="Enter Street Address">
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 control-label">City</label>
									<div class="col-lg-10">
										<input type="text" class="form-control" name="city"
											placeholder="Enter your city"pattern="^([A-Z]{3,200})$" 
											 title=" city name formed by letters">
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 control-label">Birth-Year</label>
									<div class="col-lg-10">
										<input type="text" class="form-control" name="birthyear"
											placeholder="Enter birth Year (YYYY)" pattern="((?:19|20)\d{2})‌​$"
											 title=" birth year should be 4 digits and after 1900">
									</div>
								</div>
								
								<div class="form-group">
									<div class="col-lg-10 col-lg-offset-2">
										<button type="reset" class="btn btn-default">Cancel</button>
										<button type="submit" class="btn btn-primary">Submit</button>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>