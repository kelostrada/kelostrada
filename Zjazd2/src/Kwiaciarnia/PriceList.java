package Kwiaciarnia;

import java.util.HashMap;

/**
 * @author bartosz.kalinowski
 */
class PriceList {
    
    static final PriceList INSTANCE = new PriceList();
    
    private HashMap<String,Integer> prices;
    
    private PriceList() {
        prices = new HashMap<>();
    }

    public static PriceList getInstance() {
        return INSTANCE;
    }
    
    public void set(String name, int price) {
        prices.put(name, price);
    }

    public double getPrice(String name) {
        return (prices.containsKey(name))?prices.get(name):-1;
    }
    
    public boolean containsPrice(String name) {
        return prices.containsKey(name);
    }
    
}
