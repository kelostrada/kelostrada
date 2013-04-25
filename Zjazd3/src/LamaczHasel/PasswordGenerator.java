package LamaczHasel;

import java.util.Random;

/**
 * @author bartosz.kalinowski
 */

public class PasswordGenerator {
    public static Password Generate(Worker worker) {
        return new Password(worker.toString());
    }
    
    public static Password GenerateRandomPassword(WorkersList workers) {
        Random r = new Random();
        int i = r.nextInt(workers.workers.size());
        return new Password(workers.workers.get(i).toString());
    }
}
