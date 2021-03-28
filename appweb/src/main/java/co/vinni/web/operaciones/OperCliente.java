/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.vinni.web.operaciones;

import co.vinni.web.dto.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

/**
 *
 * @author Vinni
 */
public class OperCliente implements Operaciones<Cliente>{
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public boolean registrar(Cliente dato) {
        String sql = "insert into Clientes (nombre, apellido,telefono) values (?, ?, ?)";
        jdbcTemplate.execute(sql, (PreparedStatement ps) -> {
            ps.setLong(3, dato.obtTelefono());
            ps.setString(2, dato.obtApellido());
            ps.setString(1, dato.obtNombre());
            return ps.execute();  
        });  
        
        
        return false;
    }

    @Override
    public boolean modificar(Cliente dato) {
        Conexiones cons =new Conexiones();
        Connection cnactiva = cons.conectarse();
        if (cnactiva != null){
            
        }
        return false;
    }

    @Override
    public boolean borrar(Cliente dato) {
        Conexiones cons =new Conexiones();
        Connection cnactiva = cons.conectarse();
        if (cnactiva != null){
            
        }
        return false;
    }

    @Override
    public Cliente consultar(Cliente pk) {
        Conexiones cons =new Conexiones();
        Connection cnactiva = cons.conectarse();
        if (cnactiva != null){
            
        }
        return null;
    }

    @Override
    public List<Cliente> consultarT() {
        Conexiones cons =new Conexiones();
        Connection cnactiva = cons.conectarse();
        if (cnactiva != null){
            
        }
        return null;
    }
    
    
}
