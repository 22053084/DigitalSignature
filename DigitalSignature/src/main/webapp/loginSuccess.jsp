<%@ page import="com.digitalsignature.login.Login" %>
<%@ page import="com.digitalsignature.login.LoginDAO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Digital Signature</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/Auth.css">
</head>
<body>
<h1>
</h1>
<br/>

<div class="container">
    <jsp:useBean id="login" class="com.digitalsignature.login.Login" />
    <jsp:setProperty property="*" name="login" />



</div> <!-- /container -->
</body>
</html>