package DealingWithConcurrency;

public class BankAccount {
    private int balance = 100;

    public int getBalance() {
        return balance;
    }

    public synchronized boolean spend (String name, int amount) {
        boolean res = false;
        if (balance >= amount) {
            balance = balance - amount;
            res = true;
            if (balance < 0) {
                System.out.println("Overdrawn!");
                res = false;
            }
        } else {
            System.out.println("Sorry, not enough for " + name);
            res = false;
        }
        return res;
    }
}

