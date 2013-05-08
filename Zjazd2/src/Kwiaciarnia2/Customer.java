package Kwiaciarnia2;

import Kwiaciarnia2.Flowers.*;

/**
 * @author bartosz.kalinowski
 */
class Customer extends Person {
    
    private double cash;
    private ShoppingCart shoppingCart;

    public Customer(String name, double i) {
        super(name);
        cash = i;
        shoppingCart = new ShoppingCart(this);
    }
    
    public void get(Bouquet flowers) {
        shoppingCart.add(flowers);
    }

    public ShoppingCart getShoppingCart() {
        return this.shoppingCart;
    }

    public void pay() {
        cash -= shoppingCart.pay(cash);
    }

    public String getCash() {
        return String.valueOf(cash);
    }

    public void pack(Box box) throws Exception {
        shoppingCart.pack(box);
    }

    public void addFunds(double d) {
        cash += d;
    }
    
}
