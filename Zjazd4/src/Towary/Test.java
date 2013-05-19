package Towary;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Date;

/**
 * @author bartosz.kalinowski
 */
public class Test {

    static String file = "C:\\Temp\\Towary.txt";
    static TowarList lista = new TowarList();
    static final Object lock = new Object();
    static long czas;

    public static void main(String[] args) {
        //FileGenerator.GenerateFile(file, 1000000);

        Thread reader = new Thread(new Reader());
        Thread sumator = new Thread(new Sumator(reader));
        czas = new Date().getTime();
        reader.start();
        sumator.start();

    }

    static class Reader implements Runnable {

        int counter;

        @Override
        public void run() {
            try {
                /*
                FileInputStream fis = new FileInputStream(file);
                FileChannel fileChannel = fis.getChannel();
                ByteBuffer byteBuffer = ByteBuffer.allocate(50241024);

                int bytes = fileChannel.read(byteBuffer);
                int i = 0;
                StringBuilder s = new StringBuilder("");
                
                while (bytes != -1) {
                    byteBuffer.flip();
                    
                    while (byteBuffer.hasRemaining()) {
                        char c = (char) byteBuffer.get();
                        if (c != '\n') {
                            s.append(c);
                        } else {
                            synchronized (lock) {
                                lista.push(Towar.Parse(s.toString()));
                                counter++;
                                if (counter % 200 == 0) {
                                    System.out.println("Utworzono " + counter + " obiektów.");
                                }
                            }
                            s.delete(0, s.length());
                        }
                    }
                    byteBuffer.clear();
                    bytes = fileChannel.read(byteBuffer);
                    i++;
                }
                if (fis != null) {
                    fis.close();
                }
                */
                
                FileReader fstream = new FileReader(file);
                BufferedReader in = new BufferedReader(fstream);
                String line;
                while ((line = in.readLine()) != null) {
                    synchronized (lock) {
                        lista.push(Towar.Parse(line));
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
            System.out.println("Czas :" + (new Date().getTime() - czas));
        }
    }

    static class Sumator implements Runnable {

        Thread reader;
        double suma;
        int counter = 0;

        Sumator(Thread reader) {
            this.reader = reader;
        }

        @Override
        public void run() {
            while (1 == 1) {
                synchronized (lock) {
                    Towar t = lista.popBack();
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
            System.out.println("Czas :" + (new Date().getTime() - czas));

        }
    }
}
