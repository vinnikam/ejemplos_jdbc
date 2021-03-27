/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.vinni.appdesktop;

import co.vinni.dto.Cliente;
import co.vinni.operaciones.Conexiones;
import co.vinni.operaciones.OperCliente;
import com.github.javafaker.Faker;
import java.sql.Connection;
import java.util.Locale;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
        Assertions.assertNotNull(conx);
        
    }
    @Test
    public void testcrearCliente(){
        Cliente cli = new Cliente();
        cli.modNombre(faker.name().firstName());
        cli.modApellido(faker.name().lastName());
        cli.modTelefono(faker.number().numberBetween(1000000L, 9999999));
        OperCliente oper = new OperCliente();
        boolean rta = oper.registrar(cli);
        Assertions.assertTrue(rta);
    }
    @Test
    public void testcrearClienteVacios(){
        Cliente cli = new Cliente();
        OperCliente oper = new OperCliente();
        boolean rta = oper.registrar(cli);
        Assertions.assertFalse(rta);
    }
    @Test
    public void testcrearClienteNull(){
        OperCliente oper = new OperCliente();
        boolean rta = oper.registrar(null);
        Assertions.assertFalse(rta);
    }   
}
