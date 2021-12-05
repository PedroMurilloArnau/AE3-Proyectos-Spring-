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
<h1>Detalle del Proyecto ${proyecto.idProyecto}</h1>
<h3>${empleado.nombre}</h3>
<table border="2">
<tr>
<th>Nombre Cliente</th>
<th>Empleados Asignados</th>
<th>Productos Asignados</th>
</tr>
<tr>
<td>${proyecto.cliente.nombre }</td>
<td>
<table>
<c:forEach var="emp" items="${ListaEmple}">
<tr>
<td>${emp.empleado.nombre}<td>
</tr>

</c:forEach>
</table>
</td>

<td>
<table>
<c:forEach var="proc" items="${ListaProducto }">
<tr>
<td>${proc.producto.descripcionBreve}</td>
</tr>
</c:forEach>
</table>
</tr>
</table>

<a href="/jefe/proyectos">Volver a Proyectos</a>
</body>
</html>