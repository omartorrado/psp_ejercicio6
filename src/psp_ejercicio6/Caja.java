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
public class Caja extends Thread {

    static int caja = 100;
    int vueltas = 0;
    Random rd = new Random();

    public Caja(String nombre) {
        super(nombre);
    }

    @Override
    public synchronized void run() {
        System.out.println(this.getName());

        switch (this.getName()) {
            case "ingreso":
                for (vueltas = 0; vueltas < 10; vueltas++) {
                    ingreso(rd.nextInt(20));
                    System.out.println("Ingreso nº " + (vueltas + 1));
                    try {
                        sleep(rd.nextInt(500));
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Caja.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                System.out.println("Balance final ingreso: " + caja);
                notify();
                break;
            case "retirada":
                for (vueltas = 0; vueltas < 5; vueltas++) {
                    int cantidad = rd.nextInt(100);
                    System.out.println("Se quiere realizar una retirada de " + cantidad);
                    while (caja < cantidad) {
                        System.out.println(this.getName() + " está esperando por saldo");
                        try {
                            wait();
                            System.out.println("Dejo de esperar");
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Caja.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    retirada(cantidad);
                    System.out.println("Retirada nº " + (vueltas + 1));
                    try {
                        sleep(rd.nextInt(500));
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Caja.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("Balance final retirada: " + caja);
                break;
            default:
                System.out.println("Error en el nombre del hilo, debe ser 'ingreso' o 'retirada'");
                break;
        }

    }

    public void ingreso(int cantidad) {
        System.out.println("Se realiza un ingreso de " + cantidad);
        caja += cantidad;
        System.out.println("Balance tras ingreso: " + caja);

    }

    public void retirada(int cantidad) {
        caja -= cantidad;
        System.out.println("Balance tras retirada: " + caja);

    }
}
