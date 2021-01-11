/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Dutan2000
 */
public class Mesa implements Runnable{

    private List<Palillo> palillos;
    private List<Filosofo> filosofos;
    private Iterator<Long> times;

    public Mesa(int numeroDeFilosofos) {
        if(numeroDeFilosofos<2){
            System.out.println("no pueden existir pocos filosofos");
        }else{
            palillos=new ArrayList<>();
            filosofos=new ArrayList<>();
            times=new Random().longs(1000, 5000).iterator();
            
            for (int i = 0; i < numeroDeFilosofos; i++) {
                Palillo p=new Palillo();
                palillos.add(p);  
            }
            
            for (int i = 0; i < numeroDeFilosofos; i++) {
                int n=(i+1)%numeroDeFilosofos;
                Palillo izq= palillos.get(i);
                Palillo der=palillos.get(n);
                boolean esZurdo=(n==0);
                
                Filosofo f= new Filosofo(i+1, this, izq, der, esZurdo);
                filosofos.add(f);
            }
        }   
    }
    
    public synchronized long tiempo(){
        return times.next();
    } 
    
    @Override
    public void run() {
        ExecutorService executorService= Executors.newFixedThreadPool(filosofos.size());
        for (Filosofo f : filosofos) {
            executorService.submit(f);
        }
    }
    
}
