import java.util.Comparator;

/**
 * Created by Aaron on 9/30/2018.
 */
public class BankAccountCompare implements Comparable<BankAccountCompare>{
    private double accountBalance;
    private String accountHolder;

    public BankAccountCompare() {
        this.accountBalance = 0;
        this.accountHolder = "";
    }

    public BankAccountCompare(double accountBalance, String accountHolder) {
        this.accountBalance = accountBalance;
        this.accountHolder = accountHolder;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    @Override
    public String toString() {
        return accountHolder;
    }

    public int compareTo(BankAccountCompare o){
        return Double.compare(this.accountBalance, o.accountBalance);
    }
}
