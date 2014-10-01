<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.springframework.web.context.*, 
                org.springframework.web.context.support.*" %>
<%@page import="org.especialistajee.spring.datos.*" %>
<%@page import="org.especialistajee.spring.modelo.*" %>
<%
  WebApplicationContext wac = 
       WebApplicationContextUtils.getWebApplicationContext(getServletContext());
  IProductosDAO pdao = (IProductosDAO) wac.getBean("productosDAOJPA");
  int id = Integer.parseInt(request.getParameter("id"));
  ProductoEntity prod = pdao.buscarProducto(id);
%>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver un producto</title>
    </head>
    <body>
        <h1>Datos del producto</h1>
        <strong>Código:</strong> <%= prod.getId() %> <br>
        <strong>Descripción:</strong> <%= prod.getNombre() %> <br>
    </body>
</html>