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
            Thread.yield();
        } while (!repo.tryUnlock(new Password(password)));

        System.out.println("Wątek nr. " + threadNumber + " zakończył pracę.");
    }
    
}
