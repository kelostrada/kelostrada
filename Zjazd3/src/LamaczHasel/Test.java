package LamaczHasel;

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
        for (int i=0; i<15; i++) {
            wl.add(Worker.getRandomWorker());
        }
        
        LockedRepository lr = new LockedRepository("Tajny Content", PasswordGenerator.GenerateRandomPassword(wl));
        
        
       
        
        System.out.print(Arrays.deepToString(wl.getWorkersDivided(3).toArray()));
    }
}
