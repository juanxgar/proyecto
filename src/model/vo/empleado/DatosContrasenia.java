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
public class DatosContrasenia {
    private String usuario;
    private String contraseniaAnt;
    private String contraseniaNueva;
    
    public DatosContrasenia(){
        
    }
    
    DatosContrasenia(String usuario, String contraseniaAnt, String contraseniaNueva){
        this.usuario=usuario;
        this.contraseniaAnt=contraseniaAnt;
        this.contraseniaNueva=contraseniaNueva;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseniaAnt() {
        return contraseniaAnt;
    }

    public void setContraseniaAnt(String contraseniaAnt) {
        this.contraseniaAnt = contraseniaAnt;
    }

    public String getContraseniaNueva() {
        return contraseniaNueva;
    }

    public void setContraseniaNueva(String contraseniaNueva) {
        this.contraseniaNueva = contraseniaNueva;
    }
    
    
    
}
