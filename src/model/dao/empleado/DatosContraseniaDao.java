package model.dao.empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.vo.empleado.DatosContrasenia;
import util.JDBCUtilities;

/**
 *Consultas a la base de datos para modificacion de la contrasenia del empleado
 * @author Juan Diego Garcia
 */
public class DatosContraseniaDao {
    
    /**
     * Permite obtener la consulta de los datos de usuario y contrasenia unicamente
     * @return ArrayList de tipo DatosContrasenia
     */
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
    
    /**
     * Permite hacer la actualizacion de la contrasenia de un empleado en la base de datos
     * @param contraseniaActualizar de tipo DatosContrasenia
     * @return DatosContrasenia objeto de este tipo
     * @throws SQLException 
     */
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
