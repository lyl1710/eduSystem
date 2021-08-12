<%-- 
    Document   : Error
    Created on : Jun 20, 2021, 5:52:19 PM
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
            <div class="loginMid">
                <div class="loginTitle">
                    <h2>Member Login</h2>
                    <h4>Using your username and password.</h4>
                </div>
                <div style="color: red;margin-left: 160px; margin-bottom: 20px;">${message}</div>
                    
                <div class="input">
                    <form action="login" method="POST">
                        <div class="username" >Username <input  type="text" name="username" value="${userName}" maxlength="20" required="" pattern="(?=.*[a-zA-Z0-9])[a-zA-Z0-9\s]+"><p>(*)</p></div>
                        <div class="password" >Password <input type="password" name="password" maxlength="20" required="" pattern="(?=.*[a-zA-Z0-9])[a-zA-Z0-9\s]+"><p>(*)</p></div>
                        <div class="submit"><input  style="padding: 5px 15px;" type="submit" value="Log in"></div>
                        <div class="noticing">The field <p> (*) </p>is required </div>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"/>

    </body>
</html>
