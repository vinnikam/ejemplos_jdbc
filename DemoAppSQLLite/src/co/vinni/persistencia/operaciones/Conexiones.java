/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.vinni.persistencia.operaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinni
 */
public class Conexiones {
    private final String URL = "./bd/clientes_db.db";
    
    public Connection conectarse(){
        try {
            Class.forName("org.sqlite.JDBC");//DRIVER DE CONEXION
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:"+URL); //CADENA QUE IDENTIFICA LA CONEXION 
            return conexion;
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexiones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void desconectase(Connection dato){
        if (dato != null){
            try {
                dato.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexiones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
