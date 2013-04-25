package Kwiaciarnia.Flowers;


/**
 * @author bartosz.kalinowski
 */
public class Freesia extends Bouquet {

    public Freesia(int i) {
        super(i);
    }

    @Override
    public String getName() {
        return "frezja";
    }

    @Override
    public String getColor() {
        return "żółty";
    }
    
}
