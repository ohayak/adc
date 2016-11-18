<%--
  Created by IntelliJ IDEA.
  User: mrhyk
  Date: 17/11/2016
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<body>
<form action='/wildfly-project/adduser.action' method='post'>
    First name:<br>
    <input type='text' name='firstname' /><br>
    Last name:
    <input type='text' name='lastname' /><br>
    <input type='submit' value='Submit' />
</form>
</body>
</html>
