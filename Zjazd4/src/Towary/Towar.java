package Towary;

/**
 * @author bartosz.kalinowski
 */

public class Towar {
    private int id;
    private double weight;
    private static int currentId;
    private static final Object lock = new Object();
    
     public Towar(double weight) {
         synchronized(lock) {
            this.id = currentId++;
            this.weight = weight;
         }
    }
     
     public Towar(int id, double weight) {
         synchronized(lock) {
             this.id = id;
             this.weight = weight;
             if (id > currentId) {
                 currentId = id + 1;
             }
         }
     }
     
     
}
