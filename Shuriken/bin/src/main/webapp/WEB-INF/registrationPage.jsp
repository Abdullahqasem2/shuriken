<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<h1>Register!</h1>

		<p>
			<form:errors path="user.*" />
		</p>

		<form:form method="POST" action="/registration" modelAttribute="user">
			<p>
				<form:label class="col-sm-4 col-form-label" path="username">Username:</form:label>
				<form:input class="form-control col-sm-6" path="username" />
			</p>
			<p>
				<form:label class="col-sm-4 col-form-label" path="password">Password:</form:label>
				<form:password class="form-control col-sm-6" path="password" />
			</p>
			<p>
				<form:label class="col-sm-4 col-form-label"
					path="passwordConfirmation">Password Confirmation:</form:label>
				<form:password class="form-control col-sm-6"
					path="passwordConfirmation" />
			</p>
			<input class="btn btn-primary" type="submit" value="Register!" />
		</form:form>
	</div>
</body>
</html>