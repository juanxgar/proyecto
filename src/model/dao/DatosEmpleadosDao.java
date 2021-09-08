/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.vo.DatosEmpleados;
import util.JDBCUtilities;

/**
 *
 * @author usuario
 */
public class DatosEmpleadosDao {
    
    public ArrayList<DatosEmpleados> listaEmpleados(){
        
        ArrayList<DatosEmpleados> respuesta = new ArrayList<>();
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();
            
            String query = "SELECT usuario, nombre, num_cedula, "
                + "telefono, direccion, ciudad, cargo, id_sede"
                + " FROM empleado"
                    + " WHERE estado=true";
            
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            
            while(resultado.next()){
                DatosEmpleados consulta = new DatosEmpleados();
                consulta.setUsuario(resultado.getString(1));
                consulta.setNombre(resultado.getString(2));
                consulta.setNum_cedula(resultado.getString(3));
                consulta.setTelefono(resultado.getString(4));
                consulta.setDireccion(resultado.getString(5));
                consulta.setCiudad(resultado.getString(6));
                consulta.setCargo(resultado.getString(7));
                consulta.setId_sede(Integer.toString(resultado.getInt(8)));
                
                respuesta.add(consulta);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la consulta " + e);
        }
        return respuesta;
    }
    
    public DatosEmpleados registrarEmpleado(DatosEmpleados nuevoEmpleado) throws SQLException{
        DatosEmpleados empleadoRegistrado = null;
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();

            String consulta = "INSERT INTO empleado(usuario, contrasenia, "
                    + "nombre, num_cedula, telefono, direccion, "
                    + "ciudad, cargo, id_sede) "
                    + "VALUES(?,?,?,?,?,?,?,?,?)";

            PreparedStatement statement = conexion.prepareStatement(consulta);

            statement.setString(1, nuevoEmpleado.getUsuario());
            statement.setString(2, nuevoEmpleado.getContrasenia());
            statement.setString(3, nuevoEmpleado.getNombre());
            statement.setString(4, nuevoEmpleado.getNum_cedula());
            statement.setString(5, nuevoEmpleado.getTelefono());
            statement.setString(6, nuevoEmpleado.getDireccion());
            statement.setString(7, nuevoEmpleado.getCiudad());
            statement.setString(8, nuevoEmpleado.getCargo());
            statement.setInt(9, (int) Integer.parseInt((String)nuevoEmpleado.getId_sede()));
            

            //Realizar la actualización: Crear material
            statement.executeUpdate();

            //Cerrar interacciones con BD            
            statement.close();

            //Si el proceso fue exitoso cambiar el estado
            empleadoRegistrado = nuevoEmpleado;

        }catch(SQLException e){
            System.err.println("Error registrando empleado! "+e);
        }finally{
            //Cierre del controlador
            if(conexion != null){
                conexion.close();
            }
        }

        //Retornar la instancia del material o el nulo para validaciones posteriores
        return empleadoRegistrado; 
    }
    
    public DatosEmpleados eliminarEmpleado(DatosEmpleados eliminaEmpleado) throws SQLException{
        DatosEmpleados empleadoEliminado = null;
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();

            String consulta = "UPDATE empleado SET estado=false "
                    + "WHERE usuario=?";
            

            PreparedStatement statement = conexion.prepareStatement(consulta);

            statement.setString(1, eliminaEmpleado.getUsuario());
            

            //Realizar la actualización: Crear material
            statement.executeUpdate();

            //Cerrar interacciones con BD            
            statement.close();

            //Si el proceso fue exitoso cambiar el estado
            empleadoEliminado = eliminaEmpleado;

        }catch(SQLException e){
            System.err.println("Error eliminando empleado! "+e);
        }finally{
            //Cierre del controlador
            if(conexion != null){
                conexion.close();
            }
        }

        //Retornar la instancia del material o el nulo para validaciones posteriores
        return empleadoEliminado; 
    }
}
