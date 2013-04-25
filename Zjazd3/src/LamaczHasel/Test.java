package LamaczHasel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author bartosz.kalinowski
 */
public class Test {
    public static void main(String[] args) {
        
        /* Muszą być argumenty programu */
        if (args.length<2) {
            System.err.println("Należy podać argument zawierający liczbę wątków oraz liczbę pracowników.");
            System.err.println("PRZYKŁAD: java LamaczHasel.jar 4 100 1");
            System.exit(1);
        }
        
        int watki = Integer.parseInt(args[0]);
        System.out.println("Liczba wątków: " + watki);
        
        int pracownicy = Integer.parseInt(args[1]);
        System.out.println("Liczba pracowników: " + pracownicy);
        
        boolean czyLosoweHaslo = true;
        
        if (args.length > 2) {
            if (Integer.parseInt(args[1]) == 1) {
                czyLosoweHaslo = false;
            }
        }
        
        /* Generowanie listy pracowników (losowo) */
        WorkersList wl = new WorkersList();
        
        //wl.add(new Worker("Bartosz","Kalinowski",new Date(1989,2,1)));
        for (int i=0; i<pracownicy; i++) {
            wl.add(Worker.getRandomWorker());
        }
        
        /* Podzielenie listy pracowników na mniejsze listy, zależnie od ilości wątków (każdy wątek dostaje mniej więcej równą liczbę pracowników do sprawdzenia */
        ArrayList<ArrayList<Worker>> workersDivided = wl.getWorkersDivided(watki);
        System.out.println(Arrays.deepToString(workersDivided.toArray()));
        
        /* Generowanie hasła (można odkomentować, żeby brać hasło wygenerowane z ostatniego pracownika (teoretycznie najdłuższe obliczenia) */
        Password password = PasswordGenerator.GenerateRandomPassword(wl);
        if (!czyLosoweHaslo) {
            password = new Password(workersDivided.get(workersDivided.size()-1).get(workersDivided.get(workersDivided.size()-1).size()-1).toString());
        }
        LockedRepository lr = new LockedRepository("Tajny Content", password);
        
        
        
        Thread[] threads = new Thread[watki+1];
        
        Thread dialog = new Thread(new DialogPart(lr));
        
        threads[0] = dialog;
        
        for (int i=1; i<=watki; i++) {
            threads[i] = new Thread(new PasswordGuesser(workersDivided.get(i-1),lr,i));
        }
        long start = System.currentTimeMillis();
        for (Thread t : threads) {
            t.start();
        }
        
        
        while (lr.locked) {
            Thread.yield();
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        for (Thread t : threads) {
            t.interrupt();
        }
        
        long elapsedTimeMillis = System.currentTimeMillis()-start;
        System.out.println("Program szukał hasła przez: " + elapsedTimeMillis/1000F + " sekund.");
    }
}
