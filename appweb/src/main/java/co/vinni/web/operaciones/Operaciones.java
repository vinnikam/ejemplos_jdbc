/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.vinni.web.operaciones;

import co.vinni.web.dto.Cliente;
import java.util.List;

/**
 *
 * @author Vinni
 */
public interface Operaciones<T> {
    public boolean registrar(T dato);
    public boolean modificar(T dato);
    public boolean borrar(T dato);
    public Cliente consultar(T  pk);
    public List<T> consultarT();
    
}