<%-- 
    Document   : Error
    Created on : Jun 21, 2021, 6:47:18 PM
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
            <div class="viewMid">
                <div class="homeTilte"><h2>View requests</h2> </div>
                <table class="table1">
                    <tr>
                        <th>
                            <form id="frmSearch" action="view" method="GET">
                                <div class="tileTable">
                                    Select department
                                    <select name="departmentId" onchange="submitForm();">
                                        <option value="0">Select a Department</option>
                                        <c:forEach items="${departments}" var="d">
                                            <option
                                                <c:if test="${d.id == departmentId}" >
                                                    selected="selected"
                                                </c:if>
                                                value ="${d.id}"> ${d.name}
                                            </option> 
                                        </c:forEach>
                                    </select>
                                    <div style="display: flex" class="search"><span><b>or Enter request title </b></span> <input style ="margin-left: 5px " type="text" required="" maxlength="20" pattern="^(?=.*[a-z])[a-zA-Z0-9\s]+"  value="${title.trim()}" name="title"> <input style="margin-left: 10px" type="submit" value="View"></div>
                                </div>

                            </form>
                        </th>
                    </tr>
                </table>
                <table class="table2">
                    <tr>
                        <th style="background-color: #edebeb">Request title</th>
                        <th style="background-color: #edebeb">Date created</th>
                        <th style="background-color: #edebeb">Close created</th>
                        <th style="background-color: #edebeb">Status</th>
                        <th style="background-color: #edebeb">Report to</th>
                        <th style="background-color: #edebeb">Detail</th>
                    </tr>
                    <c:forEach items="${requests}" var="r">
                        <tr>
                            <td style="color: #68a859">${r.title}</td>
                            <td>${r.dateCreated}</td>
                            <td>${r.closeDatel}</td>
                            <td>${r.status}</td>
                            <td>${r.department.name}</td>
                            <c:if test="${r.detail}">
                                <td><b style="color: #3ecf65">Sovled</b></a></td>
                            </c:if>
                            <c:if test="${!r.detail}">
                                <td><a style="text-decoration: none" href="solve?id=${r.id}"><b >Solving</b></a></td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </table>
                <div id="bottomPagger" class="pagger">
                    <c:if test="${totalPage gt 1}">
                        <c:forEach begin="1" end="${totalPage}" var="i">
                            <a class="${i==pageIndex?"active":""}" href="view?departmentId=${departmentId}&title=${title}&page=${i}">${i}</a>
                        </c:forEach>
                    </c:if>

                </div>

            </div>
        </div>
        <jsp:include page="Footer.jsp"/>

    </body>
    <script>
        function submitForm()
        {
            document.getElementById("frmSearch").submit();
        }
    </script>
</html>
