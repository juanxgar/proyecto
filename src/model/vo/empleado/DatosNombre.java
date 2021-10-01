/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo.empleado;

/**
 *
 * @author usuario
 */
public class DatosNombre {
    private String usuario;
    private String contrasenia;
    private String nombreAnt;
    private String nombreNuevo;
    
    public DatosNombre(){
        
    }
    
    DatosNombre(String usuario, String contrasenia, String nombreAnt, String nombreNuevo){
        this.usuario=usuario;
        this.contrasenia=contrasenia;
        this.nombreAnt=nombreAnt;
        this.nombreNuevo=nombreNuevo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public String getNombreAnt() {
        return nombreAnt;
    }

    public void setNombreAnt(String nombreAnt) {
        this.nombreAnt = nombreAnt;
    }

    public String getNombreNuevo() {
        return nombreNuevo;
    }

    public void setNombreNuevo(String nombreNuevo) {
        this.nombreNuevo = nombreNuevo;
    }


    
    
}
