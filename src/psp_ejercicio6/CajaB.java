/*
Esto no funciona!!!!!!
 */
package psp_ejercicio6;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author otorradomiguez
 */
public class CajaB extends Thread {

    static int caja = 100;
    int vueltas = 0;
    Random rd = new Random();
    CajaB otraCaja;

    public CajaB(String nombre, int vueltas, CajaB b) {
        super(nombre);
        this.vueltas = vueltas;
        this.otraCaja = b;
    }
    
    public CajaB(String nombre, int vueltas) {
        super(nombre);
        this.vueltas = vueltas;
    }

    @Override
    public void run() {
        ingresoRetirada(this.getName());
    }

    public synchronized void ingresoRetirada(String modo) {
        for (int i = 0; i < vueltas; i++) {
            if (modo.equals("ingreso")) {
                int ingreso = rd.nextInt(20);
                caja += ingreso;
                System.out.println("Se ha realizado el ingreso nº " + i + " de " + ingreso + "€");
                System.out.println("Saldo tras ingreso: " + caja);
                try {
                    otraCaja.notify();
                } catch (IllegalMonitorStateException ex) {
                    Logger.getLogger(CajaB.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (modo.equals("retirada")) {
                int retirada = rd.nextInt(100);
                System.out.println("Se quiere realizar una retirada de " + retirada + "€");
                while (retirada > caja) {
                    try {
                        System.out.println("Saldo insuficiente, esperando fondos");
                        wait();
                        System.out.println("Fondos suficientes");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CajaB.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                caja -= retirada;
                System.out.println("Se ha realizado la retirada nº " + i + " de " + retirada + "€");
                System.out.println("Saldo tras retirada: " + caja);
            } else {
                System.out.println("Modo erroneo, debe ser ingreso o retirada");
            }
        }
    }
}
