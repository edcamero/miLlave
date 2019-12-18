/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import conexionBD.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ListaS;

/**
 *
 * @author enyer
 */
public class control {
static Conexion con=new Conexion();
ListaS<caja> cajas=new ListaS();
static ResultSet resultado;
sincronizar sincro=new sincronizar();

public control() {
    }

public void cargarCajas() 
 {
    try {
        con.ConexionPostgres();
        String query="select *from caja";
        resultado=con.consulta(query);
        while(resultado.next()){
            caja cj=new caja (resultado.getInt(1),resultado.getInt(2),resultado.getInt(3),sincro);
            cajas.addFin(cj);
        }
         con.cerrar();
    } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
        Logger.getLogger(control.class.getName()).log(Level.SEVERE, null, ex);
    }
 }

public static String [] buscarCliente(int cedula) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
   String nombre[]=new String[2];
    
        con.ConexionPostgres();
        
        String query="Select nombre,apellido from cliente where id_cliente="+cedula+";";
        resultado=con.consulta(query);
        if(resultado.next())
            nombre[0]=resultado.getString(1);
            nombre[1]=resultado.getString(2);
         con.cerrar();
   
    
   
    return nombre;
}
 
 public  static int cantVentas(){
    return contarFilas("venta");
 }
 public  static int contarClientesR(){
    return contarFilas("cliente");
 }
 public static int contarFilas(String tabla){
     //retorna el numero de filas de una tabla en la base de datos
    int cant=0;
     try {
        con.ConexionPostgres();
        String query="select count(*)\n" +
                "  from "+tabla+" ;";
        resultado=con.consulta(query);
        if(resultado.next()){
            cant=resultado.getInt(1);
        }
        con.cerrar();
    
       } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
        Logger.getLogger(control.class.getName()).log(Level.SEVERE, null, ex);
     
 }return cant;}
 
 
 
 
 public static String[] consultarProducto(int id){
    String[] producto=new String[7];
     try {
        
        con.ConexionPostgres();
        String query="select *from producto where id_producto="+id+";";
        resultado=con.consulta(query);
        if(resultado.next()){
            for(int i=0;i<7;i++){
                producto[i]=resultado.getString(i+1);
            }
        }
        con.cerrar();
        
    } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
        Logger.getLogger(control.class.getName()).log(Level.SEVERE, null, ex);
    }
    return producto;
 }
 
 
 public int consultarPrecio(int id){
     int precio=0;
    try {
        
        con.ConexionPostgres();
        String query="select valor_producto from prodcuto where id_producto="+id;
        resultado=con.consulta(query);
        if(resultado.next()){
            precio=resultado.getInt(1);
        }
        con.cerrar();
    } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
        Logger.getLogger(control.class.getName()).log(Level.SEVERE, null, ex);
    }
    return precio;
 }
 
 
 public static  synchronized void agregarVenta(venta v){
      
    try   {
       v.setIdVenta(cantVentas()+1);
        con.ConexionPostgres();
        
        String query="insert into venta(id_cliente, total_venta, id_caja, fecha)  values("+v.getCedula()+","+v.getTotal()+","+v.getIdcaja()+",'"+util.Fecha.Stringfecha(v.getFecha())+"')";
        con.actualizar(query);
       
        con.cerrar();
     agregarDetalle(v.getIdVenta(),v.detalles);     
     registrarTimeVenta(v.getCedula(),v.getTimeVenta());
    } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
        Logger.getLogger(control.class.getName()).log(Level.SEVERE, null, ex);
    }
 }
  private static synchronized void agregarDetalle(int idVenta,ListaS<detalle> deta){
    try {
        con.ConexionPostgres();
        for(detalle a:deta){
            String query="insert into detalle_venta(id_venta, cantidad, id_producto) VALUES ("+idVenta+","+a.getCant()+","+a.getIdproducto()+");";
            con.actualizar(query);
            query="UPDATE public.producto\n" +
            "   SET  cantidad=cantidad-"+a.getCant()+" WHERE (id_producto="+a.getIdproducto()+");";
            con.actualizar(query);
        }
        con.cerrar();
    } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
        Logger.getLogger(control.class.getName()).log(Level.SEVERE, null, ex);
    }
 }
  
    private static void   registrarTimeVenta(int id,long time){
    try {
        String query="update cliente set tiempo=(tiempo+"+time+")/2 where (id_cliente="+id+");";
        con.ConexionPostgres();
        con.actualizar(query);
        con.cerrar();
    } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
        Logger.getLogger(control.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }
     
 public void iniciarSimulacion(){
    
           simulacion mySimulacion=new simulacion();
           surtir surtirTienda=new surtir(sincro);
           mySimulacion.setCajas(cajas);
           
           Thread hilo=new Thread(mySimulacion);
           surtirTienda.start();
           hilo.start();      
 }
 
 public static void RegistrarCliente(Cliente a) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
    
    
                
    
        con = new Conexion();
        con.ConexionPostgres();
        String query="insert into cliente values("+a.cedula+",'"+a.nombre+"','"+a.apellido+"',0)";
        con.actualizar(query);
        con.cerrar();
   
       
        }
        
    


}
