package view.modifyempleado;

import view.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.dao.empleado.DatosNombreDao;
import model.vo.empleado.DatosNombre;

/**
 *Esta clase nos muestra la interfaz para cambiar el nombre de un empleado
 * @author Juan Diego Garcia
 */
public class NombreGUI extends javax.swing.JFrame {

    //Atributos
    
    /**
     * Se crea nueva new form ConsultaEmpleadosGUI
     */
    public NombreGUI(){
        initComponents();
        
        //No olvidar agregar esto para agregarle las animaciones
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Empleados");
        
        
    }   
    
    public void actualizarNombre() throws SQLException{
        //Se crea un objeto de este tipo debido a que alli se encuentra el metodo que obtiene la lista de elementos de tipo consulta empleados
        DatosNombreDao c = new DatosNombreDao();
        
        //Este objeto es el que tiene los datos de la base de datos, los metodos para obtener dichos valores
        ArrayList<DatosNombre> lista = c.listaNombre();
        
        
        //El objeto se covierte a un arreglo usando el metodo de esta clase el cual recibe el arraylist del tipo consultaEmpleados y el numero de columnas
        String[][] lista2 = formatoRegistros(lista, 3);
        
        String usuario="";
        String contrasenia="";
        String nombreAnt="";
        
        for(int i = 0; i<lista.size(); i++){
            System.out.println(lista2[i][2]);
            
            if(lista2[i][0].equals(getTfUsuario().getText())){
                usuario=lista2[i][0];
                contrasenia=lista2[i][1];
                nombreAnt=lista2[i][2];
            }
        }
        System.out.print("Nombre: "+nombreAnt);
        if(getTfUsuario().getText().length()!=0
                && getTfContrasenia().getText().length()!=0
                && getTfNombreNuevo().getText().length()!=0){
            if(usuario.equals(getTfUsuario().getText())){
                if(contrasenia.equals(getTfContrasenia().getText())){
                    if(!nombreAnt.equals(getTfNombreNuevo().getText())){
                        try {
                            DatosNombre nombreActualizar = new DatosNombre();

                            nombreActualizar.setUsuario(getTfUsuario().getText());
                            nombreActualizar.setContrasenia(getTfContrasenia().getText());
                            nombreActualizar.setNombreNuevo(getTfNombreNuevo().getText());

                            DatosNombre nombreActualizado =null;
                            DatosNombreDao d = new DatosNombreDao();

                            nombreActualizado = d.actualizarNombre(nombreActualizar);

                            if(nombreActualizado != null){
                                JOptionPane.showMessageDialog(null, "El nombre del empleado se actualizó correctamente");
                                this.setVisible(false);
                                ModificacionEmpleadosGUI modificacion = new ModificacionEmpleadosGUI();
                                modificacion.setVisible(true);
                            }else{
                                JOptionPane.showMessageDialog(null, "No se completó la actualización de datos");
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(NombreGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "El nuevo nombre no puede ser igual al anterior");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Contraseña no valida");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Usuario Incorrecto");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Los datos no pueden estar vacios");
        }
    }
    
    
    public String[][] formatoRegistros(ArrayList<DatosNombre> consulta, int numeroColumnas){
        
        //Declaración del contenedor de retorno
        String[][] registros = new String[consulta.size()][numeroColumnas];        

        //Desenvolver los objetos de la colección
        for (int i = 0; i < consulta.size(); i++) {            
            registros[i][0] = consulta.get(i).getUsuario();
            registros[i][1] = consulta.get(i).getContrasenia();
            registros[i][2] = consulta.get(i).getNombreAnt();
        }

        //Retornar registros en formato JTable
        return registros;

    }
    
    
        public JPasswordField getTfContrasenia() {
        return tfContrasenia;
    }

    public void setTfContrasenia(JPasswordField tfContrasenia) {
        this.tfContrasenia = tfContrasenia;
    }

    public JTextField getTfNombreNuevo() {
        return tfNombreNuevo;
    }

    public void setTfNombreNuevo(JTextField tfNombreNuevo) {
        this.tfNombreNuevo = tfNombreNuevo;
    }

    public JTextField getTfUsuario() {
        return tfUsuario;
    }

    public void setTfUsuario(JTextField tfUsuario) {
        this.tfUsuario = tfUsuario;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField8 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        tfNombreNuevo = new javax.swing.JTextField();
        tfContrasenia = new javax.swing.JPasswordField();
        titulo = new javax.swing.JLabel();
        jlAtras = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        jTextField8.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(153, 153, 153));
        jTextField8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(600, 300));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(238, 112, 82));
        jLabel15.setText("Atrás");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, -1, -1));

        jLabel16.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(238, 112, 82));
        jLabel16.setText("Usuario: ");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, -1, -1));

        jLabel17.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(238, 112, 82));
        jLabel17.setText("Contraseña: ");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, -1, -1));

        tfUsuario.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfUsuario.setForeground(new java.awt.Color(153, 153, 153));
        tfUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 170, 25));

        jLabel21.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(238, 112, 82));
        jLabel21.setText("Nuevo nombre:");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, -1, -1));

        tfNombreNuevo.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfNombreNuevo.setForeground(new java.awt.Color(153, 153, 153));
        tfNombreNuevo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfNombreNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 170, 25));

        tfContrasenia.setForeground(new java.awt.Color(153, 153, 153));
        tfContrasenia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 170, 25));

        titulo.setFont(new java.awt.Font("Decker", 1, 28)); // NOI18N
        titulo.setForeground(new java.awt.Color(238, 112, 82));
        titulo.setText("CAMBIANDO NOMBRE DE EMPLEADO");
        jPanel2.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, -1));

        jlAtras.setBackground(new java.awt.Color(255, 255, 255));
        jlAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Back_64px.png"))); // NOI18N
        jlAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlAtrasMouseClicked(evt);
            }
        });
        jPanel2.add(jlAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 50, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/team_96px.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        btnModificar.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/accept-circular-button-outline.png"))); // NOI18N
        btnModificar.setText("Guardar Cambios");
        btnModificar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel2.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, 200, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 530));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            // TODO add your handling code here:
            actualizarNombre();
            //ModificacionEmpleadosGUI consulta = new ModificacionEmpleadosGUI();
            //consulta.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(NombreGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void jlAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAtrasMouseClicked
        // TODO add your handling code here:
        ModificacionEmpleadosGUI consulta = new ModificacionEmpleadosGUI();
        consulta.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jlAtrasMouseClicked

    /**
     * @param args the command line arguments
     */
    
    //Aqui en el main es importante cambiar donde dice look and feel, de Nimbus a Windows
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NombreGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NombreGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NombreGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NombreGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NombreGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JLabel jlAtras;
    private javax.swing.JPasswordField tfContrasenia;
    private javax.swing.JTextField tfNombreNuevo;
    private javax.swing.JTextField tfUsuario;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
