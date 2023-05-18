/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Fabrica.FabricaDatos;
import Fabrica.IFabricaDatos;
import daos.Fachada;
import daos.IResiduoDAO;
import daos.ResiduoDAO;
import entidades.ConstituyenteQuimico;
import entidades.EmpresaProductora;
import entidades.Residuo;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author luis
 */
public class RegistrarResiduo extends javax.swing.JFrame {
 
    Fachada residuoFachada = new Fachada();
    
    private IFabricaDatos fabricaResiduo;
    
    
    /**
     * Creates new form RegistrarResiduo
     */
    public RegistrarResiduo(IFabricaDatos fabricaResiduo) {
        this.fabricaResiduo = fabricaResiduo;
        initComponents();
        DefaultListModel<String> modelQuimicos = new DefaultListModel<String>();
        DefaultListModel<String > modelResiduos = new DefaultListModel<String>();
        quimicoslist.setModel(modelQuimicos);
        residuosList.setModel(modelResiduos);

        modelQuimicos.addElement("Amoniaco");
        modelQuimicos.addElement("Cianuro");
        modelQuimicos.addElement("Plomo");
        modelQuimicos.addElement("Cloro");

    }

    private void registrar() {
        String codigo = txtCodigo.getText();
        String nombre = txtNombre.getText();
        ConstituyenteQuimico constituyenteQuimicoPrimario = new ConstituyenteQuimico();
        ConstituyenteQuimico constituyenteQuimicoSecundario = new ConstituyenteQuimico();
        EmpresaProductora empresaProductora = new EmpresaProductora();

        Residuo residuo = fabricaResiduo.crearResiduo(codigo, nombre, constituyenteQuimicoPrimario, constituyenteQuimicoSecundario, empresaProductora);
        
        residuo.setCodigo(codigo);
        residuo.setNombre(nombre);
        residuo.setEmpresaproductora(null);
        
        DefaultListModel<String> modelR = (DefaultListModel<String>) residuosList.getModel();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < modelR.getSize() - 1; i++) {
            String element = modelR.getElementAt(i);
            arrayList.add(element);
            constituyenteQuimicoPrimario.setNombre(modelR.getElementAt(i));
            constituyenteQuimicoSecundario.setNombre(modelR.getElementAt(i + 1));
            
        }
        residuo.setConstituyenteQuimicoPrimario(constituyenteQuimicoPrimario);
        residuo.setConstituyenteQuimicoSecundario(constituyenteQuimicoSecundario);
        try{
           residuoFachada.crearResiduo(residuo);
           JOptionPane.showMessageDialog(null, "Se agregó un residuo");
        }catch(Exception e ){
            JOptionPane.showMessageDialog(null, "Ocurrió un error al momento de registrar");
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
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        añadirBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        quimicoslist = new javax.swing.JList<>();
        eliminarBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        residuosList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        cancelarBtn = new javax.swing.JButton();
        registrarBtn = new javax.swing.JButton();
        cbEmpresa = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        añadirBtn.setText("Añadir");
        añadirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Registra Residuo");

        quimicoslist.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Amoniaco", "Cianuro", "Cloro", "Plomo" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(quimicoslist);

        eliminarBtn.setText("Eliminar");
        eliminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBtnActionPerformed(evt);
            }
        });

        residuosList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(residuosList);

        jLabel2.setText("Nombre del residuo");

        jLabel3.setText("Codigo del residuo");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        cancelarBtn.setText("Cancelar");
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtnActionPerformed(evt);
            }
        });

        registrarBtn.setText("Registrar");
        registrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarBtnActionPerformed(evt);
            }
        });

        cbEmpresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Intel", "Chalet", "La Palmera", "Office Depot", "Moe's", "ITSON", " " }));

        jLabel4.setText("Seleccione empresa");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(jLabel1)
                .addContainerGap(326, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(añadirBtn)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(registrarBtn)
                        .addGap(102, 102, 102)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelarBtn)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(eliminarBtn)))
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(131, 131, 131))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(eliminarBtn)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(añadirBtn))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarBtn)
                    .addComponent(registrarBtn))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void añadirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirBtnActionPerformed
        // TODO add your handling code here:

        // codigo para mover elementos de una lista a otra
        this.quimicoslist.remove(this);
        DefaultListModel<String> modelQ = (DefaultListModel<String>) quimicoslist.getModel();
        DefaultListModel<String> modelR = (DefaultListModel<String>) residuosList.getModel();
        String selectedValue = quimicoslist.getSelectedValue();
        modelQ.removeElement(selectedValue);
        quimicoslist.repaint();
        modelR.addElement(selectedValue);

        //creacion del residuo con datos

    }//GEN-LAST:event_añadirBtnActionPerformed

    private void eliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBtnActionPerformed
        // TODO add your handling code here:
        DefaultListModel<String> modelQ = (DefaultListModel<String>) quimicoslist.getModel();
        DefaultListModel<String> modelR = (DefaultListModel<String>) residuosList.getModel();

        String selectedValue = residuosList.getSelectedValue();
        modelQ.addElement(selectedValue);
        quimicoslist.repaint();

        modelR.removeElement(selectedValue);

    }//GEN-LAST:event_eliminarBtnActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void registrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarBtnActionPerformed
        // TODO add your handling code here:

        registrar();
        
        PantallaPrincipal pp = PantallaPrincipal.obtenerInstancia();
            pp.mostrarVentana();
            this.dispose();



    }//GEN-LAST:event_registrarBtnActionPerformed

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        // TODO add your handling code here:
       PantallaPrincipal pp = PantallaPrincipal.obtenerInstancia();
            pp.mostrarVentana();
            this.dispose();

    }//GEN-LAST:event_cancelarBtnActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton añadirBtn;
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JComboBox<String> cbEmpresa;
    private javax.swing.JButton eliminarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JList<String> quimicoslist;
    private javax.swing.JButton registrarBtn;
    private javax.swing.JList<String> residuosList;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
