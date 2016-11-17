<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<body>
<table>
    <tr>
        <th>Firstname</th>
        <th>Lastname</th>
    </tr>
    <c:forEach items="${usersDatabase}" var="user">
        <tr>
            <td><c:out value="${user.getPrenom()}"/></td>
            <td><c:out value="${user.getNom()}"/></td>
        </tr>
    </c:forEach>
</table>
<form action='adduser.view'>
    <input type='submit' value='new user'/>
</form>
</body>
</html>