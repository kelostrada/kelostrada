package Szpital;

/**
 * @author bartosz.kalinowski
 */
class ChoryNaNoge extends Pacjent {
   
    public ChoryNaNoge() {
    }

    public ChoryNaNoge(String name) {
        super(name);
    }

    @Override
    public String choroba() {
        return "noga";
    }

    @Override
    public String leczenie() {
        return "gips";
    }
    
}
