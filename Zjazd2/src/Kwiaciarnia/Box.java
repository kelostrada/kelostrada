package Kwiaciarnia;

import Kwiaciarnia.Flowers.Bouquet;
import java.util.ArrayList;

/**
 * @author bartosz.kalinowski
 */
class Box implements Container {
    
    private Customer owner;
    private ArrayList<Bouquet> box;

    Box(Customer owner) {
        this.owner = owner;
        box = new ArrayList<>();
    }

    @Override
    public String toString() {
        String result = "Pudełko własciciel " + owner.getName();
        if (box.isEmpty()) {
            result += " -- pusto";
        }
        result += "\n";
        
        for (Bouquet b : box) {
            result += b.getName() + ", kolor: " + b.getColor() + ", ilość " + b.getCount() + ", cena " + PriceList.getInstance().getPrice(b.getName()) + "\n";
        }
        
        
        return result;
    }
    
    @Override
    public void add(Bouquet flowers) {
        box.add(flowers);
    }
    
    @Override
    public ArrayList<Bouquet> getContainer() {
        return new ArrayList<>(box);
    }
    
}
