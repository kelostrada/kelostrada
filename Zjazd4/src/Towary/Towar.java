package Towary;

/**
 * @author bartosz.kalinowski
 */

public class Towar {
    private int id;
    double weight;
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

    @Override
    public String toString() {
        return "" + id + " " + weight;
    }
    
    public static Towar Parse(String text) throws NumberFormatException {
        String[] dane = text.split(" ");
        if (dane.length != 2) {
            throw new NumberFormatException("Błędne wyrażenie");
        }
        return new Towar(Integer.parseInt(dane[0]),Double.parseDouble(dane[1]));
    }
}
