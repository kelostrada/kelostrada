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
        while (!repo.tryUnlock(new Password(JOptionPane.showInputDialog("Podaj proponowane hasło")))) {
        }
        System.out.println("Znalazłem hasło ręcznie.");
    }
    
}
