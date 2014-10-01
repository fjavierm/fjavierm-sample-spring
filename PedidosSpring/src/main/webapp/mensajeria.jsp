<%@page import="org.springframework.web.context.*, org.springframework.web.context.support.*" %>
<%@page import="org.especialistajee.spring.negocio.MensajeriaDummy" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
   MensajeriaDummy m = (MensajeriaDummy) wac.getBean("mensajeriaDummy");
   String status = request.getParameter("setStatus");
   if (status!=null) {
       if (status.equals("on"))
           m.setOk(true);
       else
           m.setOk(false);
   }

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Servicio de mensajería</title>
    </head>
    <body>
        <form action="mensajeria.jsp" method="get">
            Estado del servicio:
            <select size="1" name="setStatus">
                <option value="on" <% if (m.isOk()) {out.print("selected");} %>>on</option>
                <option value="off"<% if (!m.isOk()) {out.print("selected");}%>>off</option>
            </select> <br>
            <input type="submit" value="Cambiar estado">
        </form>
        <form action="mensajeria.jsp" method="get">
            <input type="submit" value="Ver estado actual">
        </form>

    </body>
</html>
