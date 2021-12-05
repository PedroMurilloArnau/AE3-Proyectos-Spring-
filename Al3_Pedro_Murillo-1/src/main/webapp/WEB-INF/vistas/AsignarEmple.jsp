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
<h1>Asignar Empleados al proyecto: ${proyecto.idProyecto}</h1>
<h3>${empleado.nombre}</h3>
<p>Selecciona los diferentes empleados que quieres asignar a este proyecto</p>
<form action="/jefe/AsignarEmpleados/${proyecto.idProyecto}" method="post">
<c:forEach var="empl" items="${listaEmpleados }">
<label>${empl.nombre}</label>
<input type="radio" name="empl" value="${empl.idEmpl }" required="required">
</br>
</c:forEach>
<input type="submit" value="Asignar Empleados Seleccionados">
</form>
<a href="/jefe/proyectos">Volver a Proyectos</a>
</body>
</html>