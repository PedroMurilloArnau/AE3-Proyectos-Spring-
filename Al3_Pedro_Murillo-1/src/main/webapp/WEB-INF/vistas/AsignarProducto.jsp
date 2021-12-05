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

<h1>Asignar Productos al proyecto: ${proyecto.idProyecto}</h1>
<h3>${empleado.nombre}</h3>
<p>Selecciona los diferentes productos que quieres asignar a este proyecto.</p>
<form action="/jefe/AsignarProductos/${proyecto.idProyecto}" method="post">
<c:forEach var="empl" items="${listaProductos }">
<label>${empl.descripcionBreve}</label>
<input type="radio" name="prod" value="${empl.idProducto}" required="required">
</br>
</c:forEach>
<input type="submit" value="Asignar Producto Seleccionado">
</form>
<a href="/jefe/proyectos">Volver a Proyectos</a> 
</body>
</html>