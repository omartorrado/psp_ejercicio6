/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_ejercicio6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author otorradomiguez
 */
public class HiloD extends Thread{
    CajaD caja;
    boolean productor;
    
    public HiloD(String nombre,CajaD c,boolean prod){
        super(nombre);
        caja=c;
        productor=prod;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("Hilo:"+this.getName());
            caja.balance(productor,this.getName());
            try {
                sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Hilo "+this.getName()+" finalizado");
    }
    
    
    
}
