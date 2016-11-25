<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<head>
    <c:if test="${sessionScope.user.getLogin() eq 'admin'}">
        <jsp:include page="menubar-admin.jsp"/>
    </c:if>
    <c:if test="${sessionScope.user.getLogin() ne 'admin'}">
        <jsp:include page="menubar-user.jsp"/>
    </c:if>
</head>
<html>
<body>
<table>
    <tr>
        <th>Users</th>
        <th>Visists</th>
    </tr>
    <c:forEach items="${applicationScope.visitRecorder}" var="visit">
        <tr>
            <td><c:out value="${visit.key}"/></td>
            <td><c:out value="${visit.value}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>