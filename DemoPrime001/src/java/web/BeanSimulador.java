/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.Cliente;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import logica.Prestamo;

/**
 *
 * @author Vinni
 */
@ManagedBean
@RequestScoped
public class BeanSimulador {

    private String nombre;
    private String fecha;
    private String valor;
    private String plazo;
    private String cuota;
    
    public BeanSimulador() {
        this.fecha = "01/01/2021";
        this.plazo = "0";
        this.valor = "0";
        this.cuota = "0";
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public String getCuota() {
        return cuota;
    }

    public void setCuota(String cuota) {
        this.cuota = cuota;
    }

    

    public void calcular() {
        System.out.println("Ingreso");
        Date fechaX = null;
        if (fecha == null && fecha.isEmpty()) {

            return;
        } else {
            SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
            try {
                fechaX = sd.parse(fecha);
            } catch (ParseException ex) {

            }

        }
        int plazoN = Integer.parseInt(plazo);
        Double valorN = Double.parseDouble(valor);
        Cliente elCliente = new Cliente(nombre, fechaX);

        Prestamo pre = new Prestamo(elCliente, plazoN, valorN);
        Double res = pre.hacerSimulacion();
        if (res != null){
            this.cuota = "" + res.intValue();
        }else{
            this.cuota = "" ;
        }
        System.out.println(""+this.cuota);
    }
}
