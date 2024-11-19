package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private static final String url= "jdbc:mysql://sql5.freesqldatabase.com:3306/sql5745830";
    private static final String username= "sql5745830";
    private static final String password= "WapzC8LGpm";
    
    public static Connection getConexion(){
        Connection con= null;
        
        try{
            con= DriverManager.getConnection(url, username, password);
        }catch(SQLException e){
            System.err.println(e);
        }
        return con;
    }
}
