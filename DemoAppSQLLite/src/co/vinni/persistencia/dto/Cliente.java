package co.vinni.persistencia.dto;

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
