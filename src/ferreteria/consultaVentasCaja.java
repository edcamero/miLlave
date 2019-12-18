/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria;

import conexionBD.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Seifer
 */
public class consultaVentasCaja extends javax.swing.JInternalFrame {
Conexion c=new Conexion();;
   
    public consultaVentasCaja() {
        initComponents();
        Tcant.setEditable(false);
        Ttotal.setEditable(false);
        mostrarComboCaja();
    }
    
    public void mostrarComboCaja(){
    try {      
        c.ConexionPostgres();
        comboCaja.removeAllItems();
        comboCaja.addItem("Seleccione");     
        String query="select* from  caja";
        ResultSet resultado=c.consulta(query);
        
        while(resultado.next()){
            comboCaja.addItem(String.valueOf(resultado.getObject(1)));        
        }       
        c.cerrar();
    } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
        Logger.getLogger(addProducto.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    public void sumaTotal(int id){
    try {
        c.ConexionPostgres();
        String query="select sum(venta.total_venta) from venta where (id_caja="+id+") GROUP BY id_caja";
        ResultSet resultado=c.consulta(query);
        if(resultado.next()){
            Ttotal.setText(resultado.getString(1));
        }
    } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
        Logger.getLogger(consultaVentasCaja.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    public void VentasCaja(int id){
    
        String query="select* from venta where (id_caja="+id+");";
        tabla.setModel(c.consultaG(query));
        int cont =tabla.getModel().getRowCount();
        Tcant.setText(String.valueOf(cont));
     
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboCaja = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        Tcant = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Ttotal = new javax.swing.JTextField();

        jLabel1.setText("Caja");

        comboCaja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboCaja.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCajaItemStateChanged(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        jButton1.setText("SALIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID VENTA", "CEDULA", "TOTAL VENTA", "FECHA"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        jLabel2.setText("Cantidad");

        jLabel3.setText("Total $");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(73, 73, 73)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboCaja, 0, 99, Short.MAX_VALUE)
                            .addComponent(Tcant)
                            .addComponent(Ttotal))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(comboCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Tcant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Ttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    dispose();     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboCajaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCajaItemStateChanged
if (comboCaja.getSelectedIndex()>0){
VentasCaja(comboCaja.getSelectedIndex());
sumaTotal(comboCaja.getSelectedIndex());
}        // TODO add your handling code here:
    }//GEN-LAST:event_comboCajaItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Tcant;
    private javax.swing.JTextField Ttotal;
    private javax.swing.JComboBox<String> comboCaja;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
