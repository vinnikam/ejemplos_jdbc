/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Prestamo;

/**
 *
 * @author Vinni
 */
public class ManejadorArchivos {
    
    private static final String archivo = "PrestamsosVinni.ubc";
    //Fecha :  nombre / candidato / valor solicitado / tasa / cuota
    public static boolean guardar(Prestamo p, Double valorCuota){
        
        File f = new File (".", archivo);
        try {
            FileWriter fw = new FileWriter(f, true);
            BufferedWriter br = new BufferedWriter(fw);
            Date d= new Date();
            if (!f.exists()){
                br.write(" Fecha \t\t Nombre \t\t  Candidato \t  valor \t tasa \t cuota\n");
            }
            br.write(" "+UtilidadesVarias.formateoFechaHoy()+"\t"+
                    p.obtenerCliente().obtenerNombre()+"\t"+
                    p.obtenerCliente().esCandidato()+"\t"+
                    p.obtenerValorPrestamo().toString()+"\t"+
                    p.obtenerIntereses().toString()+"\t"+
                    valorCuota.toString()+"\n");
            br.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ManejadorArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
}
