<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Push</title>

<!-- style -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/bower_components/bootstrap/dist/css/bootstrap.min.css"/>">
<!-- script -->
<script type="text/javascript"
	src="<c:url value="/resources/bower_components/jquery/dist/jquery.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/bower_components/angular/angular.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/assets/js/tokenRegister.js"/>"></script>
</head>
<body>
	<%
		String AccessToken = request.getParameter("AccessToken");
		String AdminKey = request.getParameter("AdminKey");
		String uuid = request.getParameter("uuid");
		String PushType = request.getParameter("PushType");
		String PushToken = request.getParameter("PushToken");
		String DeviceId = request.getParameter("DeviceId");
	%>

	<div class="container">
		<p>
			<a href="/MobilePush">Home</a>
		</p>
		<p>
			<strong>AccessToken : </strong><%=AccessToken%></p>
		<p>
			<strong>AdminKey : </strong><%=AdminKey%></p>
		<p>
			<strong>uuid : </strong><%=uuid%></p>
		<p>
			<strong>PushType : </strong><%=PushType%></p>
		<p>
			<strong>PushToken : </strong><%=PushToken%></p>
		<p>
			<strong>DeviceId : </strong><%=DeviceId%></p>
	</div>
	<div class="container well">
		<form class="form-horizontal" action="https://kapi.kakao.com/v1/push/register" method="post"
			name="pushInfo">
			<fieldset>
				<legend>Push_Info</legend>
				<div class="form-group">
					<label for="AccessToken" class="col-lg-2 control-label">AccessToken
					</label>
					<div class="col-lg-10">
						<input type="text" class="form-control" id="AccessToken"
							placeholder="AccessToken" name="AccessToken"
							value="<%=AccessToken%>">
					</div>
				</div>
				<div class="form-group">
					<label for="AdminKey" class="col-lg-2 control-label">AdminKey</label>
					<div class="col-lg-10">
						<input type="password" class="form-control" id="AdminKey"
							placeholder="AdminKey" name="AdminKey" value="<%=AdminKey%>">
					</div>
				</div>
				<div class="form-group">
					<label for="uuid" class="col-lg-2 control-label">uuid</label>
					<div class="col-lg-10">
						<input type="text" class="form-control" id="uuid"
							placeholder="uuid" name="uuid" value="<%=uuid%>">
					</div>
				</div>
				<div class="form-group">
					<label for="PushType" class="col-lg-2 control-label">PushType</label>
					<div class="col-lg-10">
						<input type="text" class="form-control" id="PushType"
							placeholder="PushType" name="PushType" value="<%=PushType%>">
					</div>
				</div>
				<div class="form-group">
					<label for="PushToken" class="col-lg-2 control-label">PushToken
					</label>
					<div class="col-lg-10">
						<input type="text" class="form-control" id="PushToken"
							placeholder="PushToken" name="PushToken" value="<%=PushToken%>">
					</div>
				</div>
				<div class="form-group">
					<label for="DeviceId" class="col-lg-2 control-label">DeviceId</label>
					<div class="col-lg-10">
						<input type="text" class="form-control" id="DeviceId"
							placeholder="DeviceId" name="DeviceId" value="<%=DeviceId%>">
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
</body>
</html>