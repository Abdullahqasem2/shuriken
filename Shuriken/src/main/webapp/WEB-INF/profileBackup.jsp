<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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

</body>
</html>