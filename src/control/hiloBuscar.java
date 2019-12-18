package control;
//import java.sql.*;
import conexionBD.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class hiloBuscar implements Runnable
{
	Thread hilo;
	 Conexion con;
	
	public hiloBuscar() 
	{	   	
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
	
	public void run()
	{
		String query= " ";
		ResultSet temp;       		
		Thread hiloActual=Thread.currentThread();
		
        Imprimir  b =new Imprimir();
        b.show();
	
		while (hilo==hiloActual)
		{
          try
          {
                       query= "select * from producto";
                       temp = con.consultar(query);
             
               int conta=0;                       
               while (temp.next())
               {
                String id_pro;
                String nombre;
                int cant=0;
                int  stmin=0;
                int stmax=0;
                id_pro=temp.getString(1);
                nombre=temp.getString(2);
                cant=temp.getInt(6);
                stmin=temp.getInt(7);
                stmax=temp.getInt(8);
                
          
                if(cant<=stmin)
                    javax.swing.JOptionPane.showMessageDialog(null,"EL PRODUCTO" + nombre + "ESTA AGOTADO");
                    b.colocar(id_pro,nombre,cant,stmin,stmax);
                            pausa(5000);
                       }
                      
                    }
		  catch(SQLException ex)	
		  {     Logger.getLogger(hiloBuscar.class.getName()).log(Level.SEVERE, null, ex);
  }
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
