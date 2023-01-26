package edu.eci.arsw.math;

import java.util.ArrayList;

public class PiDigitsMain {

    public static void main(String args[]) {
        int start = 0;
        int count = 50000;
        int n = 1;
        ArrayList<Thread> threads = new ArrayList<>();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            Thread t;
            if (i == n-1) {
                t = new Thread(new PiDigits(i*(count/n), (count/n) + (count%n)));
            } else {
                t = new Thread(new PiDigits(i*(count/n), count/n));
            }
            threads.add(t);
            t.start();
            /*try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/
        }
        for(Thread t:threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
        System.out.println(System.currentTimeMillis() - startTime);

    }
}
