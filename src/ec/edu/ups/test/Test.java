/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.test;

import ec.edu.ups.modelo.Mesa;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dutan2000
 */
public class Test {
    public static void main(String [] args) throws InterruptedException {
        
            Scanner input=new Scanner(System.in);
            System.out.println("Ingrese el numero de filosofos que desea");
            int numero =input.nextInt();
            Mesa mesa=new Mesa(numero);
            Thread cena =new Thread(mesa);
            
            cena.start();
            cena.join();
        
    }
}
