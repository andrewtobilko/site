<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Main</title>
    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-default">
    <ul class="nav navbar-nav">
        <li><a href="">Main</a></li>
        <li><a href="login">Log in</a></li>
        <li><a href="logout">Log out</a></li>
        <li><a href="signup">Sign up</a></li>
        <li><a href="profile">My profile</a></li>
        <li><a href="users">Users</a></li>
    </ul>
</nav>

    <c:choose>
        <c:when test="${sessionScope.get('user') != null}">
            <c:set var="user" value="${sessionScope.get('user')}"></c:set>
            <p>${user.firstName} ${user.secondName}</p>
        </c:when>
        <c:otherwise>
            No information about user.
        </c:otherwise>
    </c:choose>

</body>
</html>
