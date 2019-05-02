<%--
  Created by IntelliJ IDEA.
  User: Zszywacz
  Date: 26.03.2019
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
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
  <body style="font-family: Cambria, sans-serif">

    <h1>Licznik odwiedzin strony (sesja): <span style="font-style: italic;">${counter}</span></h1>

    <table>
        <tr>
            <th>Imię</th>
            <th>Nazwisko</th>
            <th>Email</th>
        </tr>
    <c:forEach items="${Students}" var="Student">
        <tr>
            <td><c:out value="${Student.firstName}"/></td>
            <td><c:out value="${Student.lastName}"/></td>
            <td><a href="mailto:<c:out value="${Student.email}"/>"><c:out value="${Student.email}"/></a></td>
        </tr>
    </c:forEach>
    </table>

    <form action="/Lab05_war_exploded/" method="post">
        <label for="name">Imię: </label>
        <input type="text" id="name" name="name" required><br>
        <label for="surname">Nazwisko: </label>
        <input type="text" id="surname" name="surname" required><br>
        <label for="email">Email: </label>
        <input type="email" id="email" name="email" required><br>
        <input type="submit">
    </form>

  </body>
</html>
