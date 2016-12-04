/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.facitec.mec.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ConexionManager {
    private static Connection conexion;
    public static Statement stm;
    
   
    private static final String URL="jdbc:postgresql://localhost:5432/bd_taller_mecanico";
     private static final String USER="postgres";
      private static final String PASWORD="12345";
      
      public static Connection conectar(){
        try {
            Class.forName("org.postgresql.Driver");
                    } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conexion = DriverManager.getConnection(URL, USER, PASWORD);
            stm= conexion.createStatement();
                    
        } catch (SQLException ex) {
            Logger.getLogger(ConexionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
      }
    public static void desconectar(){
        if (conexion != null) {
            
            try {
                stm.close();
                 conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
         
            
        }
        
        
    }
       
    
}
