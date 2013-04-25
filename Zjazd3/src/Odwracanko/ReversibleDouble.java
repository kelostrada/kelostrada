package Odwracanko;

/**
 * @author bartosz.kalinowski
 */
class ReversibleDouble implements Reversible {
    
    private double d;
    private double m = 1;

    public ReversibleDouble(double d) {
        this.d = d;
    }

    @Override
    public void reverse() {
        double pom = d;
        d = m;
        m = pom;
    }

    @Override
    public String toString() {
        return String.valueOf(d/m);
    }
    
    public double getValue() {
        return d/m;
    }
    
    
    
}
