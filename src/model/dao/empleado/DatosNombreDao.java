package model.dao.empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.vo.empleado.DatosNombre;
import util.JDBCUtilities;

/**
 *Clase para hacer consultas en la base de datos para modificacion de nombre de empleado
 * @author Juan Diego Garcia
 */
public class DatosNombreDao {
    
    /**
     * Enlista los atributos de la base de datos pero solo los necesarios para hacer la actualizacion de nombre de empleado
     * @return ArrayList de tipo objeto DatosNombre
     */
    public ArrayList<DatosNombre> listaNombre(){
        
        ArrayList<DatosNombre> respuesta = new ArrayList<>();
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();
            
            String query = "SELECT usuario, contrasenia, nombre"
                + " FROM empleado"
                    + " WHERE estado=true";
            
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            
            while(resultado.next()){
                DatosNombre consulta = new DatosNombre();
                consulta.setUsuario(resultado.getString(1));
                consulta.setContrasenia(resultado.getString(2));
                consulta.setNombreAnt(resultado.getString(3));
                
                respuesta.add(consulta);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la consulta " + e);
        }
        return respuesta;
    }
    
    /**
     * Actualiza el nombre del empleado en la base de datos
     * @param nombreEmpleado de tipo DatosNombre
     * @return DatosNombre objeto de este tipo
     * @throws SQLException 
     */
    public DatosNombre actualizarNombre(DatosNombre nombreEmpleado) throws SQLException{
        DatosNombre empleadoNombre = null;
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();

            String consulta = "UPDATE empleado SET nombre=? "
                    + "WHERE usuario=? and contrasenia=?";
            

            PreparedStatement statement = conexion.prepareStatement(consulta);
            
            statement.setString(1, nombreEmpleado.getNombreNuevo());
            statement.setString(2, nombreEmpleado.getUsuario());
            statement.setString(3, nombreEmpleado.getContrasenia());
 
            statement.executeUpdate();

            //Cerrar interacciones con BD            
            statement.close();

            //Si el proceso fue exitoso cambiar el estado
            empleadoNombre = nombreEmpleado;

        }catch(SQLException e){
            System.err.println("Error actualizando nombre empleado! "+e);
        }finally{
            //Cierre del controlador
            if(conexion != null){
                conexion.close();
            }
        }
        return empleadoNombre; 
    }
}
