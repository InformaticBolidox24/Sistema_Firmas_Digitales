/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Usuario;
import static Persistencia.Conexion_BD.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author andre
 */
public class Usuarios_DAO {
    
    private Connection conexion;
    private PreparedStatement sentenciaPreparada,sentenciaPreparada2; 
    private ResultSet resultado;
    
    
    public boolean Registrar_Nuevo_Usuario(Usuario NewUser)
    {
        boolean CREADO = false;
        try 
        {
            conexion = getConnection();
            String SQL = """
                         INSERT INTO  personas (personas.RUT_Usuario, personas.Nombres_Usuario, personas.Apellido_Paterno_Usuario,
                         \t\t\t\t\t   personas.Apellido_Materno_Usuario,personas.Genero_Usuario,personas.Fecha_de_Nacimiento_Usuario,
                                                personas.Correo_Electronico_Usuario,personas.Comuna_Persona,personas.Ciudad_Usuario,personas.Pais_Usuario)
                                                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?); """;
            sentenciaPreparada = conexion.prepareStatement(SQL);
            sentenciaPreparada.setString(1, NewUser.getUserRUT());
            sentenciaPreparada.setString(2, NewUser.getUserName());
            sentenciaPreparada.setString(3, NewUser.getUserPaternalSurname());
            sentenciaPreparada.setString(4, NewUser.getUserMaternalSurname());
            sentenciaPreparada.setInt(5, NewUser.getUserGender());
            sentenciaPreparada.setString(6, NewUser.getUserBirthDate());
            sentenciaPreparada.setString(7, NewUser.getUserEmail());
            sentenciaPreparada.setString(8, NewUser.getUserCommune());
            sentenciaPreparada.setString(9, NewUser.getUserCity());
            sentenciaPreparada.setString(10, NewUser.getUserCountry());
            int flag = sentenciaPreparada.executeUpdate();
            
            if(flag > 0)
            {
                String SQL2 = "INSERT INTO  usuarios_sesion (usuarios_sesion.Nombre_Usuario,usuarios_sesion.Password_USER) VALUES (?, ?);  ";
                sentenciaPreparada2 = conexion.prepareStatement(SQL2);
                sentenciaPreparada2.setString(1, NewUser.getUserRUT());
                sentenciaPreparada2.setString(2, NewUser.getUserPassword());
                int flag2 = sentenciaPreparada2.executeUpdate();
                
                if(flag2 > 0)
                {
                    CREADO = true;
                }
            }
            else
            {
                CREADO = false;
            }
            conexion.close();
        } 
        catch (SQLException e) 
        {
            System.out.println("Error: "+e.getMessage());
            CREADO = false;
        }
        finally
        {
            try 
            {
                conexion.close();
            } 
            catch (SQLException e) 
            {
                System.out.println("Error: "+e.getMessage());
            }
        }
        return CREADO;
    }
    
    public boolean Validar_Usuario_Existente(Usuario UserReview)
    {
        boolean USUARIOEXISTENTE = false;
        try 
        {
            conexion = getConnection();
            String SQL = "SELECT usuarios_sesion.Nombre_Usuario FROM users_2023.usuarios_sesion WHERE Nombre_Usuario = ?;";
            sentenciaPreparada = conexion.prepareStatement(SQL);
            sentenciaPreparada.setString(1, UserReview.getUserRUT());
            resultado = sentenciaPreparada.executeQuery();
            
            if(resultado.next())
            {
                USUARIOEXISTENTE = true;
            }
            else
            {
                USUARIOEXISTENTE = false;
            }
            
            
            conexion.close();
        } 
        catch (SQLException e) 
        {
            System.out.println("Error: "+e.getMessage());
            USUARIOEXISTENTE = false;
        }
        finally
        {
            try 
            {
                conexion.close();
            } 
            catch (SQLException e) 
            {
                System.out.println("Error: "+e.getMessage());
            }
        }
        return USUARIOEXISTENTE;
    }
    
