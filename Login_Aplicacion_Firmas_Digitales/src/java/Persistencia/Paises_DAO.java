
package Persistencia;

import Modelo.Pais;
import static Persistencia.Conexion_BD.getConnection;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author andre
 */
public class Paises_DAO 
{
    Connection conexion;
    private PreparedStatement sentenciaPreparada; 
    private ResultSet resultado;
    
     public ArrayList<Pais> TraerNombresPaises() 
    {
        ArrayList<Pais> elementos = new ArrayList<>();
        try 
        {
            conexion = getConnection();
            String SQL = "SELECT CodigoPais, Nombre_Pais FROM users_2023.paises_sistema_firmas;";
            sentenciaPreparada = conexion.prepareStatement(SQL);
            resultado = sentenciaPreparada.executeQuery();
            while (resultado.next()) 
            {
                String CodigoPais = resultado.getString("CodigoPais");
                String NombrePais = resultado.getString("Nombre_Pais");
                                
                Pais country = new Pais(CodigoPais, NombrePais);
                
                elementos.add(country);
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
}
