package DealingWithConcurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicBankAccount {
    private AtomicInteger balance = new AtomicInteger(100);

    public int getBalance() {
        return balance.get();
    }

    // we removed synchronized keyword because AtomicInteger handles atomicity internally
    // The Atmoic operations ensure that the balance updates are thread-safe
    public boolean spend (String name, int amount) {
        boolean success = false;
        int initialBalance = balance.get();
        if (initialBalance >= amount) {
            success = balance.compareAndSet(initialBalance, initialBalance - amount);
            if (!success) {
                System.out.println(name + "'s spend failed due to concurrent modification.");
            } 
        }else {
            System.out.println("Sorry, not enough for " + name);
        }
        return success;
    }
}
