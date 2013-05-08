package Towary;

/**
 * @author bartosz.kalinowski
 */

public class TowarNode {
    Towar towar;
    TowarNode prev = null;
    TowarNode next = null;
    
    public TowarNode(double w) {
        towar = new Towar(w);
    }
    
    public TowarNode(Towar t) {
        towar = t;
    }

    @Override
    public String toString() {
        return towar.toString();
    }
    
    
}
