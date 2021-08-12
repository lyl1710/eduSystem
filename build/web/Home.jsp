<%-- 
    Document   : Error
    Created on : Jun 20, 2021, 7:53:20 PM
    Author     : LongPHHE141469
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <div class="homeTilte"><h2>Request received by today: ${date}</h2> </div>
                <table>
                    <tr>
                        <th>Department name</th>
                        <th>Number of request</th>
                        <th>View detail</th>
                    </tr>
                    <c:forEach items="${departments}" var="d">
                        <tr>
                            <td><div class="departementName">${d.name}</div></td>
                            <td>${d.requests.size()}</td>
                            <td> <a class="view" href="view?departmentId=${d.id}">View</a></td>
                        </tr>
                    </c:forEach>
                </table>
                <br>
                <br>
                <div class="homeTilte"><h2>Request received by last 2 days</h2> </div>
                <table>
                    <tr>
                        <th>Department name</th>
                        <th>Number of request</th>
                        <th>View detail</th>
                    </tr>
                    <c:forEach items="${departmentsLast2days}" var="d">
                        <tr>
                            <td><div class="departementName">${d.name}</div></td>
                            <td>${d.requests.size()}</td>
                            <td> <a class="view" href="view?departmentId=${d.id}">View</a></td>
                        </tr>
                    </c:forEach>
                </table>
                <div id="bottomPagger" class="pagger">
                    <c:forEach begin="1" end="${totalPage}" var="i">
                        <a class="${i==pageIndex?"active":""}" href="home?page=${i}">${i}</a>
                    </c:forEach>
                </div>

            </div>
        </div>
        <jsp:include page="Footer.jsp"/>

    </body>
</html>
