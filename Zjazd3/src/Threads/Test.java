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

        Printer(char c, long time) {
            this.c = c;
            this.time = time;
        }

        @Override
        public void run() {
            while (1 == 1) {
                try {
                    Thread.sleep(time);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.print(c);
                
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Printer('A', 3000)).start();
        new Thread(new Printer('B', 4000)).start();
        new Thread(new Printer('C', 5000)).start();
    }
}
