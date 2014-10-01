<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
      <title>AmigosSpring: Mi p�gina personal (${usuario.login}) </title> 
	  <link href="amigos.css" rel="stylesheet" type="text/css">
	  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>
<body>
	<jsp:include page="navegacion.jsp"/>
	<div id="principal">
	<h1>Mi p�gina personal (${usuario.login})</h1>
	<b>Sexo:</b> ${usuario.sexo} <br>
	<b>Edad:</b> ${usuario.edad} <br>
	<b>Localidad:</b> ${usuario.localidad} <br>	
	${usuario.descripcion} <br> <br> <br> <br> 
	Tienes <b>${usuario.credito} cr�ditos </b>en tu cuenta personal.
        <div style="color:red">${error}</div> 
	</div>

</body>
</html>