package Kwiaciarnia;

import Kwiaciarnia.Flowers.Bouquet;
import java.util.ArrayList;

/**
 * @author bartosz.kalinowski
 */
public interface Container {
    public ArrayList<Bouquet> getContainer();
    public void add(Bouquet flowers);
}
