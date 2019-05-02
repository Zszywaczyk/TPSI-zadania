<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Java Web - laboratorium 4</title></head>
<body>
<%--<h1>Witamy w JSP!</h1>--%>
<h1>Cześć, <c:out value="${Person.firstName}"/> ${Person.firstName} ${Person.lastName}!</h1>
<!--Prefix c:out waliduje wpisany kod i zamienia go na czysty tekst, bez interpretuje-->
<a href="mailto:${Person.email}">${Person.email}</a><br>

<c:forEach items="${dniTygodnia}" var="dzien">
    <p> ${dzien} </p>
</c:forEach>


</body>
</html>