package LamaczHasel;

import javax.swing.JOptionPane;

/**
 * @author bartosz.kalinowski
 */

public class DialogPart implements Runnable {
    
    LockedRepository repo;
    
    DialogPart(LockedRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run() {
        while (repo.isLocked()) {
            if (repo.tryUnlock(new Password(JOptionPane.showInputDialog("Podaj proponowane hasło")))) {
                System.out.println("Znalazłem hasło ręcznie.");
            }
            if (Thread.interrupted()) {
                    System.out.println("Wątek Dialogowy przerwany.");
                    return;
                }
        }
        System.out.println("Wątek Dialogowy zakończył się.");
    }
    
}
