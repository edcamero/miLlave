/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author VANESSA
 * @param <T> cola generica
 */
public class Cola <T>{
    Nodo ult;
    int size;

    public Cola() {
        ult=null;
        size=0;
    }

    public int getSize() {
        return size;
    }
    public boolean isVacia(){
        if(ult==null)
            return true;
        return false;
    }
   public void add(T info) {
      Nodo aux=new Nodo(info);
       if(ult==null){
           ult=aux;
           ult.setSig(ult);
           
           }else{
           aux.setSig(ult.getSig());
           ult.setSig(aux);
           ult=aux;
       }
       size++;
   }
   public void addOrdenado(T info){
   

       if (this.isVacia())
            this.add(info);
        
        else {
            Nodo x=ult.getSig();
            Nodo y=x;
            while(y!=ult){
                
                Comparable comparador=(Comparable)info;
                    int rta=comparador.compareTo(x.getInfo());
                    
                    if(rta>0)
                        break;
                    y=x;
                    x=x.getSig();
                    
            }if(y==x){
                this.add(info);
            }else{
                y.setSig(new Nodo(info));
                y.getSig().setSig(x);
                this.size++;

            }
                
            
            
        }

   }
   public String ToString(){
       
       String msg="";
       if(this.isVacia()){
           return msg;
       }else{
       Nodo aux=ult.getSig();
       while(aux!=ult){
           msg+=aux.getInfo().toString()+" ";
           aux=aux.getSig();
       }
       
            msg+=aux.getInfo().toString()+" ";
       
       return msg;
       
   }
   }
   public T desencolar(){
       if(!this.isVacia()){
           if(ult!=ult.getSig()){
               Nodo pri=ult.getSig();
               ult.setSig(pri.getSig());
               size--;
               return (T) pri.getInfo();
           }else{
               T dato=(T) ult.getInfo();
               ult=null;
               size--;
               return dato;
           }
       }
       return null;
   }
   
   public void borrarCola(){
       ult=null;
       size=0;
   }
}
