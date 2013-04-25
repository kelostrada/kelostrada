package Sklepy;


/**
 * @author s11027
 */
public class Test {

    public static void main(String[] args) {

        Sklep.setCenaHurtowa(1.5);
        Sklep.setCenaDetaliczna(3);
        Sklep sklep1 = new Sklep();
        Sklep sklep2 = new Sklep();
        Sklep sklep3 = new Sklep();
        sklep1.kupno(100);
        sklep2.kupno(200);
        sklep3.kupno(300);
        System.out.println("Sklepy: \n" + sklep1 + '\n' + sklep2 + '\n' + sklep3 + '\n');
        sklep1.sprzedaż(95);
        sklep2.sprzedaż(100);
        sklep3.sprzedaż(250);
        podajZyski(sklep1);
        podajZyski(sklep2);
        podajZyski(sklep3);

    }

    private static void podajZyski(Sklep sklep) {        
        System.out.println("Sklep nr " + sklep.getNumer() + " aktualny stan jabłek " + sklep.getStan() + " kg");
        System.out.println("Wydatki: " + sklep.getWydatki());
        System.out.println("Dochody: " + sklep.getDochody());
        System.out.println("Zysk: " + sklep.ObliczZysk());
    }
}

