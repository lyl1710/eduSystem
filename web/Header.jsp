<%-- 
    Document   : Error
    Created on : Jun 20, 2021, 7:53:19 PM
    Author     : LongPHHE141469
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/Header.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="header">
            <h1>FPT Education System</h1>
            <c:if test="${solve==true}">
                <h3>Student Control Panel</h3>
            </c:if>
            <c:if test="${!solve==true}">
                <h3>Teacher Control Panel</h3>
            </c:if>
        </div>
    </body>
</html>
