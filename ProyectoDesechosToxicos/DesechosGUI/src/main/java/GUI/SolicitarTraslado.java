/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import daos.IResiduoDAO;
import daos.ISolicitudTrasladoDAO;
import daos.ResiduoDAO;
import daos.SolicitudTrasladoDAO;
import entidades.Destino;
import entidades.EmpresaTransportista;
import entidades.Residuo;
import entidades.SolicitudTraslado;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author luis
 */
public class SolicitarTraslado extends javax.swing.JFrame {

    IResiduoDAO residuoDAO = new ResiduoDAO();
    ISolicitudTrasladoDAO solicitudTrasladoDAO = new SolicitudTrasladoDAO();

    /**
     * Creates new form SolicitarTraslado
     */
    public SolicitarTraslado() {
        initComponents();
        DefaultListModel<String> modelDisponibles = new DefaultListModel<String>();
        DefaultListModel<String> modelSeleccionados = new DefaultListModel<String>();

        listResiduosDisponibles.setModel(modelDisponibles);
        listResiduosSeleccionados.setModel(modelSeleccionados);

        //Se guardan los residuos en un arrayList 
        ArrayList residuos = obtenerResiduosExistentes();

        for (int i = 0; i < residuos.size(); i++) {
            modelDisponibles.addElement(residuos.get(i).toString());
        }

    }

    public void guardarSolicitudTraslado() {

        LocalDate fechaSeleccionada = this.trasladoDatePicker.getSelectedDate();
        //Residuo residuoTraslado = new Residuo();
        float cantidadResiduo = Float.valueOf(this.txtCantidad.getText());
        boolean asingado = false;
        Destino destino = new Destino(this.cbDestino.getSelectedItem().toString());
        String codigo = this.codigoTxt.getText();

        SolicitudTraslado solicitudTraslado = null;
        try {

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al recuperar residuos");
        }

        try {
            solicitudTraslado = new SolicitudTraslado(codigo, obtenerResiduosSeleccionados(), fechaSeleccionada, cantidadResiduo, asingado, destino, null);
            solicitudTrasladoDAO.guardar(solicitudTraslado);
            JOptionPane.showMessageDialog(null, "Se guardó exitosamente su solicitud");

        } catch (Exception e) {

        }

    }

    private void seleccionarQuimico() {

        this.listResiduosDisponibles.remove(this);
        DefaultListModel<String> modelQ = (DefaultListModel<String>) listResiduosDisponibles.getModel();
        DefaultListModel<String> modelR = (DefaultListModel<String>) listResiduosSeleccionados.getModel();
        String selectedValue = listResiduosDisponibles.getSelectedValue();
        modelQ.removeElement(selectedValue);
        listResiduosSeleccionados.repaint();
        modelR.addElement(selectedValue);
    }

    private void eliminarQuimico() {

        DefaultListModel<String> modelQuimicosDisponibles = (DefaultListModel<String>) listResiduosDisponibles.getModel();
        DefaultListModel<String> modelQuimicosSeleccionados = (DefaultListModel<String>) listResiduosSeleccionados.getModel();

        String selectedValue = listResiduosSeleccionados.getSelectedValue();
        modelQuimicosDisponibles.addElement(selectedValue);
        listResiduosDisponibles.repaint();

        modelQuimicosSeleccionados.removeElement(selectedValue);
    }

    public ArrayList<Residuo> obtenerResiduosExistentes() {

        MongoCollection<Residuo> collection = residuoDAO.getCollection();

        // Crear un nuevo ArrayList
        ArrayList<Residuo> arrayList = new ArrayList<>();

        // Obtener un cursor de los documentos de la colección
        FindIterable<Residuo> documents = collection.find();
        MongoCursor<Residuo> cursor = documents.iterator();

        // Recorrer el cursor y agregar los documentos al ArrayList
        while (cursor.hasNext()) {
            Residuo residuo = cursor.next();
            arrayList.add(residuo);

        }
        return arrayList;

    }

