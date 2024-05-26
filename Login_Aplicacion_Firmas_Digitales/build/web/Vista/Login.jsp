<%-- 
    Document   : Login
    Created on : 19-05-2024, 21:21:40
    Author     : andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Usuarios</title>
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expire",0);
        %>
    </head>
    <body>
        <div class="cuerpoFormulario" id="cuerpoFormulario">
            <form class="formLogin" id="formLogin" method="POST" action="Login">
                <h1>Inicie Sesion</h1>
                
                <p>Usuario:</p>
                <div class="texto">
                    <input type="text" class="txt" id="txtUser" placeholder="Ingrese su RUT de Usuario..." name="txtUser" required="">
                </div>
                
                <p>Contraseña:</p>
                <div class="texto">
                    <input type="password" class="txt" id="txtPass" placeholder="Ingrese su Contraseña..." name="txtPass" required="">
                </div>
                
                <br>
                
                <input type="submit" value="Iniciar Sesion" class="btn">
                <input type="button" value="Limpiar Datos" class="btn">
            </form>
        </div>
    </body>
</html>
