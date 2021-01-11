/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Dutan2000
 */
public class Palillo {
    
    private ReentrantLock llave;

    public Palillo() {
        llave=new ReentrantLock();
    }
    
    public void quitarPalillo(){
        llave.lock();
    }
    
    public void devolverPalillo(){
        if(!palilloOcupado())
            return;
        llave.unlock();
        
    }
    
    public boolean palilloOcupado(){
        return llave.isHeldByCurrentThread();
    }
    
    
}
