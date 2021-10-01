package model.dao.empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.vo.empleado.DatosUsuario;
import util.JDBCUtilities;

/**
 *Clase para actualizar usuario de empleado en la base de datos
 * @author Juan Diego Garcia
 */
public class DatosUsuarioDao {
    
    /**
     * Metodo para enlistar los atributos de la base de datos necesarios para las validaciones y realizar la actualizacion
     * @return DatosUsuario objeto de este tipo con los datos para hacer la actualizacion
     * @throws SQLException 
     */
    public ArrayList<DatosUsuario> listaUsuario() throws SQLException{
        
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
        }finally{
            //Cierre del controlador
            if(conexion != null){
                conexion.close();
            }
        }
        return respuesta;
    }
    
    /**
     * Metodo que valida si el usuario ya esta registrado en la base de datos para no repetir usuario y que sea unico
     * @param usuarioExiste recibe el nombre a validar
     * @return un entero entre 0 y 1 donde 1 existe y 0 no existe
     * @throws SQLException 
     */
    public int existeUsuario(String usuarioExiste) throws SQLException{
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();

            String consulta = "SELECT count(id_empleado) FROM empleado "
                    + "WHERE usuario=?";

            PreparedStatement statement = conexion.prepareStatement(consulta);

            statement.setString(1, usuarioExiste);
            
            
            //Realizar la actualización: Crear material
            ResultSet resultado = statement.executeQuery();

            if(resultado.next()){
                return resultado.getInt(1);
            }
            return 1;

        }catch(SQLException e){
            System.err.println("Error modificando datos de empleado! "+e);
            return 1;
        }finally{
            //Cierre del controlador
            if(conexion != null){
                conexion.close();
            }
        }
    }
    
    /**
     * Permite hacer la actualizacion del usuario en la base de datos
     * @param usuarioActualizar con los datos a validar
     * @return DatosUsuario objeto de este tipo
     * @throws SQLException 
     */
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
