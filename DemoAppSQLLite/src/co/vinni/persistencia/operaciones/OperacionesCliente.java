/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.vinni.persistencia.operaciones;

import co.vinni.persistencia.dto.Cliente;
import java.util.List;

/**
 *
 * @author Vinni
 */
public interface OperacionesCliente {
    public boolean registrar(Cliente dato);
    public boolean modificar(Cliente dato);
    public boolean borrar(Cliente dato);
    public Cliente consultar(Long  pk);
    public List<Cliente> consultarT();
    
}
