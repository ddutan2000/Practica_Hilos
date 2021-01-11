/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dutan2000
 */
public class Filosofo implements Runnable{
    
    private int id;
    private Mesa mesa;
    private Palillo izq, der;
    private boolean esZurdo;

    public Filosofo(int id, Mesa mesa, Palillo izq, Palillo der, boolean esZurdo) {
        this.id = id;
        this.mesa = mesa;
        this.izq = izq;
        this.der = der;
        this.esZurdo = esZurdo;
    }
    
    public void pensar() {
        long tiempo =mesa.tiempo();
        System.out.println("filosofo " + id + " esta pensando por un tiempo de: " +tiempo);
        pasarTiempo(tiempo);
    }
    
    public void comer(){
        quitarPalillo();
        long tiempo=mesa.tiempo();
        System.out.println("filosofo " + id + " esta comiendo por un tiempo de: " +tiempo);
        pasarTiempo(tiempo);
        devolverPalillo();
    }
    
    @Override
    public void run() {
        while(true){
            pensar();
            comer();
        }
    }
    
    private void quitarPalillo(){
        if(esZurdo){
            izq.quitarPalillo();
            der.quitarPalillo();
        }else{
           der.quitarPalillo();  
           izq.quitarPalillo(); 
        }
    }
    
    private void devolverPalillo(){
        if(esZurdo){
            izq.devolverPalillo();
            der.devolverPalillo();
        }else{
           der.devolverPalillo();
           izq.devolverPalillo();
        }
    }
    
    private void pasarTiempo(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }
    
}
