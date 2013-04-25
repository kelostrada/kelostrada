
package Szpital;

/**
 * @author bartosz.kalinowski
 */
abstract class Pacjent extends Person {
    
    protected String choroba;
    protected String leczenie;
    
    public Pacjent() {
    }
    
    public Pacjent(String name) {
        super(name);
    }
    
    public String nazwisko() {
        return name;
    }
    
    public abstract String choroba();
    public abstract String leczenie();
    
}
