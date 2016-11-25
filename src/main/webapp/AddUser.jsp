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
    <jsp:include page="menubar-admin.jsp" />
</head>
<html>
<body>
<form action="${pageContext.request.contextPath}/admin/registeruser" method="get">
    First name:<br>
    <input type='text' name='firstname' /><br>
    Last name:<br>
    <input type='text' name='lastname' /><br>
    Login:<br>
    <input type='text' name='login' /><br>
    Password:<br>
    <input type='text' name='password' /><br>
    <input type='submit' value='Submit' />
</form>
</body>
</html>
