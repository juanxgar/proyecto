/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class JDBCUtilities {
    //Elementos definidos globalmente para realizar la conexion con la BD con PsotreSQL
    private Connection conexion=null;
    private String url="jdbc:postgresql://chunee.db.elephantsql.com:5432/xywjwanf";
    private String usuario="xywjwanf";
    private String contrasenia="uav6t-Ve3xwV8mfk-p0VavIeen_sZNMS";

    
    /**
     * Se hace la conexion con la base de datos de Postgresql con su respectivo
     * try catch
     * @return La conexion a la BD con PostgreSQL
     * @throws java.sql.SQLException
     */
    public Connection getConnection() throws SQLException{
        try{
            Class.forName("org.postgresql.Driver");
            conexion =DriverManager.getConnection(url, usuario, contrasenia);
        }catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Error al conectar "+e);
        }
        return conexion;
    }
    
    
    /**
     * Metodo para cerrar la conexion con la BD
     * @throws SQLException 
     */
    public void cerrar() throws SQLException{
        conexion.close();
    }
}
