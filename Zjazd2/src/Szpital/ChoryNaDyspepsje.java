package Szpital;

/**
 * @author bartosz.kalinowski
 */
class ChoryNaDyspepsje extends Pacjent {

    public ChoryNaDyspepsje() {
    }
    
    public ChoryNaDyspepsje(String name) {
        super(name);
    }

    @Override
    public String choroba() {
        return "dyspepsja";
    }

    @Override
    public String leczenie() {
        return "węgiel";
    }
    
}
