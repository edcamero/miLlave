package util;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Escribir {

    public  void guardar_texto(String area,String dir) {
        try {
            File archivo = new File(dir);

            if (archivo.exists()) {
                if  (archivo.delete())
                {
//                    System.out.println("El fichero borrado");
                }
                else
                {
//                    System.out.println("El fichero no se pudo borrar");
                }
            }
            try (FileWriter escribir = new FileWriter(archivo, true)) {
                escribir.write(area);
            }
        } catch (IOException e) {
            System.out.println("Error al escribir");
        }
    }
    
    public void guardarExcel(String area,String dir){
        String a=area.replace(',', '\t');
        try {
            File archivo = new File(dir);

            if (archivo.exists()) {
                if  (archivo.delete())
                {
//                    System.out.println("El fichero borrado");
                }
                else
                {
//                    System.out.println("El fichero no se pudo borrar");
                }
            }
            try (FileWriter escribir = new FileWriter(archivo, true)) {
                escribir.write(a);
            }
        } catch (IOException e) {
            System.out.println("Error al escribir");
        }
    }
    
    
public void abrirDocumento(String dir){
       
     try{   
       File path=new File(dir);
       Desktop.getDesktop().open(path);
       
        
     }catch(IOException e){
         e.printStackTrace();
     }catch(IllegalArgumentException e){
         JOptionPane.showMessageDialog(null, "no se encontro la direccion");
     }
    }

}
