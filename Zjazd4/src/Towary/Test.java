package Towary;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author bartosz.kalinowski
 */
public class Test {

    static String file = "C:\\Temp\\Towary.txt";
    static TowarList lista = new TowarList();
    static final Object lock = new Object();

    public static void main(String[] args) {
        FileGenerator.GenerateFile(file, 100000);

        Thread reader = new Thread(new Reader());
        reader.start();
        Thread sumator = new Thread(new Sumator(reader));
        sumator.start();

        while (reader.isAlive() || sumator.isAlive()) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    static class Reader implements Runnable {

        int counter;

        @Override
        public void run() {
            try {
                FileReader fstream = new FileReader(file);
                BufferedReader in = new BufferedReader(fstream);
                String line;
                while ((line = in.readLine()) != null) {
                    synchronized (lock) {
                        lista.add(Towar.Parse(line));
                        counter++;
                        if (counter % 200 == 0) {
                            System.out.println("Utworzono " + counter + " obiektów.");
                        }
                    }
                    Thread.yield();
                }
            } catch (FileNotFoundException ex) {
                System.err.println("Błąd odczytu: " + ex.getMessage());
            } catch (IOException ex) {
                System.err.println("Błąd parsowania: " + ex.getMessage());
            }

        }
    }

    static class Sumator implements Runnable {

        Thread reader;
        double suma;
        int counter;

        Sumator(Thread reader) {
            this.reader = reader;
        }

        @Override
        public void run() {
            while (1 == 1) {
                synchronized (lock) {
                    Towar t = lista.get(counter);
                    if (!reader.isAlive()) {
                        if (t == null) {
                            break;
                        } else {
                            suma += t.weight;
                            counter++;
                            if (counter % 100 == 0) {
                                System.out.println("Policzono wagę " + counter + " obiektów.");
                            }
                        }
                    } else {
                        if (t != null) {
                            suma += t.weight;
                            counter++;
                            if (counter % 100 == 0) {
                                System.out.println("Policzono wagę " + counter + " obiektów.");
                            }
                        }
                    }
                }
                Thread.yield();
            }

            System.out.println("Całkowita waga: " + suma + " kg");

        }
    }
}
