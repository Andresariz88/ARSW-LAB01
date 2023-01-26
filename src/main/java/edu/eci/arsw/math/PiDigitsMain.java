package edu.eci.arsw.math;

public class PiDigitsMain {

    public static void main(String args[]) {
        int start = 0;
        int count = 10;
        int n = 2;

        for (int i = 0; i < n; i++) {
            Thread t = new Thread(new PiDigits(i*(count/n), count));
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        /*Thread t = new Thread(new PiDigits(0, 5));
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t = new Thread(new PiDigits(5, 5));
        t.start();*/

    }
}
