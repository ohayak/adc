<%--
  Created by IntelliJ IDEA.
  User: mrhyk
  Date: 17/11/2016
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <title>My Account</title>
    <jsp:include page="menubar-user.jsp" />
</head>
<html>
<body>
<form action='${pageContext.request.contextPath}/admin/adduser' method='post'>
    First name:<br>
    <input type='text' name='firstname' value="${sessionScope.user.getNom()}" /><br>
    Last name:<br>
    <input type='text' name='lastname' value="${sessionScope.user.getPrenom()}" /><br>
    Login:<br>
    <input type='text' name='login' value="${sessionScope.user.getLogin()}" /><br>
    Password:<br>
    <input type='text' name='password' value="${sessionScope.user.getPassword()}" /><br>
    <input type='submit' value='Modify' />
</form>
</body>
</html>
