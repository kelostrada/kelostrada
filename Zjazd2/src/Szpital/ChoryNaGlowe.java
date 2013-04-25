package Szpital;

/**
 * @author bartosz.kalinowski
 */
class ChoryNaGlowe extends Pacjent {
    
    public ChoryNaGlowe() {
    }
    
    public ChoryNaGlowe(String name) {
        super(name);
    }

    @Override
    public String choroba() {
        return "głowa";
    }

    @Override
    public String leczenie() {
        return "aspiryna";
    }
    
}
