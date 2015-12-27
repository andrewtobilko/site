<jsp:useBean id="user" scope="session" type="com.github.tobilko.entity.User"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User ${user.firstName} ${user.secondName}</title>
</head>
<body>
    <%@include file='templates/menu.jsp'%>

    First name: ${user.firstName} <br>
    Second name: ${user.secondName} <br>
    Display name: ${user.email} <br>
    Email: ${user.displayName} <br>
</body>
</html>
