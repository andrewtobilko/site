<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Log out</title>
    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../resources/css/style.css">
</head>
<body>
    <%@include file='templates/menu.jsp'%>
    <div class="row logout">
        <div class="col-md-4 col-md-offset-4">
            <h1>
                <small>Clicking "Log out" will log you out of this site</small>
            </h1>
            <form action="logout" method="POST">
                <input type="hidden" name="command" value="logout">
                <button type="submit" class="btn btn-default">Log out</button>
            </form>
        </div>
    </div>
</body>
</html>
