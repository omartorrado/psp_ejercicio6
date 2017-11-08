/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_ejercicio6;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author otorradomiguez
 */
public class CajaCProductor extends Thread{
    CajaC balance;
    Random rd = new Random();

    public CajaCProductor(CajaC c) {
        balance=c;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
        balance.ingreso(rd.nextInt(20));
        try {
                sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(CajaCConsumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
