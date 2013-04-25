package Kwiaciarnia2.Flowers;

/**
 * @author bartosz.kalinowski
 */
public class Peony extends Bouquet {

    public Peony(int i) {
        super(i);
    }

    @Override
    public String getName() {
        return "piwonia";
    }

    @Override
    public String getColor() {
        return "czerwony";
    }
    
}
