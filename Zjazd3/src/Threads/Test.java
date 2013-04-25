package Threads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author bartosz.kalinowski
 */
public class Test {

    static class Printer implements Runnable {

        char c;
        long time;
        Referencja r;
        long lasted = 0;

        Printer(char c, long time, Referencja r) {
            this.c = c;
            this.time = time;
            this.r = r;
        }

        @Override
        public void run() {
            while (!r.koniec) {
                try {
                    Thread.sleep(time);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.print(c);
                lasted += time;
                if (lasted>10000 && c == 'A') {
                    this.r.koniec = true;
                }
            }
            System.out.println("Wątek " + c + " skończył działanie.");
        }
    }
    
    static class Referencja {
        boolean koniec = false;
        
        Referencja() {
        }
        
    }

    public static void main(String[] args) {
        Referencja r = new Referencja();
        new Thread(new Printer('A', 3000, r)).start();
        new Thread(new Printer('B', 4000, r)).start();
        new Thread(new Printer('C', 5000, r)).start();
    }
}
