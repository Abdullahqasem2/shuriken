<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<c:if test="${logoutMessage != null}">
			<c:out value="${logoutMessage}"></c:out>
		</c:if>
		<h1>Login</h1>
		<c:if test="${errorMessage != null}">
			<c:out value="${errorMessage}"></c:out>
		</c:if>
		<form method="POST" action="/login">
			<p>
				<label class="col-sm-4 col-form-label" for="username">Username</label>
				<input class="form-control col-sm-6" type="text" id="username"
					name="username" />
			</p>
			<p>
				<label class="col-sm-4 col-form-label" for="password">Password</label>
				<input class="form-control col-sm-6" type="password" id="password"
					name="password" />
			</p>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /> <input class="btn btn-primary"
				type="submit" value="Login!" />
		</form>
	</div>
</body>
</html>