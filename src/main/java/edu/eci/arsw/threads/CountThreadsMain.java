/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

/**
 *
 * @author hcadavid
 */
public class CountThreadsMain {
    
    public static void main(String a[]){
        Thread myThread0 = new Thread(new CountThread(0, 99));
        Thread myThread1 = new Thread(new CountThread(99, 199));
        Thread myThread2 = new Thread(new CountThread(199, 299));
        myThread0.start();
        myThread1.start();
        myThread2.start();
    }
    
}
