<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../../resources/css/style.css">
</head>
<body>
<c:forEach var="user" items="${users}">
    <div class="user">
        ${user.firstName}
        <c:choose>
            <c:when test="${user.firstName = ''}">
                yes
            </c:when>
            <c:otherwise>
                no
            </c:otherwise>
        </c:choose>
    </div>
</c:forEach>
</body>
</html>
