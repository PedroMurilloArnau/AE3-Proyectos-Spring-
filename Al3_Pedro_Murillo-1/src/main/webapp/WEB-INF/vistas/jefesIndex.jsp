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
<h1>Página de Jefes de Proyectos</h1>
<h3>${empleado}</h3>
<h4>${mensaje}</h4>
<div id="cof">
<table border="1">
<tr>
<th>No Proyecto</th>
<th>Estado</th>
<th>Cliente</th>
</tr>

<c:forEach var="cle" items="${listaProyectos }">

<tr>
<td>${cle.idProyecto }</td>
<td>${cle.estado }</td>
<td>${cle.cliente.nombre }</td>
<td><a href="/jefe/verDetalle/${cle.idProyecto }">Ver Detalle</a></td>
<td><a href="/jefe/AsignarEmpleados/${cle.idProyecto }">Asignar Empleados</a></td>
</tr>
</form>


</c:forEach>
</table>
</div>
<a href="/logout">Logout</a>
</body>
</html>