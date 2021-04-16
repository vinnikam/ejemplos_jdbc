/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import dao.Cliente;
import utilidades.ManejadorArchivos;

/**
 *
 * @author Vinni 
 */
public class Prestamo {

    private Cliente cliente;
    private Double intereses;
    private int plazo;
    private Double valorPrestamo;
    private Boolean hayArchivo;

    public Prestamo(Cliente cliente, int plazo, Double valorPrestamo){
        this.cliente = cliente;
        this.plazo = plazo;
        this.valorPrestamo = valorPrestamo;
        this.cargarInteres();
    }
    
    public Cliente obtenerCliente() {
        return cliente;
    }

    public Double obtenerIntereses() {
        return intereses;
    }

    public int obtenerPlazo() {
        return plazo;
    }
    

    public Double obtenerValorPrestamo() {
        return valorPrestamo;
    }

    
    public Double hacerSimulacion(){
        this.hayArchivo = false;
        if (this.cliente.esCandidato()){
            Double rta = (valorPrestamo/plazo)*intereses;
            if(ManejadorArchivos.guardar(this, rta)){
                this.hayArchivo = true;
            }
            return rta;
        }
        return null;
    }
    public Double[] hacerSimulacionD(){
        Double[] d = new Double[2];
        d[1]=0D;
        if (this.cliente.esCandidato()){
            Double rta = (valorPrestamo/plazo)*intereses;
            d[0]=rta;
            if (ManejadorArchivos.guardar(this, rta)){
                d[1]=1D;    
            }
            return d;
        }
        return null;
    }
    public boolean hayArchivo(){
        return this.hayArchivo;
    }
    private void cargarInteres() {
       
        if(plazo == 12){
            intereses = 0.015;
        }
        if(plazo == 24){
            intereses = 0.012;
        }
        if(plazo == 36){
            intereses = 0.09;
        }

    }
}
