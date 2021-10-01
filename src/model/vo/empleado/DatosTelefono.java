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
public class DatosTelefono {
    private String usuario;
    private String contrasenia;
    private String telefonoAnt;
    private String telefonoNuevo;
    
    public DatosTelefono(){
        
    }
    
    DatosTelefono(String usuario, String contrasenia, String telefonoAnt, String telefonoNuevo){
        this.usuario=usuario;
        this.contrasenia=contrasenia;
        this.telefonoAnt=telefonoAnt;
        this.telefonoNuevo=telefonoNuevo;
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
    
    public String getTelefonoAnt() {
        return telefonoAnt;
    }

    public void setTelefonoAnt(String telefonoAnt) {
        this.telefonoAnt = telefonoAnt;
    }

    public String getTelefonoNuevo() {
        return telefonoNuevo;
    }

    public void setTelefonoNuevo(String telefonoNuevo) {
        this.telefonoNuevo = telefonoNuevo;
    }


    
    
}
