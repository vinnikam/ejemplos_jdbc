package co.vinni.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinni
 */
public class Conexion {
    private final String url="./bd/prestamos_db.db";
    public Connection conectarse(){
        try {

            Class.forName("org.sqlite.JDBC");
            try {
                Connection connect = DriverManager.getConnection("jdbc:sqlite:"+url);
                return connect;
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    public static void main(String[] args) {
        Conexion cn = new Conexion();
        System.out.println(cn.conectarse());
        
    }
}
