/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria;

import conexionBD.Conexion;
import control.control;
import control.detalle;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author enyer
 */
public class agregarProductoVenta extends javax.swing.JFrame {
Conexion c;
String producto[];
int cant=0;
detalle deta;
    /**
     * Creates new form agregarProductoVenta
     * @param deta
     */
    public agregarProductoVenta() {
        initComponents();
        c=new Conexion();
        autocompletar(Tnombre);
        tabla.setModel(c.consultaG("select * from producto"));
    }

    public void autocompletar(JTextField a){
a.addKeyListener(new KeyAdapter(){
  public void keyTyped (KeyEvent e){
 char b=e.getKeyChar();
 String query="";
 if (e.getKeyChar()!=8){
     query="select * from producto where nombre_producto like '"+Tnombre.getText()+b;
     query=query+"%%' ";
 }
 else {
     query="select * from producto where nombre_producto like '"+Tnombre.getText();
     query=query+"%%' ";
 }
 
 tabla.setModel(c.consultaG(query));
  }  
    
    
});}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        Tnombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Título 4"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jLabel1.setText("Nombre producto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(71, 71, 71)
                .addComponent(Tnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Tnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
  producto=new String[tabla.getColumnCount()];
       
       int fila=tabla.getSelectedRow();
       int existencia=Integer.parseInt(tabla.getValueAt(fila,5).toString());
       try{do{
           cant =Integer.parseInt(JOptionPane.showInputDialog ("Escriba cantidad a vender")); 
           if(cant>existencia){
               JOptionPane.showMessageDialog(null,"Cantidad ingresada supera inventario del producto");
           }
       }while(cant>existencia);
       
       }catch(HeadlessException | NumberFormatException e){
           cant=0;
       }
       if(cant!=0){
       
       int id=Integer.valueOf(tabla.getValueAt(fila,0).toString());
       for (int j = 0; j < tabla.getColumnCount(); j++) {
           producto[j]=String.valueOf(tabla.getValueAt(fila, j));
             }
       deta=new detalle(Integer.parseInt(producto[0]),cant,Integer.parseInt(producto[2]),producto[1]);
      Ventas.agregardetalle(deta);
       this.setVisible(false);
       }
    }//GEN-LAST:event_tablaMouseClicked

    public detalle getDeta() {
        return deta;
    }

    public String[] getProducto() {
        return producto;
    }

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Tnombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
