/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ferreteria;

import conexionBD.Conexion;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import control.*;
import java.awt.HeadlessException;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author enyer
 */
public class Ventas extends javax.swing.JInternalFrame {
 control admin;
 String nombre[]=null;
 static venta miVenta;
 int cedula;
 int idVenta;
 Conexion c;
 String[] producto;
 int cant=1;
 int idcaja=0;

    public Ventas() {
        
        initComponents();
        Tid.setEditable(false);
        Ttotal.setEditable(false);
        Tnombre.setEditable(false);
        Tapellido.setEditable(false);
        mostrarComboCaja();    
        fecha.setCalendar(Calendar.getInstance());
        idVenta=admin.cantVentas()+1;
        Tid.setText(String.valueOf(idVenta));
        jButton2.setEnabled(false);
        jLabel6.setEnabled(false);
        
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        panel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Tcedula = new javax.swing.JTextField();
        Tnombre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Tid = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboCaja = new javax.swing.JComboBox<>();
        fecha = new com.toedter.calendar.JDateChooser();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Tapellido = new javax.swing.JTextField();
        panel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        Ttotal = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        panel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Venta"));

        jLabel1.setText("Cedula cliente");

        jLabel2.setText("Nombre cliente");

        jLabel3.setText("Fecha");

        Tcedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TcedulaActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscando.png"))); // NOI18N
        jButton1.setText("BUSCAR CLIENTE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Id venta");

        jLabel5.setText("Caja");

        comboCaja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboCaja.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCajaItemStateChanged(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ok.png"))); // NOI18N
        jButton5.setText("OK");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel7.setText("Apellido cliente");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(101, 101, 101)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel3))
                            .addComponent(jLabel7))
                        .addGap(30, 30, 30)))
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Tcedula)
                    .addComponent(fecha, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(Tnombre)
                    .addComponent(Tid)
                    .addComponent(comboCaja, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Tapellido))
                .addGap(59, 59, 59)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(20, 20, 20))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Tid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Tcedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Tnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(Tapellido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(comboCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        panel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle"));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add.png"))); // NOI18N
        jButton2.setText("SELECCIONAR PRODUCTO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Cantidad", "Valor", "Total"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jLabel6.setText("Total");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(104, 104, 104)
                                .addComponent(Ttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Ttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        jButton3.setText("GUARDAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        jButton4.setText("CANCELAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(116, 116, 116)
                .addComponent(jButton4)
                .addGap(112, 112, 112))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
     dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

boolean esta=false;
        try{if(Tcedula.getText()!=""){
    cedula=Integer.parseInt(Tcedula.getText());
  nombre=admin.buscarCliente(cedula);
        esta=true;}
}catch(NumberFormatException e){
   
JOptionPane.showMessageDialog(null, "Digite Cedula");
}
catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException |NullPointerException ex) {
         JOptionPane.showMessageDialog(null, "Cliente no registado");
          esta=false;
          Tnombre.setEditable(true);
        Tapellido.setEditable(true);
     }
        if(esta){
        Tnombre.setText(nombre[0]);
        Tapellido.setText(nombre[1]);}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboCajaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCajaItemStateChanged
    if(comboCaja.getSelectedIndex()!=0){
       miVenta=new venta(cedula,fecha.getCalendar(),comboCaja.getSelectedIndex(),idVenta);
    }
        
    }//GEN-LAST:event_comboCajaItemStateChanged

    private void TcedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TcedulaActionPerformed
        
    }//GEN-LAST:event_TcedulaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         agregarProductoVenta v=new agregarProductoVenta();
         v.setVisible(true);
         v.setLocationRelativeTo(null);
        
        
    }//GEN-LAST:event_jButton2ActionPerformed
public static  void agregardetalle(detalle deta){
    detalle m= miVenta.agregarDetalle(deta);
          Ttotal.setText(String.valueOf(miVenta.getTotal()));
         DefaultTableModel modelo=(DefaultTableModel)tabla.getModel();
         
         int id;
         boolean encontro=false;
         for(int i=0; i< tabla.getRowCount(); i++){
             id=Integer.parseInt(tabla.getValueAt(i, 0).toString());
             if(id==m.getIdproducto()){
                 tabla.setValueAt(m.getCant(), i, 2);
                 tabla.setValueAt(m.getTotal(), i, 4);
                 encontro=true;
                 break;
             }
         }
         if(!encontro){              
          modelo.addRow(m.getVector());
}}
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    
     control.agregarVenta(miVenta);
     JOptionPane.showMessageDialog(null,"se a agregado con exito");
     dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       if (null==nombre&&validar()){
           
           try {
               Cliente nuevo=new Cliente(Integer.parseInt(Tcedula.getText()),Tnombre.getText(),Tapellido.getText());
               control.RegistrarCliente(nuevo);
           } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
               JOptionPane.showMessageDialog(null,"error en registrar cleinte : cedula repetida");
           }
         }   
       if(validar()){
          activar (); 
       }else{JOptionPane.showMessageDialog(null,"llene todos lo campos");} 
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        int select=tabla.getSelectedRow();
        String options[]={"editar","eliminar","cancelar"};
       int i= JOptionPane.showOptionDialog(null,"", "Seleccione",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null, options,options[0]);
int id_producto=Integer.parseInt(tabla.getValueAt(select,0).toString());
  // interpret the user's choice
  if (i == JOptionPane.YES_OPTION)
  {  
    int cant=Integer.parseInt(JOptionPane.showInputDialog("digite cantida para cambiar"));
     detalle a=miVenta.editar(id_producto, cant);
    
      DefaultTableModel modelo = (DefaultTableModel)tabla.getModel(); 
      modelo.setValueAt(cant, select,2);
      modelo.setValueAt(a.getTotal(), select,4);
      Ttotal.setText(String.valueOf(miVenta.getTotal()));
  }
  if (i == JOptionPane.NO_OPTION){
      miVenta.EliminarDetalle(id_producto);
      DefaultTableModel modelo = (DefaultTableModel)tabla.getModel(); 
      modelo.removeRow(select); 
  }

    Ttotal.setText(String.valueOf(miVenta.getTotal()));
    }//GEN-LAST:event_tablaMouseClicked
public void mostrarComboCaja(){
    try {
        c=new Conexion();
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
    public void Snumeros (JTextField a){
  a.addKeyListener(new KeyAdapter(){
  @Override
  public void keyTyped (KeyEvent e){
  char c=e.getKeyChar();
  if(!Character.isDigit(c)&&e.getKeyChar()!=8){
  e.consume();
  JOptionPane.showMessageDialog(null, "Digite solo numeros");
  }
  }
  });} 

    public void activar (){
    jButton2.setEnabled(true);
    jLabel6.setEnabled(true);
    }
     private boolean validar(){
      try{  
        if(Tcedula.getText().equals("")||Tnombre.getText().equals("")||Tapellido.getText().equals("")||comboCaja.getSelectedIndex()==0){
            
            return false;
        }}catch(HeadlessException e){          
        }
      
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Tapellido;
    private javax.swing.JTextField Tcedula;
    private javax.swing.JTextField Tid;
    private javax.swing.JTextField Tnombre;
    private static javax.swing.JTextField Ttotal;
    private javax.swing.JComboBox<String> comboCaja;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private static javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
