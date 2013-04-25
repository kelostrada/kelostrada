package Kwiaciarnia2.Flowers;

/**
 * @author bartosz.kalinowski
 */
public class Rose extends Bouquet {

    public Rose(int i) {
        super(i);
    }

    @Override
    public String getName() {
        return "róża";
    }

    @Override
    public String getColor() {
        return "czerwony";
    }
    
}
