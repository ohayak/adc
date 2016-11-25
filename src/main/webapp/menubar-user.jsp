<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
        .main_menu {
            height:40px;
            line-height:40px;
            color:red;
            position:relative;
            font-family:Arial, sans-serif;
            font-size:15px;
        }
        .main_menu ul {
            padding:0px;
            margin:0;
            list-style:none;
        }
        .main_menu ul li {
            padding:0;
            margin:0;
            border-right:1px solid black;
            float:left;
            background:black;
        }
        .main_menu ul li a {
            color:white;
            display:block;
            text-decoration:none;
            padding:0 25px; }
        .main_menu ul li a:hover {
            background:lightblue;
            color:#000;
        }
        .main_menu ul li ul {
            display: none;
            width: auto;
            position:absolute;
            top:30px;
            padding:0px;
            margin:0px;
        }
        .main_menu ul li:hover ul {
            display: block;
            position: absolute;
            margin: 0;
            padding: 0;
        }
        .main_menu ul li:hover li {
            float: none;
            list-style:none;
            margin:0px;
        }
        .main_menu ul li:hover li {
            background:black;
            border-top:1px solid black;
        }
        .main_menu ul li:hover li a {
            color: #fff;
            padding:0 20px;
            display:block;
            width:170px;
        }
        .main_menu ul li li a:hover {
            color:#000;
        }
    </style>
</head>
<body>
<h3 align="center">Welcome <c:out value="${sessionScope.user.getNom()}"/> </h3>
<table width="100%" bgcolor="black" border="0">
    <tr><td>
        <div class="main_menu">
            <ul>
                <li> <a href="${pageContext.request.contextPath}/meteo">Meteo</a></li>
                <li> <a href="${pageContext.request.contextPath}/stats">Stats</a></li>
                <li> <a href="${pageContext.request.contextPath}/UserAccount.jsp" >My Account</a> </li>
                <li> <a href="${pageContext.request.contextPath}/Login.jsp">Logout</a></li>
            </ul>
        </div>
    </td></tr>
</table>
</body>
</html>