<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Leads</title>
</head>
<body>
<h2>List All Leads...</h2>
   
   <table>
         <tr>
              <th>firstname</th>
              <th>lastname</th>
              <th>email</th>
              <th>mobile</th>
              <th>action</th>
         </tr>
         
         <c:forEach var="Lead" items="${leads}" >
         <tr>
             <td>${lead.firstname}</td>
             <td>${lead.lastname}</td>
             <td>${lead.email}</td>
             <td>${lead.mobile}</td>
             <td>
                <a href="delete?=${lead.id}">delete</a>
                <a href="update?=${lead.id}">update</a>
             </td>
         </tr>
         </c:forEach>
   </table>
</body>
</html>