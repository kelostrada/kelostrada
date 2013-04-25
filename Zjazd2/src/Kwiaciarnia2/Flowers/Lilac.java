package Kwiaciarnia2.Flowers;

/**
 * @author bartosz.kalinowski
 */
public class Lilac extends Bouquet {

    public Lilac(int i) {
        super(i);
    }

    @Override
    public String getName() {
        return "bez";
    }

    @Override
    public String getColor() {
        return "biały";
    }
    
}
