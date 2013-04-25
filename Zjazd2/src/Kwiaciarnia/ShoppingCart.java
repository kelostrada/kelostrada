package Kwiaciarnia;

import Kwiaciarnia.Flowers.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * @author bartosz.kalinowski
 */
class ShoppingCart implements Container {

    private LinkedHashMap<Bouquet, Boolean> cart;
    private Customer owner;

    public ShoppingCart(Customer owner) {
        cart = new LinkedHashMap<>();
        this.owner = owner;
    }

    @Override
    public void add(Bouquet flowers) {
        cart.put(flowers, false);
    }

    @Override
    public String toString() {
        String result = "Wózek właściciel " + owner.getName();
        
        if (cart.isEmpty()) {
            result += " -- pusto";
        }
        
        result += "\n";
        for (Bouquet b : cart.keySet()) {
            result += b.getName() + ", kolor: " + b.getColor() + ", ilość " + b.getCount() + ", cena " + PriceList.getInstance().getPrice(b.getName()) + "\n";
        }

        return result;
    }

    public double pay(double cash) {
        double cost = 0;

        Iterator<Bouquet> it = cart.keySet().iterator();

        while (it.hasNext()) {
            Bouquet b = it.next();
            if (!PriceList.INSTANCE.containsPrice(b.getName())) {
                it.remove();
            } else {
                double itemCost = b.getCount() * PriceList.INSTANCE.getPrice(b.getName());
                if (cost + itemCost > cash) {
                    return cost;
                } else if (!cart.get(b)) {
                    cost += itemCost;
                    cart.put(b, true);
                }

            }
        }

        return cost;
    }
    
    public void pack(Box box) {
        Iterator<Bouquet> it = cart.keySet().iterator();
        
        while (it.hasNext()) {
            Bouquet b = it.next();
            if (cart.get(b)) {
                box.add(b);
                it.remove();
            }
        }
    }

    @Override
    public ArrayList<Bouquet> getContainer() {
        ArrayList<Bouquet> container = new ArrayList<>(cart.keySet());
        return container;
    }
}
