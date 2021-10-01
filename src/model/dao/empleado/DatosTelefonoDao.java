package model.dao.empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.vo.empleado.DatosTelefono;
import util.JDBCUtilities;

/**
 *Clase para hacer consultas en la base de datos para modificacion de Telefono de empleado
 * @author Juan Diego Garcia
 */
public class DatosTelefonoDao {
    
    /**
     * Enlista los atributos de la base de datos pero solo los necesarios para hacer la actualizacion de telefono de empleado
     * @return ArrayList de tipo objeto DatosTelefono
     */
    public ArrayList<DatosTelefono> listaTelefono(){
        
        ArrayList<DatosTelefono> respuesta = new ArrayList<>();
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();
            
            String query = "SELECT usuario, contrasenia, telefono"
                + " FROM empleado"
                    + " WHERE estado=true";
            
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            
            while(resultado.next()){
                DatosTelefono consulta = new DatosTelefono();
                consulta.setUsuario(resultado.getString(1));
                consulta.setContrasenia(resultado.getString(2));
                consulta.setTelefonoAnt(resultado.getString(3));
                
                respuesta.add(consulta);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la consulta " + e);
        }
        return respuesta;
    }
    
    /**
     * Actualiza el Telefono del empleado en la base de datos
     * @param telefonoEmpleado de tipo DatosNombre
     * @return DatosNombre objeto de este tipo
     * @throws SQLException 
     */
    public DatosTelefono actualizarTelefono(DatosTelefono telefonoEmpleado) throws SQLException{
        DatosTelefono empleadoTelefono = null;
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();

            String consulta = "UPDATE empleado SET telefono=? "
                    + "WHERE usuario=? and contrasenia=?";
            

            PreparedStatement statement = conexion.prepareStatement(consulta);
            
            statement.setString(1, telefonoEmpleado.getTelefonoNuevo());
            statement.setString(2, telefonoEmpleado.getUsuario());
            statement.setString(3, telefonoEmpleado.getContrasenia());
 
            statement.executeUpdate();

            //Cerrar interacciones con BD            
            statement.close();

            //Si el proceso fue exitoso cambiar el estado
            empleadoTelefono = telefonoEmpleado;

        }catch(SQLException e){
            System.err.println("Error actualizando nombre empleado! "+e);
        }finally{
            //Cierre del controlador
            if(conexion != null){
                conexion.close();
            }
        }
        return empleadoTelefono; 
    }
}
