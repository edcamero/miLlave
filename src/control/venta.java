/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Calendar;
import util.ListaS;

/**
 *
 * @author enyer
 */
public class venta {
   int cedula;
   Calendar fecha;
   int total;
   int idcaja;
   int idVenta;
   long timeVenta;
   
   ListaS<detalle> detalles;

    public int getIdVenta() {
        return idVenta;
    }

    public long getTimeVenta() {
        return timeVenta;
    }

    public void setTimeVenta(long timeVenta) {
        this.timeVenta = timeVenta;
    }
   
    public venta(int cedula, Calendar fecha, int idcaja,int id) {
        this.cedula = cedula;
        this.fecha = fecha;
        this.total = 0;
        this.idcaja = idcaja;
        detalles=new ListaS();
        this.idVenta=id;
    }

    public venta(int cedula, Calendar fecha, int idcaja) {
        this.cedula = cedula;
        this.fecha = fecha;
        this.idcaja = idcaja;
        detalles=new ListaS();
    }
   
    public detalle agregarDetalle(detalle a){
        for(detalle b:detalles){
            if(b.equals(a)){
                b.setCant(b.getCant()+a.cant);
                this.total=this.total+a.getTotal();
                return b;
            }
        }
        detalles.addFin(a);
        
        this.total=this.total+a.getTotal();
        return a;
        
    }
    
    public void EliminarDetalle(int id){
    for(detalle a:detalles){
            if(a.getIdproducto()==id){
                
                this.total=this.total-(a.getTotal());
                detalles.eliminar(a);
                break;
            }
        }
}
    public detalle editar(int id,int cant){
       detalle b = null;
        for(detalle a:detalles){
            if(a.getIdproducto()==id){
                this.total=this.total-a.getTotal();
                a.setCant(cant);                
                a.setTotal(a.getValor()*cant);
                this.total=total+a.getTotal();
                b=a;
                 break ;
            }
        }return b;
    }

    public int getCedula() {
        return cedula;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public int getIdcaja() {
        return idcaja;
    }

    public ListaS<detalle> getDetalles() {
        return detalles;
    }

    public  int getTotal() {
        return total;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    
    @Override
    public String toString() {
        return "venta{" + "cedula=" + cedula + ", fecha=" + fecha + ", total=" + total + ", idcaja=" + idcaja + ", idVenta=" + idVenta + '}';
    }

    
   
    
}
