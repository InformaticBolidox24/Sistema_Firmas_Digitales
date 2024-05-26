<%-- 
    Document   : Actualizar_Registro_Usuario
    Created on : 25-05-2024, 19:52:38
    Author     : andre
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Controlador.Controller_Show_CBoxes" %>
<%@ page import="Modelo.Usuario" %>
<%@ page import="Modelo.Pais" %>
<%@ page import="Modelo.Comunas" %>
<%@ page import="Modelo.Ciudad" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Registros</title>
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires",0);
        %>
        
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script>
            function getUserInfo() {
                var rutUsuario = $("#selRUT").val();
                $.ajax({
                    url: "/GetUserInfo",
                    type: "POST",
                    data: { RUT_Usuario: rutUsuario },
                    success: function(data) {
                        $("#txtName").val(data.Nombres_Usuario);
                        $("#txtFSurname").val(data.Apellido_Paterno_Usuario);
                        $("#txtLSurname").val(data.Apellido_Materno_Usuario);
                        //$("#selGen").val(data.Genero_Usuario);
                        $("#txtBirthDate").val(data.Fecha_de_Nacimiento_Usuario);
                        $("#txtEmail").val(data.Correo_Electronico_Usuario);
                        //$("#selCom").val(data.Comuna_Persona);
                        //$("#selCiu").val(data.Ciudad_Usuario);
                        //$("#selPais").val(data.Pais_Usuario);

                    },
                    error: function() {
                        alert("Error al obtener la información del usuario.");
                    }
                });
            }
        </script>
    </head>
    <body>
        <div class="cuerpoFormulario" id="cuerpoFormulario">
            <form action="Controlador_Usuarios" class="formuarioInscr" id="formularioInscr" method="POST">
                <h1>Actualizar Usuario Existente</h1>
                
                <% 
                    Controller_Show_CBoxes cbController = new Controller_Show_CBoxes();
                    ArrayList<Modelo.Usuario> CBRUT = cbController.TraerListadoUsuariosRegistrados();
                    ArrayList<Modelo.Comunas> CBCOMMONS = cbController.TraerListadoComunas();
                    ArrayList<Modelo.Ciudad> CBCITIES = cbController.TraerListadoCiudades();
                    ArrayList<Modelo.Pais> CBCOUNTRIES = cbController.TraerListadoPaises();
                %>
                <label for="selRUT">RUT:</label>
                    <select class="sel" id="selRUT" name="selRUT">
                        <option value="0">---Seleccione RUT Usuario---</option>
                        <% 
                            for(Modelo.Usuario dato : CBRUT) 
                            {
                            System.out.println("Usuarios cargados: " + dato.getUserRUT()); // Depuración
                        %>
                    <option value="<%= dato.getUserRUT() %>"><%= dato.getUserRUT() %></option>
                        <% 
                            }
                        %>
                    </select>
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
                <label class="avisoPass" id="avisoPass"></label>
                <br>
                <br>
                
                <input type="submit" value="Enviar Datos" class="btn" id="btnEnviar" disabled=""/>
                <input type="button" value="Limpiar Datos" class="btn" id="btnLimpiarDatos" onclick="resetearFormulario()" />
            </form>
        </div>
    </body>
</html>

