/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import static control.control.con;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author enyer
 */
public class sincronizar {
 static ResultSet resultado;
  static  boolean sePuedeSurtir=true;
 
    public sincronizar() {
        
     
    }
 
 public  synchronized void AgregarVenta(venta v){
     while(sePuedeSurtir  == true)
    {

      try
      {
        wait(); // el hilo se pone a dormir y cede el monitor
      }
      catch (InterruptedException e) { }
    } 
     
     if(sePuedeSurtir == false)
    {
     control.agregarVenta(v);
     sePuedeSurtir=true;
     notifyAll();
 }
     
 }

    public static boolean isSePuedeSurtir() {
        return sePuedeSurtir;
    }

    public static void setSePuedeSurtir(boolean sePuedeSurtir) {
        sincronizar.sePuedeSurtir = sePuedeSurtir;
    }
 public synchronized void SurtirTienda(){
   
     while(sePuedeSurtir==false)
    {

      try
      {
        wait(); // el hilo se pone a dormir y cede el monitor
      }
      catch (InterruptedException e) { }
    } 
     System.out.print("verificando productos para sutir..\n");
    
     
      try {
        con.ConexionPostgres();
        String query= "select *from producto where(cantidad<=stock_minimo);";
        resultado = con.consultar(query);
        while (resultado.next())
               {int cant=resultado.getInt(6);
               int min=resultado.getInt(7);
               if(cant<=min){
                   
                   System.out.print("surtiendo el producto "+resultado.getString(2)+" de "+cant+" hasta la cantidad de "+resultado.getInt(8)+" \n");
               }
                    }
             surtirProducto();
             con.cerrar();
        
        
    } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
        Logger.getLogger(control.class.getName()).log(Level.SEVERE, null, ex);
    }
     sePuedeSurtir=false;
     notifyAll();
 }
      
 private   void surtirProducto(){
    try {
        con.ConexionPostgres();
        String query2="UPDATE  public.producto SET  cantidad=stock_maximo WHERE (cantidad<stock_minimo);";
        con.actualizar(query2);
        
    } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
        Logger.getLogger(control.class.getName()).log(Level.SEVERE, null, ex);
    }
 }
 
 
}
