<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<head>
    <jsp:include page="menubar-admin.jsp"/>
</head>
<html>
<body>
<table>
    <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Login</th>
        <th>Password</th>
    </tr>
    <c:forEach items="${usersDatabase}" var="user">
        <tr>
            <td><c:out value="${user.getPrenom()}"/></td>
            <td><c:out value="${user.getNom()}"/></td>
            <td><c:out value="${user.getLogin()}"/></td>
            <td><c:out value="${user.getPassword()}"/></td>
        </tr>
    </c:forEach>
</table>
<form action='${pageContext.request.contextPath}/admin/adduser' method='get'>
    <input type='submit' value='new user'/>
</form>
</body>
</html>