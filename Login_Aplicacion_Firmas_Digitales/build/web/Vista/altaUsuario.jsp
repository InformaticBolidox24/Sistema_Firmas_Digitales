<%-- 
    Document   : altaUsuario
    Created on : 19-05-2024, 21:21:23
    Author     : andre
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Controlador.Controller_Show_CBoxes" %>
<%@ page import="Modelo.Pais" %>
<%@ page import="Modelo.Comunas" %>
<%@ page import="Modelo.Ciudad" %>
<%@ page import="Modelo.Usuario" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Nuevos Usuarios</title>
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires",0);
        %>
    </head>
    <body>
        <div class="cuerpoFormulario" id="cuerpoFormulario">
            <form action="Controlador_Usuarios" class="formuarioInscr" id="formularioInscr" method="POST">
                <h1>Registro de Nuevos Usuarios</h1>
                
                <label>(*) </label><label>RUT:</label><input type="text" class="txt" id="txtRUT" name="txtRUT" required=""> <label class="avisoUsuario" id="avisoUsuario">(*) Este Representará tu Nombre de Usuario</label>
                <br>
                <br>
                <label>Nombre(s):</label><input type="text" class="txt" id="txtName" name="txtName" required="">
                <br>
                <br>
                <label>Apellido Paterno:</label><input type="text" class="txt" id="txtFSurname" name="txtFSurname" required="">
                <br>
                <br>
                <label>Apellido Materno:</label><input type="text" class="txt" id="txtLSurname" name="txtLSurname" required="">
                <br>
                <br>
                <label for="selGen">Genero:</label>
                    <select class="sel" id="selGen" name="selGen">
                        <option value="0">---Seleccione---</option>
                        <option value="1">FEMENINO</option>
                        <option value="2">MASCULINO</option>
                    </select>
                <br>
                <br>
                <label for="txtBirthDate">Fecha de Nacimiento:</label><input type="date" class="dttime" id="txtBirthDate" name="txtBirthDate" required="">
                <br>
                <br>
                <label>Correo Electronico:</label><input type="email" class="txtEmail" id="txtEmail" name="txtEmail" required="">
                <br>
                <br>
                <% 
                    Controller_Show_CBoxes cbCommon = new Controller_Show_CBoxes();
                    ArrayList<Modelo.Comunas> CBCOMMONS = cbCommon.TraerListadoComunas();
                %>
                <label for="selCom">Comuna:</label>
                    <select class="sel" id="selCom" name="selCom">
                        <option value="0">-------Seleccione Comuna-------</option>
                    <% 
                        for(Modelo.Comunas dato : CBCOMMONS) 
                        {
                    %>
                    <option value="<%= dato.getCommonCode() %>"><%= dato.getCommonName() %></option>
                    <% 
                        }
                    %>
                    </select>
                <br>
                <br>
                <% 
                    Controller_Show_CBoxes cbCities = new Controller_Show_CBoxes();
                    ArrayList<Modelo.Ciudad> CBCITIES = cbCities.TraerListadoCiudades();
                %>
                <label for="selCiu">Ciudad:</label>
                    <select class="sel" id="selCiu" name="selCiu">
                        <option value="0">-------Seleccione-------</option>
                        <% 
                            for(Modelo.Ciudad dato : CBCITIES) 
                            {
                        %>
                        <option value="<%= dato.getCityCode() %>"><%= dato.getCityName() %></option>
                        <% 
                            }
                        %>
                    </select>
                <br>
                <br>
                <% 
                    Controller_Show_CBoxes cbCountry = new Controller_Show_CBoxes();
                    ArrayList<Modelo.Pais> CBCOUNTRIES = cbCountry.TraerListadoPaises();
                %>
                <label for="selPais">Pais:</label>
                    <select class="sel" id="selPais" name="selPais">
                        <option value="0">-------Seleccione País-------</option>
                        <% 
                        for(Modelo.Pais dato : CBCOUNTRIES) 
                        {
                    %>
                    
                    <option value="<%= dato.getCountryCode() %>"><%= dato.getCountryName() %></option>
                    <% 
                        }
                    %>
                    </select>
                <br>
                <br>
                <label>Nueva Contraseña:</label><input type="password" class="txt" id="txtPass" name="txtPass" onkeyup="coincidenciaPasswords()" required="">
                <br>
                <br>
                <label>Confirmar Contraseña:</label><input type="password" class="txt" id="txtConfPass" name="txtConfPass" onkeyup="coincidenciaPasswords()" required="">
                <br>
                <br>
                <label class="avisoPass" id="avisoPass">------------------------</label>
                <br>
                <br>
                
                <input type="submit" value="Enviar Datos" class="btn" id="btnEnviar" disabled=""/>
                <input type="button" value="Limpiar Datos" class="btn" id="btnLimpiarDatos" onclick="resetearFormulario()" />
            </form>
        </div>
    </body>
</html>
