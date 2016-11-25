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
    <title>Meteo</title>
    <jsp:include page="menubar-user.jsp" />
</head>
<body>
<form action='${pageContext.request.contextPath}/meteo' method='post'>
    Ville:
    <br>
    <input type='text' name='city' />
    <br>
    <input type='submit' value='Submit' />
</form>
<br>
City: <c:out value="${city}"/>
<br>
Temperature: <c:out value="${temperature}"/>


</body>
</html>


