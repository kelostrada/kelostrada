/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Odwracanko;

/**
 *
 * @author bartosz.kalinowski
 */
class ReversibleString implements Reversible {
    
    private String string;

    public ReversibleString(String string) {
        this.string = string;
    }

    @Override
    public void reverse() {
        StringBuilder sb = new StringBuilder(string);
        sb.reverse();
        string = sb.toString();
    }

    @Override
    public String toString() {
        return string;
    }
    
}
