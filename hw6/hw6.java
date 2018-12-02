import java.util.concurrent.*;

public class hw6 {

    public static void main(String[] args) throws InterruptedException{
        //Corrupts the currentAmount as there are times when they try to increment at the same time
        //and therefore the update of one thread is lost
        BankAccount bankAccount = new BankAccount(1000);
        ExecutorService service = Executors.newCachedThreadPool();
        for(int i = 0; i < 700; i++)
            service.submit(() -> bankAccount.deposit(1));
        for(int i = 0; i < 600; i++)
            service.submit(() -> bankAccount.withdraw(1));
        service.shutdown();
        service.awaitTermination(60, TimeUnit.SECONDS);

        System.out.println("Without Synchronization\n" +
                "Expected Amount: 1100");
        System.out.println("Actual Amount:   " + bankAccount.getCurrentAmount());

        
        //Synchronizes threads so that only a single withdraw or deposit can happen at a time
        BankAccount otherBankAccount = new BankAccount(1000);
        ExecutorService otherService = Executors.newCachedThreadPool();
        for(int i = 0; i < 700; i++)
            otherService.submit(() -> otherBankAccount.improvedDeposit(1));
        for(int i = 0; i < 600; i++)
            otherService.submit(() -> otherBankAccount.improvedWithdraw(1));
        otherService.shutdown();
        otherService.awaitTermination(60, TimeUnit.SECONDS);

        System.out.println("\nUsing Synchronization\n" +
                "Expected Amount: 1100");
        System.out.println("Actual Amount:   " + otherBankAccount.getCurrentAmount());
    }
}
