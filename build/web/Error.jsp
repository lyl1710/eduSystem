<%-- 
    Document   : Error
    Created on : Jun 20, 2021, 7:50:10 PM
    Author     : LongPHHE141469
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/Login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="Header.jsp"/>
        <div class="login">
            <div class="left">
                <jsp:include page="Left.jsp"/>
            </div>
            <div class="homeMid">
                <div style="margin-left: 20px; color: red;"><h2> Error Found: </h2></div>
                <div class="homeTilte"><h2>${message}</h2> </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"/>
    </body>
</html>
