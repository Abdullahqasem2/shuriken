<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Shuriken</title>
<meta charset="UTF-8">
<meta name="description" content="EndGam Gaming Magazine Template">
<meta name="keywords" content="endGam,gGaming, magazine, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Favicon -->
<link href="img/favicon.ico" rel="shortcut icon" />

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:400,400i,500,500i,700,700i,900,900i"
	rel="stylesheet">


<!-- Stylesheets -->
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/font-awesome.min.css" />
<link rel="stylesheet" href="css/slicknav.min.css" />
<link rel="stylesheet" href="css/owl.carousel.min.css" />
<link rel="stylesheet" href="css/magnific-popup.css" />
<link rel="stylesheet" href="css/animate.css" />

<!-- Main Stylesheets -->
<link rel="stylesheet" href="css/style.css" />


<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->

</head>
<body>

<form action="/profile" method="get">
<input type="submit" value="${user.username} Profile"/>
</form>
<form action="/News" method="get">
<input type="submit" value="News"/>
</form>
<form action="/community" method="get">
<input type="submit" value="Community"/>
</form>
<form action="/messages" method="get">
<input type="submit" value="General Chat"/>
</form>
<ul>
<c:forEach items="${friends}" var="userFriend">
<c:choose>
<c:when test = "${userFriend.request == false }">
<li><a href="/acceptFriend/${userFriend.friend.id}"> Accept Friend Request</a> ${userFriend.friend.username}</li>
</c:when>
</c:choose>
</c:forEach>
</ul>
<img alt="Avatar" src="${user.photos}">
<form action="/avatar" method="get">
<input type="submit" value="Choose You Avatar"/>
</form>
<h3>${user.username}</h3>

<ul>
<c:forEach items="${friends}" var="userFriend">
<c:choose>
<c:when test = "${userFriend.request == true}">
<li>${userFriend.friend.username}</li>
</c:when>
</c:choose>
</c:forEach>
</ul>
<hr/>
<ul>
<c:forEach items="${users}" var="userf">
<c:choose>
<c:when test="${userf.equals(user)}">

</c:when>
<c:when test = "${!(user.userFriends).contains(userf) &&  !(user.friends).contains(userf) }">
<li>${userf.username}<a href="/addFriend/${userf.id}"> Add friend </a></li>
</c:when>
</c:choose>
</c:forEach>
</ul>

<c:forEach items="${games}" var="game">
<c:choose>
<c:when test = "${(game.users).contains(user)}">
<a href="/${game.gameURL}"><img src="${game.id}" alt="game"></a>
</c:when>

<c:when test = "${!(game.users).contains(user)}">
<a href="/${game.gameURL}"><img src="${game.id}" alt="game"></a>
</c:when>
</c:choose>
</c:forEach>

	<!--====== Javascripts & Jquery ======-->
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.slicknav.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.sticky-sidebar.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/main2.js"></script>

</body>
</html>