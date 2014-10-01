<%-- 
    Document   : index
    Created on : 01-abr-2011, 15:31:59
    Author     : especialista
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cliente REST de Dailymotion</title>
    </head>
    <body>
        <h1>Buscar videos en dailymotion</h1>
        <form action="buscar.do" method="get">
            Texto a buscar: <input type="text" name="texto">
            <input type="submit" value="Buscar">
        </form>
    </body>
</html>
