/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Szpital;

/**
 *
 * @author s11027
 */
public class Person {
    
    protected String name;
    
    public Person() {
        this.name = "noname";
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
