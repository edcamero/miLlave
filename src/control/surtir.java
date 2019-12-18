/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author Seifer
 */
public class surtir extends Thread {
    sincronizar sincro;

    public surtir(sincronizar sincro) {
        this.sincro = sincro;
    }

    
    @Override
    public void run()
	{
            while(true){
                  
                    sincro.SurtirTienda();
                  
                }
            }
        
    
}
