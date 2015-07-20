<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Login</title>

<!-- style -->
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/bower_components/bootstrap/dist/css/bootstrap.min.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/css/common.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/css/login.css"/>">

<!-- script -->
<script src="http://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/bower_components/jquery/dist/jquery.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/bower_components/angular/angular.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/assets/app.js"/>"></script>
</head>
<body>
	<%
		response.setHeader("KakaoAK", "69bc3ed693c46ce0e216be14a763152a");
		String KakaoAK = request.getHeader("KakaoAK");
		String user_agent = request.getHeader("user-agent");
	%>
	<div class="container well">
		<form name="form" shake-that submitted="submitted" submit="submit()">
			<div class="form-group"
				ng-class="{'has-error': form.email.$invalid && submitted}">
				<label for="email" class="control-label">Email</label> <input
					type="email" class="form-control" id="email" name="email"
					placeholder="Email" ng-model="email"
					ng-model-options="{updateOn: 'blur'}" required>
			</div>
			<div class="form-group"
				ng-class="{'has-error': form.password.$invalid && submitted}">
				<label for="password" class="control-label">Password</label> <input
					type="password" class="form-control" id="password" name="password"
					placeholder="Password" ng-model="password"
					ng-model-options="{updateOn: 'blur'}" required>
			</div>
			<a id="kakao-login-btn-skyfly33-template"></a>
			<button type="submit" class="btn  btn-primary btn-block">Login</button>
			<button onclick="logout()" class="btn btn-danger btn-block">Logout</button>
		</form>
	</div>
	<div id="id01" class="container" style="display: none">dummy</div>

	<div class="container well">
		<form class="form-horizontal"
			action="https://kapi.kakao.com/v1/push/register" method="post"
			name="pushInfo">
			<fieldset>
				<legend>Push_Info</legend>
				<div class="form-group">
					<label for="uuid" class="col-lg-2 control-label">uuid</label>
					<div class="col-lg-10">
						<input type="text" class="form-control" id="uuid"
							placeholder="uuid" name="uuid">
					</div>
				</div>
				<div class="form-group">
					<label for="device_id" class="col-lg-2 control-label">DeviceId</label>
					<div class="col-lg-10">
						<input type="text" class="form-control" id="device_id"
							placeholder="device_id" name="device_id">
					</div>
					<div class="form-group">
						<label for="push_type" class="col-lg-2 control-label">PushType</label>
						<div class="col-lg-10">
							<select class="form-control" id="push_type" name="push_type">
								<option>gcm</option>
								<option>apns</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="push_token" class="col-lg-2 control-label">PushToken
						</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" id="push_token"
								placeholder="push_token" name="push_token">
						</div>
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
		<p><%=KakaoAK %></p>
		<p><%=user_agent %></p>
	</div>
	<script type="text/javascript" src="<c:url value="/resources/assets/js/kakaoLogin.js"/>"></script>
</body>
</html>