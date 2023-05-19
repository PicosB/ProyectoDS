/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Fabrica.IFabricaDatos;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import daos.Fachada;
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

    private IFabricaDatos fabricaSolicitud;
    IResiduoDAO residuoDAO = new ResiduoDAO();
    Fachada residuoFachada = new Fachada();
    Fachada solicitudFachada = new Fachada();

    /**
     * Creates new form SolicitarTraslado
     */
    public SolicitarTraslado(IFabricaDatos fabricaSolicitud) {
        this.fabricaSolicitud = fabricaSolicitud;
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
   public boolean validaVacios() {
        if (this.codigoTxt.getText().isEmpty() 
                || this.txtCantidad.getText().isEmpty()) {
         
            return false;
        }else{
            return true;
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
            if (this.solicitudFachada.verificarExistenciaResiduo(this.codigoTxt.getText()) == null) {
                solicitudTraslado = fabricaSolicitud.crearSolicitud(codigo, obtenerResiduosSeleccionados(), fechaSeleccionada, cantidadResiduo, asingado, destino, null);
                solicitudFachada.crearSolicitudTraslado(solicitudTraslado);
                JOptionPane.showMessageDialog(null, "Se guardó exitosamente su solicitud");
            }else{
                JOptionPane.showMessageDialog(null, "Esta solicitud ya existe");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar la solicitud");
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
                residuos.add(this.residuoFachada.verificarExistenciaResiduoPorNombre(modelSelected.get(i)));
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

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        trasladoDatePicker = new com.github.lgooddatepicker.components.CalendarPanel();
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
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Ingrese la información del traslado");
        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 0));

        jScrollPane1.setViewportView(listResiduosDisponibles);

        jScrollPane2.setViewportView(listResiduosSeleccionados);

        jLabel3.setText("Fecha Seleccionada: ");
        jLabel3.setForeground(new java.awt.Color(0, 102, 0));

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

        jLabel4.setForeground(new java.awt.Color(0, 102, 0));

        seleccionarFecha.setText("Seleccionar Fecha");
        seleccionarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarFechaActionPerformed(evt);
            }
        });

        btnSolicitar.setText("Solicitar traslado");
        btnSolicitar.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnSolicitar.setForeground(new java.awt.Color(0, 102, 0));
        btnSolicitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(0, 102, 0));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel5.setText("Cantidad");
        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 0));

        jLabel6.setText("Destino");
        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 0));

        cbDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Chiapas", "Chihuahua", "Coahuila de Zaragoza", "Colima", "Ciudad de México", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "Mexico", "Michoacan", "Morelos", "Nayarit", "Nuevo Leon", "Oaxaca", "Puebla", "Queretaro de Arteaga", "Quintana Roo", "San Luis Potosi", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatan", "Zacatecas" }));

        jLabel7.setText("Código");
        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 0));

        jLabel8.setText("Seleccione una fecha para su traslado");
        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 0));

        jPanel2.setBackground(new java.awt.Color(0, 102, 0));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Solicitar Traslado");
        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/truck9_122388.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 95, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(trasladoDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(seleccionarFecha)
                                    .addComponent(jLabel3)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(118, 118, 118))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(seleccionarBtn)
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)))
                        .addGap(86, 86, 86))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(btnSolicitar)
                        .addGap(109, 109, 109)
                        .addComponent(btnCancelar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCantidad)
                            .addComponent(cbDestino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(codigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jLabel8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(seleccionarFecha)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(trasladoDatePicker, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(seleccionarBtn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButton2)))
                .addGap(28, 28, 28)
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
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSolicitar)
                    .addComponent(btnCancelar))
                .addGap(44, 44, 44))
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
        setLocationRelativeTo(null);
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
        if (validaVacios() == true){
        try {

            guardarSolicitudTraslado();

            PantallaPrincipal pp = PantallaPrincipal.obtenerInstancia();
            pp.mostrarVentana();
            seluce();
            this.dispose();

        } catch (Exception e) {

            System.out.println(e);
        }
        }else{
            JOptionPane.showMessageDialog(null, "Existen campos vacíos, verifique su información");
        }

    }//GEN-LAST:event_btnSolicitarActionPerformed

    private void seluce() {
        if (this.codigoTxt.getText().equalsIgnoreCase("Grupo Mexico")) {
            JOptionPane.showMessageDialog(null, "Se luce");
        }
    }
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        PantallaPrincipal pp = PantallaPrincipal.obtenerInstancia();
        pp.mostrarVentana();
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(SolicitarTraslado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SolicitarTraslado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SolicitarTraslado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SolicitarTraslado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SolicitarTraslado().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSolicitar;
    private javax.swing.JComboBox<String> cbDestino;
    private javax.swing.JTextField codigoTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
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
