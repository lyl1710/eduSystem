<%-- 
    Document   : Error
    Created on : Jun 21, 2021, 8:43:15 PM
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
                <div class="homeTilte"><h2>RequestID:${req.id}</h2> </div>
                <div class="Solve">
                    <form id="form" action="solve" method="POST">
                        <input type="hidden" value="${req.id}" name="id">
                        <div class="department" >Request to department <input class="inputSolve" type="text" value="${req.department.name}" readonly name="department"></div>
                        <div class="studentID" >Student ID <input  class="inputSolve"  type="text"  value="${req.studentID}" readonly name="studentID"></div>
                        <div class="studentName" >Student name <input  class="inputSolve" type="text" value="${req.studentName}" readonly name="studentName"></div>
                        <div class="dateCreated" >Date created <input  class="inputSolve" type="text"value="${req.dateCreated}" readonly name="dateCreated"></div>
                        <div class="requestTitle" >Request title <input  class="inputSolve" type="text"value="${req.title}" readonly name="requestTitle"></div>
                        <div class="requestContent" ><p>Request content</p> <textarea  class="inputSolve" readonly  style="margin: 0px; width: 300px; height: 50px;margin-left: 10px;" name="requestContent">${req.content}</textarea></div>
                        <div class="requestState" >Request State <input  class="inputSolve" id="Approved" <c:if test="${req.status=='Approved'}" >checked=""</c:if> value="Approved" type="radio" name="state"><label class="Approved"  for="Approved">Approved</label> <input id="Reject" <c:if test="${req.status=='Reject'}" >checked=""</c:if>  value="Reject" type="radio" name="state"> <label class="Reject" for="Reject">Reject</label> </div>
                        <div style="color: red; margin-left: 155px">${requestScope.error}</div>
                        <div class="closeDate" >Close date <input  class="inputSolve" type="text"readonly value="${req.closeDatel}" name="closeDate"></div>
                        <div class="admin" >Solve by <input  class="inputSolve" type="text" value="${username}"readonly name="admin"></div>
                        <div class="solution" ><p>School solution</p> <textarea  class="inputSolve" id="solution"  required="" minlength="1" maxlength="30" style="margin: 0px; width: 300px; height: 50px;margin-left: 10px;" name="solution">${requestScope.solution}</textarea></div>
                        <div id="alert"><span style="font-size:16px; margin-left: 10px" >Please fill out the solution field </span></div>
                        <input class="b" type="button" value="Save" onclick="validate()">
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"/>
    </body>
    <script>
     function validate(){
         var solution = document.getElementById("solution").value;
         if(solution.trim() ===""){
             document.getElementById("alert").style.display="block";
         }else{
             document.getElementById("form").submit();
         }
     }
    </script>

</html>
