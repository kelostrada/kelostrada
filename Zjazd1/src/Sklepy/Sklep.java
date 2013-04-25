package Sklepy;

/**
 *
 * @author s11027
 */
class Sklep {

    private double Stan;
    private double Wydatki;
    private double Dochody;
    private int Numer;
    static double CenaHurtowa;
    static double CenaDetaliczna;
    static int Counter;

    static void setCenaHurtowa(double d) {
        CenaHurtowa = d;
    }

    static void setCenaDetaliczna(double d) {
        CenaDetaliczna = d;
    }

    void kupno(double d) {
        Stan += d;
        Wydatki += d * CenaHurtowa;
    }

    void sprzedaż(double d) {
        if (Stan >= d) {
            Stan -= d;
            Dochody += d * CenaDetaliczna;
        } else {
            System.out.println("Brak takiej ilości na stanie.");
        }
    }

    public Sklep() {
        Stan = 0;
        Wydatki = 0;
        Dochody = 0;
        Numer = ++Counter;
    }

    @Override
    public String toString() {
        return "Sklep nr " + this.Numer + " aktualny stan jabłek " + this.Stan + " kg";
    }

    String ObliczZysk() {
        double Zysk = Dochody - Wydatki;
        return String.valueOf(Zysk);        
    }

    public double getWydatki() {
        return Wydatki;
    }

    public double getDochody() {
        return Dochody;
    }

    public int getNumer() {
        return Numer;
    }

    public double getStan() {
        return Stan;
    }
    
    
}
