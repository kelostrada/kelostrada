package Kwiaciarnia2;

import Kwiaciarnia2.Flowers.*;
import java.util.Iterator;

/**
 * @author bartosz.kalinowski
 */
class ShoppingCart extends Container {

    private boolean isPaid;

    public ShoppingCart(Customer owner) {
        super(owner);
    }

    public double pay(double cash) {
        double cost = 0;

        if (!isPaid) {

            Iterator<Bouquet> it = container.iterator();

            while (it.hasNext()) {
                Bouquet b = it.next();
                if (!PriceList.INSTANCE.containsPrice(b.getName())) {
                    it.remove();
                } else {
                    double itemCost = b.getCount() * PriceList.INSTANCE.getPrice(b.getName());
                    if (cost + itemCost > cash) {
                        it.remove();
                    } else {
                        cost += itemCost;
                    }

                }
            }

            isPaid = true;
        }

        return cost;
    }

    public void pack(Box box) throws Exception {
        if (isPaid) {
            Iterator<Bouquet> it = container.iterator();
            while (it.hasNext()) {
                Bouquet b = it.next();
                box.add(b);
                it.remove();
            }
        } else {
            throw new Exception("Nie zapłacono mendo!");
        }
    }

    @Override
    public String getName() {
        return "Wózek";
    }
}
