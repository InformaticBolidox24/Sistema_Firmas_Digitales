/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author andre
 */
public class Conexion_BD {
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/users_2023";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "I395fo197rm169_at802@ica";
    
    private static Connection conexion;
    private static PreparedStatement sentencia; 
    private static ResultSet resultado;
    
    public static Connection getConnection() 
    {
        Connection conexion = null;
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
        } 
        catch (ClassNotFoundException | SQLException e) 
        {
            System.err.println("Error: "+e.getMessage());
        }
        return conexion;
    }

}