    public ArrayList<Residuo> obtenerResiduosSeleccionados() {

        DefaultListModel<String> modelSelected = (DefaultListModel<String>) this.listResiduosSeleccionados.getModel();
        ArrayList<Residuo> residuos = new ArrayList<>();
        for (int i = 0; i < modelSelected.getSize(); i++) {
            try {
                residuos.add(this.residuoDAO.verificaExistenciaPorNombre(modelSelected.get(i)));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error obteniendo los residuos del sistema.");
            }

        }
        return residuos;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        trasladoDatePicker = new com.github.lgooddatepicker.components.CalendarPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listResiduosDisponibles = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listResiduosSeleccionados = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        seleccionarBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        seleccionarFecha = new javax.swing.JToggleButton();
        btnSolicitar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbDestino = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        codigoTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Solicitar Traslado");

        jLabel2.setText("Seleccione una fecha para su traslado");

        jScrollPane1.setViewportView(listResiduosDisponibles);

        jScrollPane2.setViewportView(listResiduosSeleccionados);

        jLabel3.setText("Fecha Seleccionada: ");

        seleccionarBtn.setText("Seleccionar");
        seleccionarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarBtnActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        seleccionarFecha.setText("Seleccionar Fecha");
        seleccionarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarFechaActionPerformed(evt);
            }
        });

        btnSolicitar.setText("Solicitar traslado");
        btnSolicitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel5.setText("Cantidad");

        jLabel6.setText("Destino");

        cbDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Chiapas", "Chihuahua", "Coahuila de Zaragoza", "Colima", "Ciudad de México", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "Mexico", "Michoacan", "Morelos", "Nayarit", "Nuevo Leon", "Oaxaca", "Puebla", "Queretaro de Arteaga", "Quintana Roo", "San Luis Potosi", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatan", "Zacatecas" }));

        jLabel7.setText("Código");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(trasladoDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(seleccionarFecha))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel3)
                                .addGap(83, 83, 83)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(seleccionarBtn)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(btnSolicitar)
                        .addGap(75, 75, 75)
                        .addComponent(btnCancelar)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCantidad)
                    .addComponent(cbDestino, 0, 299, Short.MAX_VALUE)
                    .addComponent(codigoTxt))
                .addGap(93, 93, 93))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(trasladoDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(seleccionarFecha))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(jLabel3)))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seleccionarBtn)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(codigoTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSolicitar)
                    .addComponent(btnCancelar))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void seleccionarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarBtnActionPerformed
        // TODO add your handling code here:
        seleccionarQuimico();
    }//GEN-LAST:event_seleccionarBtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        eliminarQuimico();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void seleccionarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarFechaActionPerformed
        // TODO add your handling code here:
        jLabel4.setText(trasladoDatePicker.getSelectedDate().toString());

    }//GEN-LAST:event_seleccionarFechaActionPerformed

    private void btnSolicitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarActionPerformed
        // TODO add your handling code here:

        try {

            guardarSolicitudTraslado();

            PantallaPrincipal pp = PantallaPrincipal.obtenerInstancia();
            pp.mostrarVentana();
            this.dispose();

        } catch (Exception e) {
            System.out.println(e);
        }


    }//GEN-LAST:event_btnSolicitarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
            PantallaPrincipal pp = PantallaPrincipal.obtenerInstancia();
            pp.mostrarVentana();
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SolicitarTraslado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SolicitarTraslado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SolicitarTraslado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SolicitarTraslado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SolicitarTraslado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSolicitar;
    private javax.swing.JComboBox<String> cbDestino;
    private javax.swing.JTextField codigoTxt;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listResiduosDisponibles;
    private javax.swing.JList<String> listResiduosSeleccionados;
    private javax.swing.JButton seleccionarBtn;
    private javax.swing.JToggleButton seleccionarFecha;
    private com.github.lgooddatepicker.components.CalendarPanel trasladoDatePicker;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}
