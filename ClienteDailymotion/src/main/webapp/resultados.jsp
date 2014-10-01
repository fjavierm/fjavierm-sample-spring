<%-- 
    Document   : resultados
    Created on : 01-abr-2011, 15:45:52
    Author     : especialista
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultados de la búsqueda</title>
    </head>
    <body>
        <h1>Resultados de la búsqueda</h1>
        Página ${resultados.page} <br>
        <c:forEach items="${resultados.list}" var="video">
            <img src="${video.thumbnail_medium_url}"> <br>
            <p>${video.title}
                <a href="${video.url}">Ver video</a> </p> <br> <br>
        </c:forEach>
        <c:if test="${resultados.has_more}">
            <a href="dummy.do">Ver más</a> (este enlace no va a funcionar ya que es solo un ejemplo) <br>
        </c:if>
    </body>
</html>
