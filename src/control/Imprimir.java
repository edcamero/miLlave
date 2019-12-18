package control;
import java.awt.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Imprimir extends Frame
{
            public static JTable tabla;
            public Imprimir()
            {
                        inicializar();
                        this.setTitle("Buscador de Productos");
            }
            
            private void inicializar()
            {
                        tabla =new JTable();
                        setLayout(new BorderLayout(50,50));
                        
                        addWindowListener(new java.awt.event.WindowAdapter()
                        {
                                   public void windowClosing(java.awt.event.WindowEvent e)
                                   {
                                               salir(e);
                                   }
                        });
                            tabla.setModel(new javax.swing.table.DefaultTableModel(
                           new Object [][] {},
                           new String [] {"ID PRODUCTO", "NOMBRE", "CANTIDAD","STOCK MINIMO","STOCK MAXIMO"}  ));
                           tabla.setPreferredScrollableViewportSize(new Dimension(400, 300));
                           JScrollPane scrollPane = new JScrollPane(tabla);
                           add(scrollPane, BorderLayout.CENTER);
                      
                        pack();
            }
            
            public static void colocar(String id, String nom, int cant, int stmin,int stmax)
            { 
                DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
                modelo.addRow(new String[]{String.valueOf(id),String.valueOf(nom),String.valueOf(cant),String.valueOf(stmin),String.valueOf(stmax)});
               
            }
            
            
            private void salir(java.awt.event.WindowEvent e)
            {
                        dispose();
            }
            
}
