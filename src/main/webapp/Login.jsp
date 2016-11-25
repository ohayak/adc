<%--
  Created by IntelliJ IDEA.
  User: mrhyk
  Date: 21/11/2016
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>login</title>
<body>
<form action='${pageContext.request.contextPath}/login' method='post'>
    <center>
        <table border=0>
            <tr><td colspan=2>
                <p align=center>
                    welcome!<br>
                    please enter your account name andpassword to log in.<br>
            </td></tr>

            <tr><td>
                <p align=right><b>account:</b>
            </td>
                <td>
                    <p><input type=text name="account" value="" size=15>
                </td></tr>

            <tr><td>
                <p align=right><b>password:</b>
            </td>
                <td>
                    <p><input type=password name="password" value="" size=15>
                </td></tr>

            <tr><td colspan=2>
                <center>
                    <input type=submit value="ok">
                </center>
            </td></tr>
        </table>
</form>
</body>
</html>