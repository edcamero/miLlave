/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Calendar;

/**
 *
 * @author enyer
 */
public class caja extends Thread{
    boolean disponible;
    sincronizar sincro;
    int id;
    int total;
    int idEmpleado;
    Cliente cliente;
    private long initime,fintime;
    venta miVenta;

    public void setClient(Cliente cliente) {
        this.cliente = cliente;
        this.initime=System.currentTimeMillis();
    }

    public  void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public caja(int id) {      
        this.id = id;
    }
    
    public caja(int id, int total, int idEmpleado,sincronizar sincro) {
        disponible=true;
        this.id = id;
        this.total = total;
        this.idEmpleado = idEmpleado;
        this.sincro=sincro;
    }

    public  boolean isDisponible() {
        return disponible;
    }

    public int getid() {
        return id;
    }

    public int getTotal() {
        return total;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    @Override
    public void run() {
    miVenta=new venta(cliente.getCedula(),Calendar.getInstance(),this.id);
    System.out.print("la caja "+this.id+" atiende al cliente "+cliente.getCedula()+" en el tiempo "+(System.currentTimeMillis()-initime)/1000+ " seg\n");
        
    for(detalle a:cliente.getDetalles()){
    this.TiempoConsumiendo(a.getCant());
    miVenta.agregarDetalle(a);
    System.out.print("la caja "+this.id+": vendiendo el producto "+a.getIdproducto()+" la cantidad "+a.getCant()+" del cliente "+ cliente.getCedula()+" en tiempo: "+(System.currentTimeMillis()-initime)/1000+ " seg\n");
    }
    fintime=(System.currentTimeMillis()-initime)/1000;
    miVenta.setTimeVenta(fintime);
    sincro.AgregarVenta(miVenta);

    
    this.disponible= true;
    
    this.stop();
    System.out.print("la caja "+this.id+" Finalizo de atender al cliente "+cliente.getCedula()+" en el tiempo "+fintime+ " seg\n");
 }
    
    private void TiempoConsumiendo(int seg){
        try{
            Thread.sleep(seg*1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
    }
    
    }
}