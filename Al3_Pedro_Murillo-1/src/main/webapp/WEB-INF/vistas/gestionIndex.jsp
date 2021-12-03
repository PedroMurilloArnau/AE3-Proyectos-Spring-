<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#conter{
background-color: pink;

}
#conter1{
background-color: lightblue;
}
#conter2{
background-color: #90EE90;
}
</style>
</head>
<body>
<h1>Página de gestores</h1>
<h3>${empleado}</h3>
<h2>${mensajeAlta}</h2>
<div id="conter1">
<h2>Apartado Crear un Proyecto</h2>
<form action="/gestion/altaProyecto" method="post">
<fieldset>
<h3>Seleccione un cliente</h3>
<select name="cliente">
<c:forEach var="cle" items="${listaClientes }">
<option value="${cle.cif}">${cle.nombre}</option>
</c:forEach>
</select>
</fieldset>
<fieldset>
<h3>Selecione un Jefe de proyecto</h3>
<select name="jefeProyecto">
<c:forEach var="par" items="${listaJefes }">
<option value="${par.idEmpl}">${par.nombre}</option>
</c:forEach>
</select>
</fieldset>
<h3>Codigo:</h3>
<label>Escriba el codigo del proyecto</label>
<input type="text" name="idProyecto" placeholder="codigo de proyecto">
<input type="submit" value="Reservar">
</form>
</div>
<div id="conter">
<h2>Apartado de Finalizar Proyecto</h2>
<form action="/gestion/terminarProyecto" method="post">
<table border="2">
<tr>
<th>No Proyecto</th>
<th>Precio Real</th>
<th>Fecha de fin del proyecto</th>
</tr>

<tr>

<td><select name="idProyecto">
<c:forEach var="proy" items="${listaProyectos }">
<option type="text" value="${proy.idProyecto }">${proy.idProyecto }</option>
</c:forEach>
</select>
</td>
<td><input type="number" name="costeReal" placeholder="Precio Real"></td>
<td><input type="date" name="fechaFinReal"><td>
<td><input type="submit" value="Finalizar Proyecto"></td>
</tr>

</table>
</form>
</div>
<div id="conter2">

<h2>Alta de Productos</h2>
<form action="/gestion/altaProducto" method="post">
<table border="2">
<tr>
<th>Id Producto</th>
<th>Precio Unitario</th>
<th>Stock</th>
<th>Descripcion Breve</th>
<th>Descripcion Larga</th>
</tr>
<tr>
<td><input type="number" name="idProducto" placeholder="Id Producto"></td>
<td><input type="number" name="precioUnitario" placeholder="Precio Unitario"></td>
<td><input type="number" name="Stock" placeholder="Stock"></td>
<td><input type="text" name="descripcionBreve" placeholder="Descripcion Breve"></td>
<td><input type="text" name="descripcionLarga" placeholder="Descripcion Larga"></td>
</tr>

</table>

<input type="submit" value="Dar de alta Producto">
</form>
</div>
<a href="/logout">Logout</a>
</body>
</html>