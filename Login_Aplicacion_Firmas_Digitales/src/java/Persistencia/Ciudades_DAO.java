/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Ciudad;
import static Persistencia.Conexion_BD.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class Ciudades_DAO 
{
    Connection conexion;
    private PreparedStatement sentenciaPreparada; 
    private ResultSet resultado;
    
     public ArrayList<Ciudad> TraerNombresComunas() 
    {
        ArrayList<Ciudad> elementos = new ArrayList<>();
        try 
        {
            conexion = getConnection();
            String SQL = "SELECT Codigo_Ciudad, Nombre_Ciudad FROM users_2023.ciudades_sistema_firmas ORDER BY Codigo_Ciudad;";
            sentenciaPreparada = conexion.prepareStatement(SQL);
            resultado = sentenciaPreparada.executeQuery();
            while (resultado.next()) 
            {
                String CodigoCiudad = resultado.getString("Codigo_Ciudad");
                String NombreCiudad = resultado.getString("Nombre_Ciudad");
                                
                Ciudad city = new Ciudad(CodigoCiudad, NombreCiudad);
                
                elementos.add(city);
            }
            conexion.close();
        } 
        catch (SQLException ex) 
        {
           System.out.println("Error al Obtener Comuna : "+ex.getMessage());
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
}
