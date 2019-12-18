/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author enyer
 */
public class detalle {
   int idproducto,cant,valor,total;
  String nombre;

    public detalle(int idproducto, int cant, int valor, String nombre) {
        this.idproducto = idproducto;
        this.cant = cant;
        this.valor = valor;
        this.nombre = nombre;
        this.total=cant*valor;
    }

     

    public int getIdproducto() {
        return idproducto;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
        this.total=cant*this.valor;
    }

    public int getValor() {
        return valor;
    }

    public int getTotal() {
        return total;
    }
   public String[] getVector(){
       String[] midetalle={String.valueOf(this.idproducto),this.nombre,String.valueOf(this.cant),String.valueOf(this.valor),String.valueOf(this.total)};
       
       return midetalle;
       
   } 

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
              return this.idproducto==((detalle)obj).idproducto;
    }
    public boolean equals(int id) {
              return this.idproducto==id;
    }

    public void setTotal(int total) {
        this.total = total;
    }
   
}
