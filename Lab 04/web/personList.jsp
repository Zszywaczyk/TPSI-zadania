<%--
  Created by IntelliJ IDEA.
  User: Zszywacz
  Date: 25.03.2019
  Time: 01:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>

<h2>HTML Table</h2>
<table>
    <tr>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>Email</th>
    </tr>
    <c:forEach items="${Persons}" var="Person">
        <tr>
            <td><c:out value="${Person.firstName}"/></td>
            <td><c:out value="${Person.lastName}"/></td>
            <td><c:out value="${Person.email}"/></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
