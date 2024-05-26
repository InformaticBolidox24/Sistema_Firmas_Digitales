<%-- 
    Document   : HomeFirmas
    Created on : 23-05-2024, 01:33:31
    Author     : andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            
            if(session.getAttribute("txtUser") == null && session.getAttribute("nombre") == null && session.getAttribute("apellido") == null)
            {
                response.sendRedirect("index.html");
            }
        %>
    </head>
    <body>
        <h1>Bienvenido <%= request.getSession().getAttribute("nombre")+" "+request.getSession().getAttribute("apellido") %></h1>
        <p>Usuario Actual: ${txtUser}</p>
        
        <ul>
            <li><a href="Gestion_Usuarios.jsp">Mostrar Usuarios Registrados</a></li>
        </ul>

        <br>
        <form action="/Login_Aplicacion_Firmas_Digitales/Logout" method="POST">
            <input type="submit" value="Cerrar Sesion">
        </form>
    </body>
</html>
