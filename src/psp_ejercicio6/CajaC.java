/*
 Esto funciona, pero no esta realmente syncronizado. Al sincronizar lo que sincronizas es el metodo.
Cualquier hilo que llame a ese metodo se meteria en la cola del metodo, tal como lo tengo hecho hay 
dos colas, una del metodo ingresar y otra del metodo retirar. Funciona de cierta manera, pq el while
de retirar sale del wait() cuando el saldo es suficiente, no pq reciba el notify de ingresar()
 */
package psp_ejercicio6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author otorradomiguez
 */
public class CajaC{
    int caja = 10;
    
    public synchronized void ingreso(int cantidad){
        System.out.println("Se realiza un ingreso de "+cantidad);
        caja+=cantidad;
        notify();
        System.out.println("Saldo actual: "+caja);
    }
    
    public synchronized void retirada(int cantidad){
        System.out.println("Se desea realizar una retirada de "+cantidad);
        while(caja<cantidad){            
            try {
                System.out.println("Saldo insuficiente, faltan "+(cantidad-caja));
                wait();                
            } catch (InterruptedException ex) {
                Logger.getLogger(CajaC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Saldo Suficiente: "+caja);
        System.out.println("Se realiza una retirada de "+cantidad);
        caja-=cantidad;
        System.out.println("Saldo actual: "+caja);

    }
}
