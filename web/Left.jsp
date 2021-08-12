<%-- 
    Document   : Error
    Created on : Jun 21, 2021, 8:53:11 PM
    Author     : LongPHHE141469
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/Left.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <c:if test="${username == null}">
            <div class="a"><a href="login"><button style="padding: 10px;">Login</button></a></div>
        </c:if>
        <c:if test="${username != null}">
            <div class="a"><a href="logout"><button style="padding: 10px;">Welcome ${username},<br>Log out</button></a></div>
        </c:if>
        <div class="a"><a href="home"><button style="padding: 10px;">Home</button></a></div>
        <div class="a"><a href="view"><button style="padding: 10px;">View requests</button></a></div>
        <div class="a"><a href="solve"><button style="padding: 10px;">Solve requests</button></a></div>
        <div class="date"><a href=""><button style="padding: 10px;"><b>Today is: ${dateTime}</b></button></a></div>

    </body>
</html>
