package KontaBankowe;

/**
 * @author s11027
 */
public class Account {
    
    private static double InterestRate;
    private double account;
    
    public Account() {
        account = 0;
    }
    
    public Account(double account) {
        this.account = account;
    }

    public static void setInterestRate(double d) {
        InterestRate = d;
    }
    
    public void deposit(double d) {
        account += d;
    }

    public void transfer(Account account, double d) throws Exception {
        if (this.account < d) {
            throw new Exception("Transfer nie możliwy, za mało środków na koncie.");
        } else {
            account.deposit(d);
            this.withdraw(d);
        }
    }

    void withdraw(double d) throws Exception {
        if (this.account < d) {
            throw new Exception("Wypłata nie wykonalna, za mało środków na koncie.");
        } else {
            this.account -= d;
        }
    }

    void addInterest() {
        this.account *= (1 + InterestRate/100);
    }

    public double getAccount() {
        return account;
    }
    
    
}
