<%-- 
    Document   : Gestion_Usuarios
    Created on : 25-05-2024, 13:28:39
    Author     : andre
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.Usuario" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <script src="https://kit.fontawesome.com/bff3d4d764.js" crossorigin="anonymous"></script>
        <title>Todos los Usuarios Registrados</title>
    </head>
    <body>
    <center>
        <section>
            <form action="/Login_Aplicacion_Firmas_Digitales/GestionDeUsuarios" method="POST">
                <input type="submit" name="accion" value="Listar Usuarios Registrados">
                <input type="submit" name="accion" value="Agregar Nuevo Usuario">
            </form>
            <hr>
            <table>
                <thead>
                    <tr>
                        <th>RUT de la Persona</th>
                        <th>Nombre (s)</th>
                        <th>Apellido Paterno</th>
                        <th>Apellido Materno</th>
                        <th>Género</th>
                        <th>Fecha de Nacimiento</th>
                        <th>E-Mail Contacto</th>
                        <th>País de Origen</th> 
                        <th>Comuna de Residencia</th> 
                        <th>Ciudad de Residencia</th> 
                    </tr>
                </thead>
                <tbody>
                   <% 
                    List<Modelo.Usuario> lista = (List<Modelo.Usuario>) request.getAttribute("lista");
                    if(lista != null) {
                            for(Modelo.Usuario dato : lista) {
                    %>
                    <tr>
                        <td><%= dato.getUserRUT() %></td>
                        <td><%= dato.getUserName() %></td>
                        <td><%= dato.getUserPaternalSurname() %></td>
                        <td><%= dato.getUserMaternalSurname() %></td>
                        <td><%= dato.getUserGenderWord() %></td>
                        <td><%= dato.getUserBirthDate() %></td>
                        <td><%= dato.getUserEmail() %></td>
                        <td><%= dato.getUserCountry() %></td>
                        <td><%= dato.getUserCommune() %></td>
                        <td><%= dato.getUserCity() %></td>
                        <td>
                            <form action="/Login_Aplicacion_Firmas_Digitales/GestionDeUsuarios" method="POST">
                                <input type="submit" name="accion" value="Actualizar">
                                <input type="submit" name="accion" value="Eliminar">
                            </form>
                        </td>    
                    </tr>
                    <% 
                        }
                    } else {
                    %>
                    <tr>
                        <td colspan="7">No hay datos disponibles</td>
                    </tr>
                    <% } %>
                </tbody>
                
            </table>
        </section>
    </center>
    </body>
</html>
