/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Vinni 
 */
public class Cliente {
    private String nombre;
    private Date fechaNac;
    
    public Cliente(String nombre, Date fechaNac){
        this.nombre = nombre;
        this.fechaNac = fechaNac;
    }
    
    public String obtenerNombre(){
        return nombre;
    }
    
    public void modificarNombre(String nombre){
        this.nombre = nombre;
    }
    public Date obtenerFechaNac(){
        return fechaNac;
    }
    public void modificarFechaNac(Date fechaNac){
        this.fechaNac = fechaNac;
    }    

    @Override
    public String toString() {
        return this.nombre+ " "+this.fechaNac;
    }
    private int saberEdad(){
        Calendar fechaNacC = Calendar.getInstance();
        fechaNacC.setTime(fechaNac);
        LocalDate fNc = LocalDate.of(
                fechaNacC.get(Calendar.YEAR), 
                fechaNacC.get(Calendar.MONTH)+1, 
                fechaNacC.get(Calendar.DATE));
        Period edad = Period.between(fNc, LocalDate.now());
        return edad.getYears();
        
    }
    public boolean esCandidato(){
        int edad = this.saberEdad();
        if (edad >= 18 ){
            return true;
        }
        return false; 
                
    }
}
