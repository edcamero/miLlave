/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import util.ListaS;

/**
 *
 * @author enyer
 */
public class Cliente {
    int cedula;
    String nombre;
    String apellido;
    
    ListaS<detalle> detalles=new ListaS();

    public Cliente(int cedula, String nombre, String apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Cliente(int cedula) {
        this.cedula = cedula;
    }

    public int getCedula() {
        return cedula;
    }

    public ListaS<detalle> getDetalles() {
        return detalles;
    }

    public void agregarDetalles(detalle d){
        detalles.addFin(d);
    }
    
}
