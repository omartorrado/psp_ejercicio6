/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_ejercicio6;

/**
 *
 * @author otorradomiguez
 */
public class Psp_ejercicio6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //CajaB ret= new CajaB("retirada",5);
        //CajaB ing=new CajaB("ingreso",10,ret);
        //ing.start();
        //ret.start();
        /*
        cajaA y cajaB estan mal hechos y no funcionan pq cada hilo tiene su cola, al estar los metodos
        en el propio hilo y no en un objeto al que accedan ambos hilos, como es el caso de cajaC
        */
        
        /*
        Caja c funciona de casualidad, pero no está realmente sincronizado (ver CajaC.java)
        */
        //CajaC caja=new CajaC();
        //CajaCProductor prod=new CajaCProductor(caja);
        //CajaCConsumidor cons=new CajaCConsumidor(caja);
        //prod.start();
        //cons.start();
        
        CajaD caja=new CajaD();
        HiloD productor1=new HiloD(caja,true);
        HiloD consumidor1=new HiloD(caja,false);

        productor1.start();
        consumidor1.start();
    }
    
}
