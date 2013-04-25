package Kwiaciarnia.Flowers;

/**
 * @author bartosz.kalinowski
 */
public abstract class Bouquet {
    int count;
    
    public Bouquet(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public abstract String getName();
    public abstract String getColor();
}