    public boolean Iniciar_Sesion(Usuario UserLogin)
    {
        boolean logeado = false;
        try 
        {
            conexion = getConnection();
            String SQL = "SELECT usuarios_sesion.Nombre_Usuario, usuarios_sesion.Password_USER FROM users_2023.usuarios_sesion WHERE Nombre_Usuario = ? AND Password_USER = ?;";
            sentenciaPreparada = conexion.prepareStatement(SQL);
            sentenciaPreparada.setString(1, UserLogin.getUserRUT());
            sentenciaPreparada.setString(2, UserLogin.getUserPassword());
            resultado = sentenciaPreparada.executeQuery();
            
            if(resultado.next())
            {
                logeado = true;
            }
            else
            {
                logeado = false;
            }
            
            
            conexion.close();
        } 
        catch (SQLException e) 
        {
            System.out.println("Error: "+e.getMessage());
            logeado = false;
        }
        finally
        {
            try 
            {
                conexion.close();
            } 
            catch (SQLException e) 
            {
                System.out.println("Error: "+e.getMessage());
            }
        }
        return logeado;
    }
    
    public Usuario obtenerNombre(String UserName)
    {
        String name = "";
        String Surname = "";
        Usuario UN = null;
        try 
        {
            conexion = getConnection();
            String SQL = "SELECT personas.Nombres_Usuario,personas.Apellido_Paterno_Usuario FROM personas WHERE RUT_Usuario = ?; ";
            sentenciaPreparada = conexion.prepareStatement(SQL);
            sentenciaPreparada.setString(1, UserName);
            resultado = sentenciaPreparada.executeQuery();
            
            if(resultado.next())
            {
                name = resultado.getString("Nombres_Usuario");
                Surname = resultado.getString("Apellido_Paterno_Usuario");
                UN = new Usuario(name, Surname, null);
            }
            else
            {            

                UN = null;
            }
            
            conexion.close();
        } 
        catch (SQLException e) 
        {
            System.out.println("Error: "+e.getMessage());
        }
        finally
        {
            try 
            {
                conexion.close();
            } 
            catch (SQLException e) 
            {
                System.out.println("Error: "+e.getMessage());
            }
        }
        return UN;
    }
    
    public List<Usuario> TraerRegistrosUsuarios() 
    {
        List<Usuario> elementos = new ArrayList<>();
        Usuario USER = null;
        try 
        {
            conexion = getConnection();
            String SQL = """
                         SELECT personas.RUT_Usuario ,personas.Nombres_Usuario, personas.Apellido_Paterno_Usuario, personas.Apellido_Materno_Usuario,
                         generos_personas.Nombre_Genero, personas.Fecha_de_Nacimiento_Usuario, personas.Correo_Electronico_Usuario, paises_sistema_firmas.Nombre_Pais,
                         comunas_sistema_firmas.Nombre_Comuna, ciudades_sistema_firmas.Nombre_Ciudad FROM personas 
                         INNER JOIN generos_personas ON personas.Genero_Usuario = generos_personas.ID_Genero
                         INNER JOIN paises_sistema_firmas ON personas.Pais_Usuario = paises_sistema_firmas.CodigoPais
                         INNER JOIN comunas_sistema_firmas ON personas.Comuna_Persona = comunas_sistema_firmas.CUT_Comuna
                         INNER JOIN ciudades_sistema_firmas ON personas.Ciudad_Usuario = ciudades_sistema_firmas.Codigo_Ciudad;""";
            sentenciaPreparada = conexion.prepareStatement(SQL);
            resultado = sentenciaPreparada.executeQuery();
            while (resultado.next()) 
            {
                String Rut = resultado.getString("personas.RUT_Usuario");
                String Nombre_s = resultado.getString("personas.Nombres_Usuario");
                String ApellidoPaterno = resultado.getString("personas.Apellido_Paterno_Usuario");
                String ApellidoMaterno = resultado.getString("personas.Apellido_Materno_Usuario");
                String GeneroPalabra = resultado.getString("generos_personas.Nombre_Genero");
                String FechaNacimiento = resultado.getString("personas.Fecha_de_Nacimiento_Usuario");
                String Email = resultado.getString("personas.Correo_Electronico_Usuario");
                String Pais = resultado.getString("paises_sistema_firmas.Nombre_Pais");
                String Comuna = resultado.getString("comunas_sistema_firmas.Nombre_Comuna");
                String Ciudad = resultado.getString("ciudades_sistema_firmas.Nombre_Ciudad");
                
                USER = new Usuario(Rut, Nombre_s, ApellidoPaterno, ApellidoMaterno, GeneroPalabra, FechaNacimiento, Email, Comuna, Ciudad, Pais, null);
                
                elementos.add(USER);
            }
        } 
        catch (SQLException ex) 
        {
           System.out.println("Error al Obtener Usuarios : "+ex.getMessage());
        }
        return elementos;
    }
    
