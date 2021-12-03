<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>Login de Cuhunflu Producciones S.L</h1>
<h2>${mensajelogin}</h2>
<form action="/login" method="post">

	
	<label>Numero de Empleado</label>
	<input type="text" name="IdEmpl" placeholder="Numero de Empleado" >
	</br>
	<label>Correo electronico</label>
	<input type="text" name="correo" placeholder="Correo electronico">
	</br>
	
	<label>Pasword</label>
	<input type="text" name="pasword" placeholder="Pasword">
	</br>
	<input type="submit" value="Enviar">
	
</form>

</body>
</html>