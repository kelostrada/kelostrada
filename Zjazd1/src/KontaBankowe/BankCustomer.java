/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KontaBankowe;

/**
 *
 * @author s11027
 */
public class BankCustomer {
    private Account account;
    private Person person;

    public BankCustomer(Person person) {
        this.person = person;
        this.account = new Account();
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "Klient: " + person.getName() + " stan konta " + account.getAccount();
    }
    
}
