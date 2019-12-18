/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import conexionBD.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author enyer
 */
public class hiloPromo implements Runnable{ 
       util.Fecha fecha;
	Thread hilo;
	 Conexion con;
	
	public hiloPromo() 
	{
	fecha=new util.Fecha();	
	   	
	}

 	
	public void inicio() throws Exception
	{
            con = new Conexion();
            con.ConexionPostgres();
            
	    if (hilo==null)
		{
			hilo=new Thread(this);//crea el hilo
			hilo.start();// lanzar el hilo
			
		}		
	}
	
	public void stop()
	{
		hilo=null;
	}
	
       @Override
	public void run()
	{
		String query= " ";
		ResultSet temp;
        		
		Thread hiloActual=Thread.currentThread();
		
       // Imprimir  b =new Imprimir();
      //  b.show();
	
		while (hilo==hiloActual)
		{
          try
          {
              
                       query= "select l.fecha_inicial,l.fecha_final,l.id_producto ,p.nombre_producto from public.promocion as l\n" +
                               "inner join producto as p on l.id_producto=p.id_producto";
                       temp = con.consultar(query);
              try
              {
                                   
               while (temp.next())
               { 
                  Calendar fechaIni=fecha.Stringfecha(temp.getString(1));
                  Calendar fechaFin=fecha.Stringfecha(temp.getString(2));
                
                 //  System.out.print(temp.getString(3));    
               
           
           
           long segun=fecha.tiempoDeDiferencia(Calendar.getInstance(), fechaIni);
           int dias=fecha.ConvertirDias(segun);
           segun=fecha.tiempoDeDiferencia(Calendar.getInstance(), fechaFin);
           int dias2=fecha.ConvertirDias(segun); 
              
                if(dias>0&&dias<=3){
                   javax.swing.JOptionPane.showMessageDialog(null,"Quedan "+dias+" dias para promocion de "+temp.getString(4));
                   // b.colocar(id_pro,nombre,cant,stmin,stmax);
                           
                       }
                if(dias==0||(dias<0&&dias2>=0)){
                     javax.swing.JOptionPane.showMessageDialog(null,"hoy es dia de  promocion de "+temp.getString(4));
                     
                }
               }
                      }
                      catch(SQLException e)	
                      {  }
                    }
		  catch(SQLException ex)	
		  {     Logger.getLogger(hiloBuscar.class.getName()).log(Level.SEVERE, null, ex);
  } pausa(120000);
		}
	}
	
	public void pausa(int tiempo)
	{
		try
		{
			Thread.sleep(tiempo);
		}
		catch(InterruptedException ignorada)
		{ }
	 }
}
