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
public class DatosUsuario {
    
    //Atributos
    private String usuarioAnt;
    private String usuarioNuevo;
    private String contrasenia;
    
    public DatosUsuario(){
        
    }
    
    public DatosUsuario(String usuarioAnt, String usuarioNuevo, String contrasenia){
        this.usuarioAnt=usuarioAnt;
        this.usuarioNuevo=usuarioNuevo;
        this.contrasenia=contrasenia;
    }

    public String getUsuarioAnt() {
        return usuarioAnt;
    }

    public void setUsuarioAnt(String usuarioAnt) {
        this.usuarioAnt = usuarioAnt;
    }

    public String getUsuarioNuevo() {
        return usuarioNuevo;
    }

    public void setUsuarioNuevo(String usuarioNuevo) {
        this.usuarioNuevo = usuarioNuevo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    
}
