/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.vinni.dto;

/**
 *
 * @author Vinni
 */
public class Cliente {
    private String nombre;
    private String apellido;
    private Long telefono;
    
    public String obtNombre(){
        return nombre;
    }
    public String obtApellido(){
        return apellido;
    }
    public Long obtTelefono(){
        return telefono;
    }
    public void modNombre(String  nombre){
        this.nombre = nombre;
    }
    public void modApellido(String apellido){
        this.apellido = apellido;
    }
    public void modTelefono(Long telefono){
        this.telefono = telefono;
    }    
    
}
