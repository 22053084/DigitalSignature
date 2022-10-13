<%@ page import="com.digitalsignature.login.Login" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <title>Welcome to Digital Signature - Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/Auth.css">
</head>
<body>
    <h1></h1>
    <br/>

    <div >
        <div class="landing-home-page-upper-layer ">
            <div class="MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-3">
                <div class="MuiGrid-root card shadow MuiGrid-item MuiGrid-grid-xs-12">
                    <div class="MuiPaper-root jss38 MuiPaper-elevation1 MuiPaper-rounded">
                        <div class="row">
                            <span class="page-heading ">Hi,
                                    <c:if test="${dslogin != null}">
                                        <c:forEach var="login" items="${dslogin}">
                                            <c:out value="${login.loginName}" />
                                        </c:forEach>
                                    </c:if>
                            </span>
                        </div>
                        <div class="row" style="padding-left: 35px">
                            <div class="column" style="width: 45%">
                                <span>
                                    Together we protect and preserve the world's forests.<br>
                                </span>
                                <div class="MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12" >
                                    <div class="row" style="padding-left: 10px">
                                        <div class="column" style="width: 48%"><br>
                                            <button class="btn btn-lg btn-primary btn-block" tabindex="0" type="button">
                                                <span class="MuiButton-label">Create Project</span>
                                                <span class="MuiTouchRipple-root"></span>
                                            </button>
                                        </div>
                                        <div class="column" style="width: 4%">
                                            &nbsp;
                                        </div>
                                        <div class="column" style="width: 48%"><br>
                                            <button class="btn btn-lg btn-primary btn-block" tabindex="1" type="button">
                                                <span class="MuiButton-label">Verify Document</span>
                                                <span class="MuiTouchRipple-root"></span>
                                            </button>
                                        </div>
                                    </div>
                                    <div class="row">

                                    </div>
                                </div>
                            </div>
                            <div class="column" style="width: 55%">
                                <div class="MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12" >
                                    <img src="${pageContext.request.contextPath}/static/media/welcomeIcon.png" style="width: 90%">
                                </div>
                            </div>
                        </div>
                        <div class="row" style="padding-left: 35px">
                            <div class="column" style="width: 100%">
                                <div class="MuiGrid-root page-sub-heading2 MuiGrid-item MuiGrid-grid-xs-12" style="padding: 10px; font-size: large; font-weight: bold">
                                    <br>Most Recent Documents<br>
                                    <table class="table" style="padding: 2px; font-size: small; font-weight: lighter">
                                        <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Project Name</th>
                                            <th>Creation Date</th>
                                            <th>Completion Date</th>
                                            <th>Status</th>
                                            <th>Actions</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="userProject" items="${userProjects}" varStatus="loop">
                                        <c:if test="${loop.index<5}">
                                        <tr>
                                            <td>
                                                <c:out value="${userProject.projectID}" />
                                            </td>
                                            <td>
                                                <c:out value="${userProject.projectName}" />
                                            </td>
                                            <td>
                                                <c:out value="${userProject.creationDate}" />
                                            </td>
                                            <td>
                                                <c:out value="${userProject.completionDate}" />
                                            </td>
                                            <td>
                                                <c:out value="${userProject.status}" />
                                            </td>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/ProjectServlet/edit?name=<c:out value='${userProject.projectID}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
                                                <a href="delete?name=<c:out value='${userProject.projectID}' />">Delete</a>
                                            </td>
                                        </tr>
                                        </c:if>
                                            <c:set var="documentCount" scope="session" value="${loop.count}"/>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <table>
                                        <tr>
                                            <td>You have created a total of <c:out value="${documentCount} documents" /><br></td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>
                </div>
            </div>
        </div>
    </div>
    </div>
    <p style="color:dimgray; text-align: center; font-size: xx-small">
        <c:if test="${dssession != null}">
            <!--<c:out value='${dssession}' />-->
        </c:if>
    </p>
</body>
</html>
