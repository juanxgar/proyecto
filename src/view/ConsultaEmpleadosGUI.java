/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controlador;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.dao.DatosEmpleadosDao;
import model.vo.DatosEmpleados;
import view.modifyempleado.UsuarioGUI;

/**
 *
 * @author usuario
 */
public class ConsultaEmpleadosGUI extends javax.swing.JFrame {

    //Atributos
    public DefaultTableModel tEmpleados = new DefaultTableModel();
    
    /**
     * Creates new form ConsultaEmpleadosGUI
     */
    public ConsultaEmpleadosGUI(){
        initComponents();
        
        //No olvidar agregar esto para agregarle las animaciones
        this.setLocationRelativeTo(null);
        this.setTitle("Empleados");
        this.setResizable(false);
        
        mostrarEmpleados();
        
    }
    
    private void mostrarEmpleados() {
        //Se defin el table model globalmente
       
        //Se agregan las columnas de la tabla a mostrar
        tEmpleados.addColumn("Usuario");
        tEmpleados.addColumn("Nombre");
        tEmpleados.addColumn("Cédula");
        tEmpleados.addColumn("Telefono");
        tEmpleados.addColumn("Direccion");
        tEmpleados.addColumn("Ciudad");
        tEmpleados.addColumn("Cargo");
        tEmpleados.addColumn("ID sede");
        
        //Se setea el modelo
        getTableEmpleados().setModel(tEmpleados);
        
        //Se obtiene el numero de columnas
        int numColumnas=tEmpleados.getColumnCount();
        
        //Se crea un objeto de este tipo debido a que alli se encuentra el metodo que obtiene la lista de elementos de tipo consulta empleados
        DatosEmpleadosDao c = new DatosEmpleadosDao();
        
        //Este objeto es el que tiene los datos de la base de datos, los metodos para obtener dichos valores
        ArrayList<DatosEmpleados> lista = c.listaEmpleados();
        
        //El objeto se covierte a un arreglo usando el metodo de esta clase el cual recibe el arraylist del tipo consultaEmpleados y el numero de columnas
        String[][] lista2 = formatoRegistros(lista, numColumnas);
        
        //Se agregan de la lista obtenida en array los datos de la base de datos
        for(int i = 0; i<lista.size(); i++){
            tEmpleados.addRow(lista2[i]);
        }
        
        //Se vuelve a setear para agregar los elementos de la BD
        tableEmpleados.setModel(tEmpleados);
    }
    
    public void eliminarEmpleado(){
        
        DatosEmpleados empleadoEliminar = new DatosEmpleados();
        String dato=null;
        if(tableEmpleados.getSelectedRow()!=-1){
            int input = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el empleado?");
            
            if(input==0){
                dato=String.valueOf(tEmpleados.getValueAt(tableEmpleados.getSelectedRow(),0));
                tableEmpleados.getModel(); //TableProducto es el nombre de mi tabla ;)
                tEmpleados.removeRow(tableEmpleados.getSelectedRow());

                empleadoEliminar.setUsuario(dato);
                DatosEmpleados empleadoEliminado = null;
                DatosEmpleadosDao d = new DatosEmpleadosDao();

                try {
                    empleadoEliminado = d.eliminarEmpleado(empleadoEliminar);
                }catch (SQLException ex) {
                    Logger.getLogger(ConsultaEmpleadosGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione un empleado para poder eliminarlo");            
        }
    }
    
    public String[][] formatoRegistros(ArrayList<DatosEmpleados> consulta, int numeroColumnas){
        
        //Declaración del contenedor de retorno
        String[][] registros = new String[consulta.size()][numeroColumnas];        

        //Desenvolver los objetos de la colección
        for (int i = 0; i < consulta.size(); i++) {            
            registros[i][0] = consulta.get(i).getUsuario();
            registros[i][1] = consulta.get(i).getNombre();
            registros[i][2] = consulta.get(i).getNum_cedula();
            registros[i][3] = consulta.get(i).getTelefono();
            registros[i][4] = consulta.get(i).getDireccion();
            registros[i][5] = consulta.get(i).getCiudad();
            registros[i][6] = consulta.get(i).getCargo();
            registros[i][7] = consulta.get(i).getId_sede();
            
        }

        //Retornar registros en formato JTable
        return registros;

    }

    public DefaultTableModel gettEmpleados() {
        return tEmpleados;
    }

    public void settEmpleados(DefaultTableModel tEmpleados) {
        this.tEmpleados = tEmpleados;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(JButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(JButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    public JTable getTableEmpleados() {
        return tableEmpleados;
    }

    public void setTableEmpleados(JTable tableEmpleados) {
        this.tableEmpleados = tableEmpleados;
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEmpleados = new javax.swing.JTable();
        titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(600, 300));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/team_96px.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(440, 402));

        tableEmpleados.setAutoCreateRowSorter(true);
        tableEmpleados.setBackground(new java.awt.Color(255, 208, 164));
        tableEmpleados.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tableEmpleados.setForeground(new java.awt.Color(238, 112, 82));
        tableEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Usuario", "Nombre", "Cédula", "Teléfono", "Dirección", "Ciudad", "Cargo", "ID Sede"
            }
        ));
        tableEmpleados.setGridColor(new java.awt.Color(238, 112, 82));
        tableEmpleados.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tableEmpleados.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableEmpleados);
        if (tableEmpleados.getColumnModel().getColumnCount() > 0) {
            tableEmpleados.getColumnModel().getColumn(0).setResizable(false);
            tableEmpleados.getColumnModel().getColumn(1).setResizable(false);
            tableEmpleados.getColumnModel().getColumn(2).setResizable(false);
            tableEmpleados.getColumnModel().getColumn(3).setResizable(false);
            tableEmpleados.getColumnModel().getColumn(4).setResizable(false);
            tableEmpleados.getColumnModel().getColumn(5).setResizable(false);
            tableEmpleados.getColumnModel().getColumn(6).setResizable(false);
            tableEmpleados.getColumnModel().getColumn(7).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 760, 90));

        titulo.setFont(new java.awt.Font("Decker", 1, 28)); // NOI18N
        titulo.setForeground(new java.awt.Color(238, 112, 82));
        titulo.setText("INFORMACIÓN DE LOS EMPLEADOS");
        jPanel1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Back_64px.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 50, 40));

        jLabel3.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(238, 112, 82));
        jLabel3.setText("Atrás");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, -1, -1));

        btnEliminar.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar Empleado");
        btnEliminar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 200, 50));

        btnRegistrar.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnRegistrar.setText("Registrar Empleado");
        btnRegistrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 200, 50));

        btnModificar.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit-button.png"))); // NOI18N
        btnModificar.setText("Modificar Datos");
        btnModificar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 200, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        eliminarEmpleado();
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        RegistroEmpleadosGUI registro = new RegistroEmpleadosGUI();
        registro.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        ModificacionEmpleadosGUI consulta = new ModificacionEmpleadosGUI();
        consulta.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnModificarActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultaEmpleadosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaEmpleadosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaEmpleadosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaEmpleadosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaEmpleadosGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    public javax.swing.JTable tableEmpleados;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
