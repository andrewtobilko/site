<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Andrew Tobilko :: Personal web site</title>
    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../resources/css/style.css">

    <script src="../../resources/js/jquery-1.11.3.min.js"></script>
    <script src="../../resources/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Tobilko</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="login">Log in</a></li>
                <li><a href="logout">Log out</a></li>
                <li><a href="signup">Sign up</a></li>
                <li><a href="profile">My profile</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="profile">{profile image} ${user.firstName} ${user.secondName}</a></li>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>
