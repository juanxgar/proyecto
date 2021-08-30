/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import model.dao.DatosEmpleadosDao;
import model.dao.DatosUsuarioDao;
import model.vo.DatosEmpleados;
import model.vo.DatosUsuario;
import view.ConsultaEmpleadosGUI;
import view.ModificacionEmpleadosGUI;
import view.RegistroEmpleadosGUI;
/**
 *
 * @author usuario
 */
public class Controlador {
    
    //Atributos objetos del modelo
    private final DatosEmpleadosDao datosEmpleadosDao;
    private final DatosUsuarioDao datosUsuarioDao;
    
    //Atributos vista o interfaz
    private final ConsultaEmpleadosGUI consultaEmpleadosGUI;
    private ModificacionEmpleadosGUI modificacionEmpleadosGUI;
    private RegistroEmpleadosGUI registroEmpleadosGUI;
    
    public Controlador(){
        this.datosEmpleadosDao = new DatosEmpleadosDao();
        this.datosUsuarioDao = new DatosUsuarioDao();
        
        //Instanciar la interfaz principal
        this.consultaEmpleadosGUI = new ConsultaEmpleadosGUI();
    }
    
    public ArrayList<DatosEmpleados> datosEmpleados() throws SQLException{
        return this.datosEmpleadosDao.listaEmpleados();
    }
    
    public ArrayList<DatosUsuario> datosUsuario() throws SQLException{
        return this.datosUsuarioDao.listaUsuario();
    }
    
    public void iniciarAplicacion(){
        consultaEmpleadosGUI.setVisible(true);
    }
}