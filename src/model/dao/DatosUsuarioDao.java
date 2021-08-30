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
import model.vo.DatosUsuario;
import util.JDBCUtilities;

/**
 *
 * @author usuario
 */
public class DatosUsuarioDao {
    
    public ArrayList<DatosUsuario> listaUsuario(){
        
        ArrayList<DatosUsuario> respuesta = new ArrayList<>();
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();
            
            String query = "SELECT usuario, contrasenia FROM empleado";
            
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            
            while(resultado.next()){
                DatosUsuario consulta = new DatosUsuario();
                consulta.setUsuarioAnt(resultado.getString(1));
                consulta.setContrasenia(resultado.getString(2));
                
                respuesta.add(consulta);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la consulta " + e);
        }
        return respuesta;
    }
    
    public DatosUsuario actualizarUsuario(DatosUsuario usuarioActualizar) throws SQLException{
        DatosUsuario usuarioActualizado = null;
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();

            String consulta = "UPDATE empleado SET usuario=? "
                    + "WHERE usuario=? AND contrasenia=?";

            PreparedStatement statement = conexion.prepareStatement(consulta);

            statement.setString(1, usuarioActualizar.getUsuarioNuevo());
            statement.setString(2, usuarioActualizar.getUsuarioAnt());
            statement.setString(3, usuarioActualizar.getContrasenia());
            
            
            //Realizar la actualización: Crear material
            statement.executeUpdate();

            //Cerrar interacciones con BD            
            statement.close();

            //Si el proceso fue exitoso cambiar el estado
            usuarioActualizado = usuarioActualizar;

        }catch(SQLException e){
            System.err.println("Error modificando datos de empleado! "+e);
        }finally{
            //Cierre del controlador
            if(conexion != null){
                conexion.close();
            }
        }
        return usuarioActualizado;
    }
    
}
