<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.springframework.web.context.*, org.springframework.web.context.support.*" %>
<%@page import="org.especialistajee.spring.negocio.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
 //si se cumple, se llama al JSP directamente (no a través del formulario)
 if (request.getParameter("idCliente")==null) {
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comprar productos</title>
    </head>
    <body>
        <h1>Hacer pedido</h1>
        <form action="index.jsp" method="get">
            Cliente: <input type="text" name="idCliente" value="1"/> <br/>
            Producto: <input type="text" name="idProducto" value="1"/> <br/>
            Cantidad a pedir : <input type="text" name="unidades" value="1"/> <br/>
            <input type="submit" value="pedir">
        </form>
    </body>
</html>
<%
}
//Se está llamando al JSP con los datos del formulario llenos
else {
			ServletContext sc = getServletContext();
            WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
            //TODO: aquí hay que instanciar un bean del tipo IGestorPedidos, pidiéndoselo a Spring
            IGestorPedidos gp = (GestorPedidosSimple) wac.getBean("gestorPedidosSimple");
            int idProducto = Integer.parseInt(request.getParameter("idProducto"));
            int unidades = Integer.parseInt(request.getParameter("unidades"));
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            gp.insertarPedido(idCliente, idProducto, unidades);
            out.print("pedido hecho correctamente");
            out.print("<br> <a href=\"index.jsp\">Nuevo pedido</a>");
}
%>
