/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.vinni.test;

import co.vinni.persistencia.dto.Cliente;
import co.vinni.persistencia.operaciones.Conexiones;
import co.vinni.persistencia.operaciones.ImpOperacionesCliente;
import com.github.javafaker.Faker;
import java.sql.Connection;
import java.util.Locale;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vinni
 */
public class ClienteTest {
    Faker faker = new Faker(new Locale("en-US"));
    @Test
    public void testpruebaConexion(){
        Conexiones c = new Conexiones();
        Connection conx = c.conectarse();
        assertNotNull(conx);
        
    }
    @Test
    public void testcrearCliente(){
        Cliente cli = new Cliente();
        cli.modNombre(faker.name().firstName());
        cli.modApellido(faker.name().lastName());
        cli.modTelefono(faker.number().numberBetween(1000000L, 9999999));
        ImpOperacionesCliente oper = new ImpOperacionesCliente();
        boolean rta = oper.registrar(cli);
        assertTrue(rta);
    }
    @Test
    public void testcrearClienteVacios(){
        Cliente cli = new Cliente();
        ImpOperacionesCliente oper = new ImpOperacionesCliente();
        boolean rta = oper.registrar(cli);
        assertFalse(rta);
    }
    @Test
    public void testcrearClienteNull(){
        ImpOperacionesCliente oper = new ImpOperacionesCliente();
        boolean rta = oper.registrar(null);
        assertFalse(rta);
    }
    
    
    
}
