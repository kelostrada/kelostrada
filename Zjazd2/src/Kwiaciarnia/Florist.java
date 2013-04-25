package Kwiaciarnia;

/**
 * @author bartosz.kalinowski
 */
public class Florist {

    public Florist() {
        // Ustalenie cennika
        PriceList pl = PriceList.getInstance();
        pl.set("róża", 10);
        pl.set("bez", 12);
        pl.set("piwonia", 8);
    }
}
