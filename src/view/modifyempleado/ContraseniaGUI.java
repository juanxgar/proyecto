/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.modifyempleado;

import view.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.dao.empleado.DatosContraseniaDao;
import model.vo.empleado.DatosContrasenia;

/**
 *
 * @author usuario
 */
public class ContraseniaGUI extends javax.swing.JFrame {

    //Atributos
    
    /**
     * Creates new form ConsultaEmpleadosGUI
     */
    public ContraseniaGUI(){
        initComponents();
        
        //No olvidar agregar esto para agregarle las animaciones
        this.setLocationRelativeTo(null);
        this.setTitle("Empleados");
        this.setResizable(false);
        
        
    }

    public JPasswordField getTfContraseniaAnt() {
        return tfContraseniaAnt;
    }

    public void setTfContraseniaAnt(JPasswordField tfContraseniaAnt) {
        this.tfContraseniaAnt = tfContraseniaAnt;
    }

    public JPasswordField getTfContraseniaNueva() {
        return tfContraseniaNueva;
    }

    public void setTfContraseniaNueva(JPasswordField tfContraseniaNueva) {
        this.tfContraseniaNueva = tfContraseniaNueva;
    }

    public JPasswordField getTfContraseniaNueva2() {
        return tfContraseniaNueva2;
    }

    public void setTfContraseniaNueva2(JPasswordField tfContraseniaNueva2) {
        this.tfContraseniaNueva2 = tfContraseniaNueva2;
    }

    public JTextField getTfUsuario() {
        return tfUsuario;
    }

    public void setTfUsuario(JTextField tfUsuario) {
        this.tfUsuario = tfUsuario;
    }

    
    
    public void actualizarContrasenia(){
        //Se crea un objeto de este tipo debido a que alli se encuentra el metodo que obtiene la lista de elementos de tipo consulta empleados
        DatosContraseniaDao c = new DatosContraseniaDao();
        
        //Este objeto es el que tiene los datos de la base de datos, los metodos para obtener dichos valores
        ArrayList<DatosContrasenia> lista = c.listaContrasenia();
        
        //El objeto se covierte a un arreglo usando el metodo de esta clase el cual recibe el arraylist del tipo consultaEmpleados y el numero de columnas
        String[][] lista2 = formatoRegistros(lista, 3);
        
        String usuario="";
        String contraseniaAnt="";
        
        for(int i = 0; i<lista.size(); i++){
            
            if(lista2[i][0].equals(getTfUsuario().getText())){
                usuario=lista2[i][0];
            }
            if(lista2[i][1].equals(getTfContraseniaAnt().getText())){
                contraseniaAnt=lista2[i][1];
            }
        }
            
        if(usuario.equals(getTfUsuario().getText())){
            if(contraseniaAnt.equals(getTfContraseniaAnt().getText())){
                if(!getTfContraseniaAnt().getText().equals(getTfContraseniaNueva().getText())){
                    if(getTfContraseniaNueva().getText().equals(getTfContraseniaNueva2().getText())){
                        try {
                            DatosContrasenia contraseniaActualizar = new DatosContrasenia();

                            contraseniaActualizar.setContraseniaNueva(getTfContraseniaNueva().getText());
                            contraseniaActualizar.setUsuario(getTfUsuario().getText());
                            contraseniaActualizar.setContraseniaAnt(getTfContraseniaAnt().getText());

                            DatosContrasenia contraseniaActualizado =null;
                            DatosContraseniaDao d = new DatosContraseniaDao();

                            contraseniaActualizado = d.actualizarContrasenia(contraseniaActualizar);

                            if(contraseniaActualizado != null){
                                JOptionPane.showMessageDialog(null, "La contraseña del empleado se actualizó correctamente");
                                this.setVisible(false);
                                ModificacionEmpleadosGUI modificacion = new ModificacionEmpleadosGUI();
                                modificacion.setVisible(true);
                                
                            }else{
                                JOptionPane.showMessageDialog(null, "No se completó la actualización de datos");
                            }
                        }catch (SQLException ex) {
                            Logger.getLogger(ContraseniaGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Las contraseñas nuevas no son iguales");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "La nueva contraseña no puede ser igual a la anterior");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Contraseña antererior no valida");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Verifique el nombre de usuario");
        }
    }
    
    
    public String[][] formatoRegistros(ArrayList<DatosContrasenia> consulta, int numeroColumnas){
        
        //Declaración del contenedor de retorno
        String[][] registros = new String[consulta.size()][numeroColumnas];        
        

        //Desenvolver los objetos de la colección
        for (int i = 0; i < consulta.size(); i++) {
            registros[i][0] = consulta.get(i).getUsuario();
            registros[i][1] = consulta.get(i).getContraseniaAnt();
            registros[i][2] = consulta.get(i).getContraseniaNueva();   
        }

        //Retornar registros en formato JTable
        return registros;

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
        tfContraseniaNueva2 = new javax.swing.JPasswordField();
        titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        tfContraseniaNueva = new javax.swing.JPasswordField();
        tfContraseniaAnt = new javax.swing.JPasswordField();
        jLabel18 = new javax.swing.JLabel();

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
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, -1, -1));

        jLabel17.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(238, 112, 82));
        jLabel17.setText("Repita la nueva Contraseña: ");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, -1, -1));

