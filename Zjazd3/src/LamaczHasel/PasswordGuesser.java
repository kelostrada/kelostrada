package LamaczHasel;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author bartosz.kalinowski
 */
public class PasswordGuesser implements Runnable {

    private ArrayList<Worker> workers;
    LockedRepository repo;
    private int threadNumber;

    PasswordGuesser(ArrayList<Worker> workers, LockedRepository repo, int threadNumber) {
        this.workers = workers;
        this.repo = repo;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        System.out.println("Wątek nr. " + threadNumber + " rozpoczął pracę.");
        String password = "";
        do {
            
            for (Worker w : workers) {
                System.out.println("Wątek nr. " + threadNumber + " obsługuje pracownika: " + w);
                for (int i=0; i<1000000; i++) {
                    if (repo.tryUnlock(PasswordGenerator.GenerateFromSeed(w, i))) {
                        
                        System.out.println("Wątek nr. " + threadNumber + " zakończył pracę i znalazł hasło.");
                        Thread.yield();
                        return;
                    }
                }
                
            }
            Thread.yield();
        } while (repo.isLocked());

        System.out.println("Wątek nr. " + threadNumber + " zakończył pracę.");
    }

    
}
