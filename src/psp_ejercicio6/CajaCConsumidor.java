/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_ejercicio6;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author otorradomiguez
 */
public class CajaCConsumidor extends Thread {
    CajaC balance;
    Random rd = new Random();
    
    public CajaCConsumidor(CajaC caja){
        balance=caja;
    }
    
    @Override
    public void run() {
        for(int i=0;i<5;i++){
        balance.retirada(rd.nextInt(50));
            try {
                sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(CajaCConsumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
