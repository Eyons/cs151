import java.util.ArrayList;
import java.util.Collections;

public class Problems1and2 {

    public static void main(String[] args) {
        DateSinceBirth dateSinceBirth = new DateSinceBirth();
        System.out.println("Problem 1:\nDays since birth: " + dateSinceBirth.getDaysSinceBirth());

        ArrayList<BankAccountCompare> accounts = new ArrayList<>();
        accounts.add(new BankAccountCompare(12, "Jim"));
        accounts.add(new BankAccountCompare(63, "Bob"));
        accounts.add(new BankAccountCompare(54, "Kayle"));
        accounts.add(new BankAccountCompare(5, "Kjan"));
        accounts.add(new BankAccountCompare(1, "Leian"));
        accounts.add(new BankAccountCompare(84, "Jkan"));
        accounts.add(new BankAccountCompare(42, "Mna"));

        System.out.println("\nProblem 2:\nBefore sort: ");
        System.out.println(accounts);
        Collections.sort(accounts);
        System.out.println("Expected: Leian, Kjan, Jim, Mna, Kayle, Bob, Jkan");
        System.out.println(accounts);
    }
}
