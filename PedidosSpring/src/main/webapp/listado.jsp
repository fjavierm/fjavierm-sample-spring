<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="org.springframework.web.context.*, org.springframework.web.context.support.*" %>
<%@page import="org.especialistajee.spring.datos.*" %>
<%@page import="org.especialistajee.spring.modelo.*" %>
<%@page import="org.especialistajee.spring.negocio.MensajeriaDummy" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de pedidos</title>
    </head>
    <body>
        <h1>Listado de pedidos</h1>
        <table>
            <tr>
                <th>Cliente</th>
                <th>Producto</th>
                <th>Unidades</th>
            </tr>
        <%
           WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
           IPedidosDAO pdao = (IPedidosDAO) wac.getBean("pedidosDAOJDBC");
           for (Pedido p : pdao.listarPedidos()) {
        %>
                <tr>
                    <td><%=p.getIdCliente()%></td>
                    <td><%=p.getIdProducto()%></td>
                    <td><%=p.getUnidades()%></td>
                </tr>
        <% 
           }
        %>
        </table>
    </body>
</html>
