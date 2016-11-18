<%--
  Created by IntelliJ IDEA.
  User: mrhyk
  Date: 17/11/2016
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action='/wildfly-project/meteo.action' method='post'>
    Ville:<br>
    <input type='text' name='ville' />
    <br>
    <input type='submit' value='Submit' />
</form>

<br>
<table>
    <tr>
    	<td>City: <c:out value="${city}"/></td>
    	<td>Temperature: <c:out value="${temperature}"/></td>
    </tr>
</table>


</body>
</html>


