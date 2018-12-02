public class BankAccount {
    private int currentAmount;

    public BankAccount(int currentAmount) {
        this.currentAmount = currentAmount;
    }

    public int getCurrentAmount() {
        return currentAmount;
    }

    public void deposit(int currentAmount) {
        this.currentAmount += currentAmount;
    }

    public void withdraw(int currentAmount){
        this.currentAmount -= currentAmount;
    }

    public synchronized void improvedDeposit(int amount){
        this.currentAmount += amount;
    }

    public synchronized void improvedWithdraw(int amount){
        this.currentAmount -= amount;
    }
}
