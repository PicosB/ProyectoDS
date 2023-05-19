/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import daos.Fachada;
import entidades.EmpresaTransportista;
import entidades.SolicitudTraslado;
import entidades.Traslado;
import entidades.Vehiculo;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author luis
 */
public class AsignarVehiculos extends javax.swing.JFrame {

    /**
     * Creates new form AsignarVehiculos
     */
//    ISolicitudTrasladoDAO solicitudTrasladoDAO = new SolicitudTrasladoDAO();
    Fachada solicitudFachada = new Fachada();
    Fachada trasladoFachada = new Fachada();
    String codigoSolicitud;
    ArrayList<Vehiculo> vehiculos = new ArrayList<>();
//    ITrasladoDAO trasladoDAO = new TrasladoDAO();

    public AsignarVehiculos(String codigo) {
        initComponents();
        this.labelEmpresaTransportista.setText("");
        this.codigoSolicitud = codigo;
        obtenerEmpresaTransportista();
        cargaVehiculos();
        llenarLista();
    }
    
    public boolean validaVacios (){
        if(this.txtCantidad.getText().isEmpty()
                || this.txtCodigo.getText().isEmpty()
                || this.txtCosto.getText().isEmpty()
                || this.txtKilometros.getText().isEmpty()
                || this.txtTratamiento.getText().isEmpty()){
         JOptionPane.showMessageDialog(null, "Existen campos vacíos, verifique su información");
         return false;
        }else{
            return true;
        }
    }
    public void obtenerEmpresaTransportista() {
        try {
            this.labelEmpresaTransportista.setText(this.solicitudFachada.verificarExistenciaSolicitudTraslado(this.codigoSolicitud).getEmpresatransportista().getNombre());
            llenarLista();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error obteniendo la empresa de transporte");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        labelEmpresaTransportista = new javax.swing.JLabel();
        aceptarBtn = new javax.swing.JButton();
        cancelarBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listVehiculos = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtKilometros = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        fechaLlegadaDatePicker = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTratamiento = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        fechaLlegadaDate = new com.github.lgooddatepicker.components.DatePicker();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Empresa Transportista");
        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 0));

        labelEmpresaTransportista.setForeground(new java.awt.Color(0, 102, 0));

