<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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


			<!--show all the existing post---------- -->
			<div class="form-group">
				<label for="message" class="col-lg-2 control-label">Message</label>
				<div class="col-lg-10">
					<textarea class="form-control" rows="4" name="post"></textarea>
				</div>
			</div>
			<input type="text" name="userIdHidden" id="loggedInUserId"
				value="${user.userId}" hidden> <input type="text"
				name="userIdHidden" id="userId" value="${user.userId}" hidden>
			<input type="text" name="email" value="${user.email}" hidden>

			<div class="form-group">
				<div class="col-lg-10 col-lg-offset-2">
					<input id="submit" name="submit" type="submit" value="Post"
						class="btn btn-primary">
					<button type="button" onclick="displyMap('cityFrom','stateFrom')" class="btn btn-success">Departure Weather</button>
					<button type="button" onclick="displyMap('cityTo','stateTo')" class="btn btn-success">Destination Weather</button>
					
				</div>
			</div>
		</form>