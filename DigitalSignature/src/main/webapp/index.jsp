<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <title>Digital Signature</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/Auth.css">
</head>
<body>
<h1>
</h1>
<br/>

<div class="container">
    <img alt="Group" class="login-image" src="static/media/loginIcon.png">
    <!--form class="form-signin" action="loginSuccess.jsp"  method="POST"-->
    <form action="LoginServlet" class="form-signin"  method="POST">
        <%--@declare id="password"--%><%--@declare id="email"--%>
        <h2 class="form-signin-heading">Login to your Digital Document Signing Account </h2>
        <label for="email" class="sr-only">Email address</label>
            <input type="email" name="email" class="form-control" placeholder="Email address" required autofocus>
        <label for="password" class="sr-only">Password</label>
            <input type="password" name="password" class="form-control" placeholder="Password" required>

            <p style="color:red; text-align: center">
            <c:if test="${message != null}">
                <c:out value='${message}' />
            </c:if>
            </p>
        <button class="btn btn-lg btn-primary btn-block" name="login-btn" type="submit">Sign in</button>
    </form>
    <div class="container text-center">
        <!-- Add new user button redirects to the register.jsp page -->
        <a href="<%=request.getContextPath()%>/register.jsp" class="btn btn-link">Do not have an account? Click here to register</a>
    </div>
</div>

</body>
</html>