        tfUsuario.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfUsuario.setForeground(new java.awt.Color(153, 153, 153));
        tfUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 170, 25));

        jLabel21.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(238, 112, 82));
        jLabel21.setText("Contraseña anterior:");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, -1, -1));

        tfContraseniaNueva2.setForeground(new java.awt.Color(153, 153, 153));
        tfContraseniaNueva2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfContraseniaNueva2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContraseniaNueva2ActionPerformed(evt);
            }
        });
        jPanel2.add(tfContraseniaNueva2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 170, 25));

        titulo.setFont(new java.awt.Font("Decker", 1, 28)); // NOI18N
        titulo.setForeground(new java.awt.Color(238, 112, 82));
        titulo.setText("CAMBIANDO CONTRASEÑA EMPLEADO");
        jPanel2.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 550, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Back_64px.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 50, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/team_96px.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        btnRegistrar.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/accept-circular-button-outline.png"))); // NOI18N
        btnRegistrar.setText("Guardar Cambios");
        btnRegistrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, 200, 50));

        tfContraseniaNueva.setForeground(new java.awt.Color(153, 153, 153));
        tfContraseniaNueva.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfContraseniaNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContraseniaNuevaActionPerformed(evt);
            }
        });
        jPanel2.add(tfContraseniaNueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 170, 25));

        tfContraseniaAnt.setForeground(new java.awt.Color(153, 153, 153));
        tfContraseniaAnt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfContraseniaAnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContraseniaAntActionPerformed(evt);
            }
        });
        jPanel2.add(tfContraseniaAnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 170, 25));

        jLabel18.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(238, 112, 82));
        jLabel18.setText("Nueva contraseña: ");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 530));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        actualizarContrasenia();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        ModificacionEmpleadosGUI consulta = new ModificacionEmpleadosGUI();
        consulta.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void tfContraseniaNueva2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfContraseniaNueva2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfContraseniaNueva2ActionPerformed

    private void tfContraseniaNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfContraseniaNuevaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfContraseniaNuevaActionPerformed

    private void tfContraseniaAntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfContraseniaAntActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfContraseniaAntActionPerformed

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
            java.util.logging.Logger.getLogger(ContraseniaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContraseniaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContraseniaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContraseniaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContraseniaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JPasswordField tfContraseniaAnt;
    private javax.swing.JPasswordField tfContraseniaNueva;
    private javax.swing.JPasswordField tfContraseniaNueva2;
    private javax.swing.JTextField tfUsuario;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
