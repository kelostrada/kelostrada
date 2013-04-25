package Kwiaciarnia2;

import Kwiaciarnia2.Flowers.Bouquet;
import java.util.ArrayList;

/**
 * @author bartosz.kalinowski
 */
public abstract class Container {
    
    protected ArrayList<Bouquet> container;
    protected Customer owner;
    
    public Container(Customer owner) {
        this.owner = owner;
        container = new ArrayList<>();
    }
    
    public ArrayList<Bouquet> getContainer() {
        return new ArrayList<>(container);
    }
    
    public void add(Bouquet flowers) {
        container.add(flowers);
    }
    
    public abstract String getName();

    @Override
    public String toString() {
        String result = getName() + " własciciel " + owner.getName();
        if (container.isEmpty()) {
            result += " -- pusto";
        }
        result += "\n";
        
        for (Bouquet b : container) {
            result += b.getName() + ", kolor: " + b.getColor() + ", ilość " + b.getCount() + ", cena " + PriceList.getInstance().getPrice(b.getName()) + "\n";
        }
        return result;
    }
    
}
