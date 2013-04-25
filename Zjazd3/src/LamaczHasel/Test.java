package LamaczHasel;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author bartosz.kalinowski
 */
public class Test {
    public static void main(String[] args) {
        
        if (args.length==0) {
            System.err.println("Należy podać argument zawierający liczbę wątków.");
            System.exit(1);
        }
        
        int watki = Integer.parseInt(args[0]);
        System.out.println("Liczba wątków: " + watki);
        
        WorkersList wl = new WorkersList();
        
        wl.add(new Worker("Bartosz","Kalinowski",new Date(1989,2,1)));
        for (int i=0; i<3; i++) {
            wl.add(Worker.getRandomWorker());
        }
        
        Password password = PasswordGenerator.GenerateRandomPassword(wl);
        LockedRepository lr = new LockedRepository("Tajny Content", password);
        ArrayList<ArrayList<Worker>> workersDivided = wl.getWorkersDivided(watki);
        System.out.println(Arrays.deepToString(workersDivided.toArray()));
        
        Thread[] threads = new Thread[watki];
        
        Thread dialog = new Thread(new DialogPart(lr));
        
        threads[0] = dialog;
        
        for (int i=1; i<watki; i++) {
            threads[i] = new Thread(new PasswordGuesser(workersDivided.get(i-1),lr,i));
        }
        
        for (Thread t : threads) {
            t.start();
        }
    }
}
