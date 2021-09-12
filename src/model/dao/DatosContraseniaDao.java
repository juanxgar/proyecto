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
import model.vo.DatosContrasenia;
import util.JDBCUtilities;

/**
 *
 * @author usuario
 */
public class DatosContraseniaDao {
    public ArrayList<DatosContrasenia> listaContrasenia(){
        
        ArrayList<DatosContrasenia> respuesta = new ArrayList<>();
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();
            
            String query = "SELECT usuario, contrasenia FROM empleado";
            
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            
            while(resultado.next()){
                DatosContrasenia consulta = new DatosContrasenia();
                consulta.setUsuario(resultado.getString(1));
                consulta.setContraseniaAnt(resultado.getString(2));
                
                respuesta.add(consulta);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la consulta " + e);
        }
        return respuesta;
    }
    
    public DatosContrasenia actualizarContrasenia(DatosContrasenia contraseniaActualizar) throws SQLException{
        DatosContrasenia contraseniaActualizada = null;
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();

            String consulta = "UPDATE empleado SET contrasenia=? "
                    + "WHERE usuario=? AND contrasenia=?";

            PreparedStatement statement = conexion.prepareStatement(consulta);

            statement.setString(1, contraseniaActualizar.getContraseniaNueva());
            statement.setString(2, contraseniaActualizar.getUsuario());
            statement.setString(3, contraseniaActualizar.getContraseniaAnt());
            
            
            //Realizar la actualización: Crear material
            statement.executeUpdate();

            //Cerrar interacciones con BD            
            statement.close();

            //Si el proceso fue exitoso cambiar el estado
            contraseniaActualizada = contraseniaActualizar;

        }catch(SQLException e){
            System.err.println("Error modificando datos de empleado! "+e);
        }finally{
            //Cierre del controlador
            if(conexion != null){
                conexion.close();
            }
        }
        return contraseniaActualizada;
    }
}