    public boolean Actualizar_datos_de_Usuario(Usuario UserUpdate)
    {
        boolean updated = false;
        try 
        {
            conexion = getConnection();
            String SQL = """
                         UPDATE personas SET personas.Nombres_Usuario = ?, personas.Apellido_Paterno_Usuario = ?, personas.Apellido_Materno_Usuario = ?,
                         personas.Genero_Usuario = ?, personas.Fecha_de_Nacimiento_Usuario = ?, personas.Correo_Electronico_Usuario = ?,
                         personas.Pais_Usuario = ?, personas.Comuna_Persona = ?, personas.Ciudad_Usuario = ?, personas.Fecha_Ultima_Modificacion = CURRENT_TIMESTAMP()
                         WHERE personas.RUT_Usuario = ?;""";
            sentenciaPreparada = conexion.prepareStatement(SQL);
            sentenciaPreparada.setString(1, UserUpdate.getUserRUT());
            sentenciaPreparada.setString(2, UserUpdate.getUserName());
            sentenciaPreparada.setString(3, UserUpdate.getUserPaternalSurname());
            sentenciaPreparada.setString(4, UserUpdate.getUserMaternalSurname());
            sentenciaPreparada.setInt(5, UserUpdate.getUserGender());
            sentenciaPreparada.setString(6, UserUpdate.getUserBirthDate());
            sentenciaPreparada.setString(7, UserUpdate.getUserEmail());
            sentenciaPreparada.setString(8, UserUpdate.getUserCommune());
            sentenciaPreparada.setString(9, UserUpdate.getUserCity());
            sentenciaPreparada.setString(10, UserUpdate.getUserCountry());
            int flag = sentenciaPreparada.executeUpdate();
            
            if(flag > 0)
            {
                String SQL2 = "UPDATE usuarios_sesion SET usuarios_sesion.Password_USER = ? WHERE usuarios_sesion.Nombre_Usuario = ? ";
                sentenciaPreparada2 = conexion.prepareStatement(SQL2);
                sentenciaPreparada2.setString(1, UserUpdate.getUserRUT());
                sentenciaPreparada2.setString(2, UserUpdate.getUserPassword());
                int flag2 = sentenciaPreparada2.executeUpdate();
                
                if(flag2 > 0)
                {
                    updated = true;
                }
            }
            else
            {
                updated = false;
            }
            conexion.close();
        } 
        catch (SQLException e) 
        {
            System.out.println("Error: "+e.getMessage());
            updated = false;
        }
        finally
        {
            try 
            {
                conexion.close();
            } 
            catch (SQLException e) 
            {
                System.out.println("Error: "+e.getMessage());
            }
        }
        return updated;
    }
    
