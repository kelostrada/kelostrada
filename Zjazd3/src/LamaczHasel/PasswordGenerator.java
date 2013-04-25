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
    
    public static Password GenerateFromSeed(Worker worker, int seed) {
        return new Password(worker.initials()+sixDigitNumber(seed));       
    }
    
    private static String sixDigitNumber(int number) {
        String result = String.valueOf(number);
        if (number > 999999) {
            result = result.substring(result.length() - 6);
        } else {
            if (number < 100000) {
                result = 0 + result;
            }
            if (number < 10000) {
                result = 0 + result;
            }
            if (number < 1000) {
                result = 0 + result;
            }
            if (number < 100) {
                result = 0 + result;
            }
            if (number < 10) {
                result = 0 + result;
            }
        }

        return result;
    }
}
