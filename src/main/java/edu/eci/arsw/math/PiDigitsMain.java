package edu.eci.arsw.math;

import java.util.ArrayList;

public class PiDigitsMain {

    public static void main(String args[]) {
        int start = 0;
        int count = 5000;
        int range = count-start;
        int n = 3; // NUMERO DE HILOS
        ArrayList<Thread> threads = new ArrayList<>();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            Thread t;
            if (i == n-1) {
                System.out.println("START_: " + (i*(range/n) + start));
                System.out.println("COUNT_ : " + ((range/n) + (range%n)));
                t = new Thread(new PiDigits((i*(range/n) + start), (range/n) + (range%n)));
            } else {
                System.out.println("START: " + (i*(range/n) + start));
                System.out.println("COUNT : " + range/n);
                t = new Thread(new PiDigits((i*(range/n) + start), range/n));
            }
            threads.add(t);
            t.start();
        }
        for(Thread tr:threads){
            try {
                tr.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
