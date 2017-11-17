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
        HiloD productor1=new HiloD("p1",caja,true);
        HiloD consumidor1=new HiloD("c1",caja,false);

        productor1.start();
        consumidor1.start();
        HiloD productor2=new HiloD("p2",caja,true);
        HiloD consumidor2=new HiloD("c2",caja,false);

        productor2.start();
        consumidor2.start();
        
        HiloD productor3=new HiloD("p3",caja,true);
        HiloD consumidor3=new HiloD("c3",caja,false);

        productor3.start();
        consumidor3.start();
        
        HiloD productor4=new HiloD("p4",caja,true);
        HiloD consumidor4=new HiloD("c4",caja,false);

        productor4.start();
        consumidor4.start();
        
        HiloD productor5=new HiloD("p5",caja,true);
        HiloD consumidor5=new HiloD("c5",caja,false);

        productor5.start();
        consumidor5.start();
        
        HiloD productor6=new HiloD("p6",caja,true);
        HiloD consumidor6=new HiloD("c6",caja,false);

        productor6.start();
        consumidor6.start();
    }
    
}