    public boolean Borrar_datos_de_Usuario(Usuario UserDelete)
    {
        boolean deleted = false;
        try 
        {
            conexion = getConnection();
            String SQL = "DELETE FROM personas WHERE personas.RUT_Usuario = ?;";
            sentenciaPreparada = conexion.prepareStatement(SQL);
            sentenciaPreparada.setString(1, UserDelete.getUserRUT());
            int flag = sentenciaPreparada.executeUpdate();
            
            if(flag > 0)
            {
                deleted = true;
            }
            else
            {
                deleted = false;
            }
            conexion.close();
        } 
        catch (SQLException e) 
        {
            System.out.println("Error: "+e.getMessage());
            deleted = false;
        }
        finally
        {
            try 
            {
                conexion.close();
            } 
            catch (SQLException e) 
            {
                System.out.println("Error: "+e.getMessage());
            }
        }
        return deleted;
    }
    
     public ArrayList<Usuario> TraerUsuariosRegistrados() 
    {
        ArrayList<Usuario> elementos = new ArrayList<>();
        try 
        {
            conexion = getConnection();
            String SQL = "SELECT RUT_Usuario FROM users_2023.personas;";
            sentenciaPreparada = conexion.prepareStatement(SQL);
            resultado = sentenciaPreparada.executeQuery();
            while (resultado.next()) 
            {
                String RUTUsuario = resultado.getString("RUT_Usuario");
                                
                Usuario user = new Usuario(RUTUsuario,null);
                
                elementos.add(user);
            }
            conexion.close();
        } 
        catch (SQLException ex) 
        {
           System.out.println("Error al Obtener Pais : "+ex.getMessage());
        }
        finally
        {
            try 
            {
                conexion.close();
            } 
            catch (SQLException e) 
            {
                System.out.println("Error: "+e.getMessage());
            }
        }
        return elementos;
    }
     
    public JSONObject SaveInfoUserJSON(String RUT_User)
    {
        JSONObject userInfo = null;
        try 
        {
            conexion = getConnection();
            String SQL = "SELECT * FROM users_2023.personas WHERE RUT_Usuario = ?;";
            sentenciaPreparada = conexion.prepareStatement(SQL);
            sentenciaPreparada.setString(1, RUT_User);
            resultado = sentenciaPreparada.executeQuery();
            while (resultado.next()) 
            {
                String RUT_Usuario = resultado.getString("RUT_Usuario");
                String Nombres_Usuario = resultado.getString("Nombres_Usuario");
                String Apellido_Paterno_Usuario = resultado.getString("Apellido_Paterno_Usuario");
                String Apellido_Materno_Usuario = resultado.getString("Apellido_Materno_Usuario");
                String Genero_Usuario = resultado.getString("Genero_Usuario");
                String Fecha_de_Nacimiento_Usuario = resultado.getString("Fecha_de_Nacimiento_Usuario");
                String Correo_Electronico_Usuario = resultado.getString("Correo_Electronico_Usuario");
                String Pais_Usuario = resultado.getString("Pais_Usuario");
                String Comuna_Persona = resultado.getString("Comuna_Persona");
                String Ciudad_Usuario = resultado.getString("Ciudad_Usuario");
                
                userInfo = new JSONObject();
                userInfo.put("RUT_Usuario", RUT_Usuario);
                userInfo.put("Nombres_Usuario", Nombres_Usuario);
                userInfo.put("Apellido_Paterno_Usuario", Apellido_Paterno_Usuario);
                userInfo.put("Apellido_Materno_Usuario", Apellido_Materno_Usuario);
                userInfo.put("Genero_Usuario", Genero_Usuario);
                userInfo.put("Fecha_de_Nacimiento_Usuario", Fecha_de_Nacimiento_Usuario);
                userInfo.put("Correo_Electronico_Usuario", Correo_Electronico_Usuario);
                userInfo.put("Pais_Usuario", Pais_Usuario);
                userInfo.put("Comuna_Persona", Comuna_Persona);
                userInfo.put("Ciudad_Usuario", Ciudad_Usuario);
            }
            conexion.close();
        }
        catch (SQLException ex) 
        {
           System.out.println("Error: "+ex.getMessage());
        }
        finally
        {
            try 
            {
                conexion.close();
            } 
            catch (SQLException e) 
            {
                System.out.println("Error: "+e.getMessage());
            }
        }
        return userInfo;
    }
}
