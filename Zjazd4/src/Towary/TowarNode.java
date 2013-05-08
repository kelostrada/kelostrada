package Towary;

/**
 * @author bartosz.kalinowski
 */

public class TowarNode {
    private Towar towar;
    private TowarNode prev = null;
    private TowarNode next = null;
    
    public TowarNode(double w) {
        towar = new Towar(w);
    }
    
    public TowarNode(Towar t) {
        towar = t;
    }
}
