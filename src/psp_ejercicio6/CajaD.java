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
public class CajaD {
    int balance=0;
    
    public synchronized void balance(boolean ingresar,String threadName){
        if(ingresar){
            balance+=1;
            System.out.println("Balance tras producir: "+balance);
            notify();            
        }else{
            if(balance<1){
                try {                    
                    System.out.println("Esperando fondos");
                    wait();
                    System.out.println(threadName+" ha dejado de esperar");
                } catch (InterruptedException ex) {
                    Logger.getLogger(CajaD.class.getName()).log(Level.SEVERE, null, ex);
                }                
            }
            balance-=1;
            System.out.println("Balance tras retirar: "+balance);
        }
    }
    
}
