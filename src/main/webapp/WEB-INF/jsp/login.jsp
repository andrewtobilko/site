<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Log in</title>
    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../../resources/css/style.css">
</head>
<body>
<div class="row main">
    <div class="col-md-4 col-md-offset-4" id="container">
        <h1 class="whoareyou">
            <small>Who are you? Tell me about yourself.</small>
        </h1>
        <p id="userEmail"></p>
        <p id="userPassword"></p>
        <ul class="nav nav-tabs tabs" role="tablist">
            <li role="presentation" class="active">
                <a href="login" aria-controls="login" role="tab">Log in</a>
            </li>
            <li role="presentation">
                <a href="signup" aria-controls="signup" role="tab">Sing up</a>
            </li>
        </ul>
        <div class="tab-content">
            <div role="tabpanel" class="tab-pane fade in active" id="login">
                <div class="row">
                    <div class="col-md-8 col-md-offset-2">
                        <p class="text-center">
                               <a href="https://github.com" target="_blank"><i class="fa fa-github fa-2x pa"></i></a>
                            <a href="https://stackoverflow.com" target="_blank"><i class="fa fa-stack-overflow fa-2x pa"></i></a>
                            <a href="https://linkedin.com" target="_blank"><i class="fa fa-linkedin fa-2x pa"></i></a>
                            <a href="https://gmail.com" target="_blank"><i class="fa fa-google fa-2x pa"></i></a>
                            <a href="https://facebook.com" target="_blank"><i class="fa fa-facebook fa-2x pa"></i></a>
                        </p>
                        <div class="or-container">
                            <hr class="or-hr">
                            <div id="or">or</div>
                        </div>
                        <form method="post" action="login">
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="email" class="form-control" id="email" name="email" placeholder="Email" onblur="validate()">
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" id="password" name="password" placeholder="Password" onblur="validate()">
                            </div>
                            <div class="checkbox">
                                <label><input type="checkbox" name="flag">Remember me</label>
                            </div>
                            <button type="submit" class="btn btn-default">Log in</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
