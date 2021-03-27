package co.vinni.persistencia.operaciones;

import co.vinni.persistencia.dto.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinni
 */
public class ImpOperacionesCliente implements OperacionesCliente{
    @Override
    public boolean registrar(Cliente dato){
        Conexiones cons =new Conexiones();
        
        if (dato == null || dato.obtNombre()== null || dato.obtApellido()== null || dato.obtTelefono() == null){
            return false;
        }
        Connection cnactiva = cons.conectarse();
        if (cnactiva != null){
            String sql = "insert into Clientes (nombre, apellido,telefono) values (?, ?, ?)";
            try {
                PreparedStatement prep = cnactiva.prepareStatement(sql);
                
                prep.setLong(3, dato.obtTelefono());
                prep.setString(2, dato.obtApellido());
                prep.setString(1, dato.obtNombre());
                
                if (prep.executeUpdate()>0)
                {
                    return true;
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ImpOperacionesCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
        }
        
        return false;
    }
    @Override
    public boolean modificar(Cliente dato){
        Conexiones cons =new Conexiones();
        Connection cnactiva = cons.conectarse();
        if (cnactiva != null){
            
        }
        return false;
    }
    @Override
    public boolean borrar(Cliente dato){
        Conexiones cons =new Conexiones();
        Connection cnactiva = cons.conectarse();
        if (cnactiva != null){
            
        }
        return false;
    }
    @Override
    public Cliente consultar(Long  pk){
        Conexiones cons =new Conexiones();
        Connection cnactiva = cons.conectarse();
        if (cnactiva != null){
            
        }
        return null;
    }
    @Override
    public List<Cliente> consultarT(){
        Conexiones cons =new Conexiones();
        Connection cnactiva = cons.conectarse();
        if (cnactiva != null){
            
        }
        return null;
    }  
    
}
