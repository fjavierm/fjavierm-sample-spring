<%-- 
    Document   : listar
    Created on : 05-may-2010, 23:30:43
    Author     : especialista
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="listado.title" /></title>
    </head>
    <body>
        <h1><spring:message code="listado.header" /></h1>
        
        <a href="listar.do?locale=es_es">es</a>
        <a href="listar.do?locale=en_us">en</a>
        <table>
            <thead>
              <tr>
                <th>Matrícula</th> <th>Modelo</th> <th>Fecha matr.</th> <th>Km.</th> <th>Precio/día</th>
                <th></th>
              </tr>  
            </thead>
            <tbody>
            <c:forEach items="${listado}" var="coche" varStatus="i">
                <tr>
                    <td>${coche.matricula}</td>
                    <td>${coche.modelo}</td>
                    <td><fmt:formatDate dateStyle="SHORT" value="${coche.fechaMatriculacion}"/> </td> <td>${coche.km}</td>
                    <td>${coche.precio}</td>
                    <td> <a href="editar.do?matricula=${coche.matricula}">Editar</a> </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="crear.do">Alta de nuevo coche</a>
    </body>
</html>