        aceptarBtn.setText("Aceptar");
        aceptarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarBtnActionPerformed(evt);
            }
        });

        cancelarBtn.setText("Cancelar");
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtnActionPerformed(evt);
            }
        });

        listVehiculos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listVehiculos);

        jLabel2.setText("Codigo");
        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 0));

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        jLabel4.setText("Kilometros");
        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 0));

        txtKilometros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKilometrosActionPerformed(evt);
            }
        });

        jLabel5.setText("Costo");
        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 0));

        fechaLlegadaDatePicker.setText("Fecha de llegada");
        fechaLlegadaDatePicker.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        fechaLlegadaDatePicker.setForeground(new java.awt.Color(0, 102, 0));

        jLabel6.setText("Tratamiento");
        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 0));

        jLabel7.setText("Cantidad");
        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 0));

        jPanel2.setBackground(new java.awt.Color(0, 102, 0));

        jLabel1.setText("Asignar Vehículos");
        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(jLabel1)
                .addContainerGap(175, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel2)))
                                    .addComponent(fechaLlegadaDatePicker))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCosto)
                                    .addComponent(txtCodigo)
                                    .addComponent(txtKilometros)
                                    .addComponent(fechaLlegadaDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(77, 77, 77)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTratamiento, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                                    .addComponent(txtCantidad))))
                        .addGap(209, 209, 209))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(labelEmpresaTransportista, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(aceptarBtn)
                .addGap(128, 128, 128)
                .addComponent(cancelarBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelEmpresaTransportista, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtKilometros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechaLlegadaDatePicker)
                    .addComponent(fechaLlegadaDate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptarBtn)
                    .addComponent(cancelarBtn))
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarBtnActionPerformed
     if(validaVacios() == true){
        
        try{
            
            if(this.trasladoFachada.verificarExistenciaResiduo(this.txtCodigo.getText())==null){
                
        registrarTraslado();
              JOptionPane.showMessageDialog(null, "Se asignó correctamente el vehículo!");
        PantallaPrincipal pp = PantallaPrincipal.obtenerInstancia();
        pp.mostrarVentana();
        this.dispose();
            }else{
                
                JOptionPane.showMessageDialog(null, "Ya existe un traslado con este código");
            }
       }catch (Exception e){
           JOptionPane.showMessageDialog(null, "Ocurrió un error, intente de nuevo.");
       }
     }else{
         JOptionPane.showMessageDialog(null, "Existen campos vacíos, verifique e intente de nuevo.");
     }
    }//GEN-LAST:event_aceptarBtnActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtKilometrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKilometrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKilometrosActionPerformed

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        // TODO add your handling code here:
        
        new RegistrarTraslado().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_cancelarBtnActionPerformed
    private void cargaVehiculos() {
        EmpresaTransportista e1 = new EmpresaTransportista("Transportes sixtos");
        EmpresaTransportista e2 = new EmpresaTransportista("Autotanques Reynosa");
        EmpresaTransportista e3 = new EmpresaTransportista("Autotanques especializados Arias");
        EmpresaTransportista e4 = new EmpresaTransportista("Transportes Gama");
        EmpresaTransportista e5 = new EmpresaTransportista("Flensa");
        EmpresaTransportista e6 = new EmpresaTransportista("STIL");
        EmpresaTransportista e7 = new EmpresaTransportista("Fletera nacional de gases");

        Vehiculo v1 = new Vehiculo("Automovil", e1);
        Vehiculo v2 = new Vehiculo("Barco", e2);
        Vehiculo v3 = new Vehiculo("Camión", e3);
        Vehiculo v4 = new Vehiculo("Avión", e4);
        Vehiculo v5 = new Vehiculo("Automovil", e5);
        Vehiculo v6 = new Vehiculo("Barco", e6);
        Vehiculo v7 = new Vehiculo("Automovil", e7);
        Vehiculo v8 = new Vehiculo("Avión", e1);
        Vehiculo v9 = new Vehiculo("Automovil", e3);
        Vehiculo v10 = new Vehiculo("Avión", e2);
        Vehiculo v11 = new Vehiculo("Barco", e4);
        Vehiculo v12 = new Vehiculo("Avión", e5);
        Vehiculo v13 = new Vehiculo("Barco", e6);
        Vehiculo v14 = new Vehiculo("Automovil", e7);
        Vehiculo v15 = new Vehiculo("Avión", e7);
        Vehiculo v16 = new Vehiculo("Automovil", e1);
        Vehiculo v17 = new Vehiculo("Avión", e3);
        Vehiculo v18 = new Vehiculo("Automovil", e2);
        Vehiculo v19 = new Vehiculo("Barco", e4);
        Vehiculo v20 = new Vehiculo("Avión", e5);
        Vehiculo v21 = new Vehiculo("Barco", e6);
        Vehiculo v22 = new Vehiculo("Automovil", e7);

        vehiculos.add(v1);
        vehiculos.add(v2);
        vehiculos.add(v3);
        vehiculos.add(v4);
        vehiculos.add(v5);
        vehiculos.add(v6);
        vehiculos.add(v7);
        vehiculos.add(v8);
        vehiculos.add(v9);
        vehiculos.add(v10);
        vehiculos.add(v11);
        vehiculos.add(v12);
        vehiculos.add(v13);
        vehiculos.add(v14);
        vehiculos.add(v15);
        vehiculos.add(v16);
        vehiculos.add(v17);
        vehiculos.add(v18);
        vehiculos.add(v19);
        vehiculos.add(v20);
        vehiculos.add(v21);
        vehiculos.add(v22);
    }

    private ArrayList<Vehiculo> obtieneVehiculos() {
        return this.vehiculos;
    }

    private void llenarLista() {

        DefaultListModel<String> modelSeleccionados = new DefaultListModel<String>();

        this.listVehiculos.setModel(modelSeleccionados);

        //Se guardan los residuos en un arrayList 
        ArrayList vehiculos = obtieneVehiculos();

        for (int i = 0; i < vehiculos.size(); i++) {
            if (obtieneVehiculos().get(i).getEmpresatransportista().getNombre().equalsIgnoreCase(this.labelEmpresaTransportista.getText())) {
                modelSeleccionados.addElement(vehiculos.get(i).toString());
            }

        }
    }

    private void registrarTraslado() {
        Vehiculo vehiculoSeleccionado = new Vehiculo();

        DefaultListModel<String> modelSelected = (DefaultListModel<String>) this.listVehiculos.getModel();
        ArrayList<SolicitudTraslado> residuos = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            try {
                if (obtieneVehiculos().get(i).equals(modelSelected.get(i))) {
                    vehiculoSeleccionado = obtieneVehiculos().get(i);

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error obteniendo los residuos del sistema.");
            }
            try {

                Traslado traslado = new Traslado(this.txtCodigo.getText(),
                        Float.valueOf(this.txtKilometros.getText()),
                        Float.valueOf(this.txtCosto.getText()),
                        fechaLlegadaDate.getDate(),
                        this.txtTratamiento.getText(),
                        this.solicitudFachada.verificarExistenciaSolicitudTraslado(codigoSolicitud),
                        Float.valueOf(this.txtCantidad.getText()),
                        vehiculoSeleccionado);
                this.trasladoFachada.crearTraslado(traslado);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al registrar el traslado");
            }
        }
    }
//
//    /**
//     * @param args the command line arguments
//     */
//
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
//            java.util.logging.Logger.getLogger(AsignarVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AsignarVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AsignarVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AsignarVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AsignarVehiculos(null).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarBtn;
    private javax.swing.JButton cancelarBtn;
    private com.github.lgooddatepicker.components.DatePicker fechaLlegadaDate;
    private javax.swing.JLabel fechaLlegadaDatePicker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelEmpresaTransportista;
    private javax.swing.JList<String> listVehiculos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtKilometros;
    private javax.swing.JTextField txtTratamiento;
    // End of variables declaration//GEN-END:variables
}
