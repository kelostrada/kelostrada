package Kwiaciarnia2;

/**
 * @author bartosz.kalinowski
 */
class Box extends Container {

    public Box(Customer owner) {
        super(owner);
    }

    @Override
    public String getName() {
        return "Pudełko";
    }
    
}
