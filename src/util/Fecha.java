/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author VANESSA
 */
public class Fecha {
    Calendar Cfecha;

    public Fecha() {
    }
    
     public static String Stringfecha(Calendar fecha){
      String fecha2="";
      SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
      fecha2=sdf.format(fecha.getTime());
      return fecha2;
    }
    
    public Calendar Stringfecha(String fecha)  {
     try{ Calendar fecha2=Calendar.getInstance();
      SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
      fecha2.setTime(sdf.parse(fecha));
      return fecha2;
     }catch(ParseException e){
         System.out.print("error en parseo fecha");
         return null;
     }
    }
    
    public static String StringDate(Date fecha)  {
     String fecha2="";
     SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
     fecha2=sdf.format(fecha);
     return fecha2;
    }
    public boolean VerificarRango(Calendar fecha,Calendar rangoA,Calendar rangoB){
     return fecha.after(rangoA)&&fecha.before(rangoB);
    }
    
    public static boolean VerificarRango(Calendar a,Calendar b){
        return a.before(b);
    }
    public Calendar modicarHora(Calendar fecha,String hora){
        return fecha;
    }
    public static long tiempoDeDiferencia(Calendar a,Calendar b){
        long res=b.getTimeInMillis()-a.getTimeInMillis();
        res=res/1000;
        return res;
    }
    
    public String ConvertirHora(long segundos){
        long dia=segundos/(60*60*24);
        segundos=segundos%(60*60*24);
        long horas=segundos/(60*60);
        segundos=segundos%(60*60);
        long min=segundos/60;
        segundos=segundos%60;
        if(dia>1){
            return "dias: "+dia+" Horas: "+horas+" min:"+min+" segundos: "+segundos;
        }
        if(horas>1){
            return "Horas: "+horas+" min:"+min+" segundos: "+segundos;
        }
        if(min>1){
           return " min:"+min+" segundos: "+segundos; 
        }
        return String.valueOf(segundos);
               
    }
     public static int ConvertirDias(long segundos) {
         long dia=segundos/(60*60*24);
         
         return (int)dia;
     }     
            
}
