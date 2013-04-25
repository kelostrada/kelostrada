package KontaBankowe;

/**
 * @author s11027
 */
public class BankingTest {

    public static void main(String[] args) {
        Person janP = new Person("Jan"), alaP = new Person("Ala");
        BankCustomer jan = new BankCustomer(janP);
        BankCustomer ala = new BankCustomer(alaP);
        jan.getAccount().deposit(1000);
        ala.getAccount().deposit(2000);
        try {
            jan.getAccount().transfer(ala.getAccount(), 500);
        } catch (Exception ex) {
            System.out.println("Błąd: " + ex.getMessage());
        }
        try {
            ala.getAccount().withdraw(1000);
        } catch (Exception ex) {
            System.out.println("Błąd: " + ex.getMessage());
        }
        System.out.println(jan);
        System.out.println(ala);
        Account.setInterestRate(4.5);
        jan.getAccount().addInterest();
        ala.getAccount().addInterest();
        System.out.println(jan);
        System.out.println(ala);
    }
}
