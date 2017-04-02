/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlos
 */
public class Tiempo extends Thread {

    private int minuto = 0;
    private int segundo = 0;
    public boolean detener = true;
private String[] t;

    public Tiempo(String[] tiempo){
    this.t=tiempo;

    }
    @Override
    public void run() {

 System.out.print(" entro al hilo");
        while (detener) {
            for (int i = 0; i < 60; i++) {
                this.minuto = i;

            }
            for (int j = 0; j < 60; j++) {
                try {
                    this.segundo = j;
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Tiempo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
       
        t[0] =" " + this.minuto + " : " + this.segundo;
    }
}
