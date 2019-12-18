/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import conexionBD.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import util.Cola;
import util.ListaS;

/**
 *
 * @author enyer
 */
public class simulacion implements Runnable {
Conexion con=new Conexion();
 ResultSet resultado;
 Cola<Cliente> clientes;
 ListaS<caja> cajas;
    public simulacion() {
        clientes=new Cola();
    }

    public void setCajas(ListaS<caja> cajas) {
        this.cajas = cajas;
    }
    
    public  void ingresandoCliente(){
       try{
       int i=Integer.parseInt(JOptionPane.showInputDialog(null,"digite cantida de clientes para realizar simulacion",5));
       int numCli=control.contarClientesR();
       
       if(i>=0){
           
      while(i>numCli){
          ingresandoCliente(numCli);
          i=i-numCli;
      }
      if(i<=numCli){
           ingresandoCliente(i);
       }      
       }      
   }catch(Exception e){
        JOptionPane.showMessageDialog(null,"has salido");
   }     
   }
    
    public  void ingresandoCliente(int i){
        try {
        String query="SELECT id_cliente FROM cliente ORDER BY RANDOM() LIMIT "+i;
        //System.out.print(query);
        con.ConexionPostgres();
        resultado=con.consulta(query);
        while(resultado.next()){
            Cliente c=new Cliente(resultado.getInt(1));
            SeleccionandoProducto(c);
           // System.out.print(c.getCedula()+"\n");
            clientes.add(c);
        }
        con.cerrar();
    } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
        Logger.getLogger(control.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
     
   private   void SeleccionandoProducto(Cliente cli){
    try {
        Random rnd=new Random();
        int num=1+rnd.nextInt(10);
        String query="select id_producto,valor_producto,nombre_producto from producto ORDER BY RANDOM() LIMIT "+num;
        con.ConexionPostgres();
        ResultSet res=con.consulta(query);
        while(res.next()){
            detalle deta=new detalle(res.getInt(1),1+rnd.nextInt(10),res.getInt(2),res.getString(3));
            cli.agregarDetalles(deta);
        }con.cerrar();
   } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
        Logger.getLogger(control.class.getName()).log(Level.SEVERE, null, ex);
    }
   }

    @Override
    
    
    public void run() {       
        ingresandoCliente();
        long ini=System.currentTimeMillis();
        ExecutorService executor=Executors.newFixedThreadPool(10);
        while(!clientes.isVacia()){
            
            Cliente cli=clientes.desencolar();
            caja c; 
          do{
              c=this.BuscarCajaDiponible();
          }while(c==null);
         
            c.setClient(cli);

            executor.execute(c);
            
        }
        
        executor.shutdown();
        while(!executor.isTerminated()){
            
        }
        long fin=System.currentTimeMillis();
        
       System.out.print("finalizo la simulacion "+(fin-ini)/1000+" segundos\n");
    }
   
    public caja BuscarCajaDiponible(){
        for(caja a:cajas){
            if(a.isDisponible()==true){
                a.setDisponible(false);
                return a;
            }
        }return null;
    }
        }
