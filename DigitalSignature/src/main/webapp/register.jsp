<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <title>Digital Signature Registration</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/Auth.css">
</head>
<body>
<h1></h1>
<br/>

<div class="container">
    <img alt="Group" class="login-image" src="static/media/registerIcon.png">
    <form action="RegisterServlet" class="form-signin"  method="POST">
        <%--@declare id="password"--%><%--@declare id="email"--%><%--@declare id="name"--%>
        <%--@declare id="cfmpassword"--%><h2 class="form-signin-heading">Enter your details to register for your Digital Document Signing Account</h2>
            <label for="name" class="sr-only">Name</label>
            <input type="text" name="name" class="form-control" placeholder="Name" required autofocus>
            <label for="email" class="sr-only">Email address</label>
            <input type="email" name="email" class="form-control" placeholder="Email address" required autofocus>
            <label for="password" class="sr-only">Password</label>
            <input type="password" name="password" class="form-control" placeholder="Password" required>
            <label for="cfmpassword" class="sr-only">Confirm Password</label>
            <input type="password" name="cfmpassword" class="form-control" placeholder="Confirm Password" required>
        <p style="color:red; text-align: center">
            <c:if test="${message != null}">
                <c:out value='${message}' />
            </c:if>
        </p>
        <button class="btn btn-lg btn-success btn-block" type="submit">Confirm Registration</button>
    </form>
</div>
</body>
</html>
