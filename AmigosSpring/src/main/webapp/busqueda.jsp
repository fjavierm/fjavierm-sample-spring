<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>AmigosSpring: búsqueda de usuarios</title>
        <link href="amigos.css" rel="stylesheet" type="text/css">

    </head>
    <body>
        <h1>Búsqueda de usuarios</h1>
        <br/>
        <form:form modelAttribute="criterios" method="post" action="busqueda.do">
			Busco
            <form:select path="sexo">
                <form:option value="mujer"/>
                <form:option value="hombre"/>
                <form:option value="indiferente"/>
            </form:select> <br/>
            entre <form:input path="edadMin"/> <form:errors path="edadMin" cssClass="rojo"/> <br/>
            y <form:input path="edadMax"/> <form:errors path="edadMax" cssClass="rojo"/> <br/>
            y que viva en <form:input path="localidad"/> <br/> (en blanco para cualquiera)
            <input type="submit" value="buscar"/>
        </form:form>
    </body>
</html>