<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Pruebas pare ver Iner </h1>
<form action="/pruebas" method="post">
<input type="date" name="fechaFinReal">
<input type="text" name="descripcion">
<select name="cliente">
<c:forEach var="cle" items="${listaClientes }">
<option value="${cle.cif}">${cle.nombre}</option>
</c:forEach>
</select>
<input type="submit" value="Enviar pruebas">
</form>

</body>
</html>