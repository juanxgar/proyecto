package controller;

import java.util.ArrayList;
import model.dao.DatosEmpleadosDao;
import model.vo.DatosEmpleados;
import view.ConsultaEmpleadosGUI;
/**
 *Clase donde se crean casos de uso y se inicializa la applicación
 * @author Juan Diego
 */
public class Controlador{
    
    private final DatosEmpleados datosEmpleados;
    //Atributos objetos del modelo
    private final DatosEmpleadosDao datosEmpleadosDao;
    
    //Atributos vista o interfaz
    private final ConsultaEmpleadosGUI consultaEmpleadosGUI;
    
    
    public Controlador(){
        this.datosEmpleados = new DatosEmpleados();
        this.datosEmpleadosDao = new DatosEmpleadosDao();
        this.consultaEmpleadosGUI = new ConsultaEmpleadosGUI();
    }
    
    
    /**
     * Este metodo retorna casos de uso de la clase Empleados junto con la base de datos
     * @return datosEmpleadosDao retorna lista de empleados
     */
    //Cada requerimiento solicitado -> Casos de uso
    public ArrayList<DatosEmpleados> consultarDatosEmpleados(){
        return this.datosEmpleadosDao.listaEmpleados();
    }
    
    /**
     * Se inicializa el programa
     */
    public void iniciarAplicacion(){
        consultaEmpleadosGUI.setVisible(true);
    }  
}