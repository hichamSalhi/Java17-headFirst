package DealingWithConcurrency;

import java.util.concurrent.*;
/*
 * This class will contain tests for the Ryan and Monica concurrency problem to check for their balance in the bank.
 * Ryan and Monica both start with a balance of $100 in their account.
 * Ryan will checked the balance and he saw 100, then he will withdraw $50.
 * Before Ryan can update the balance, Monica will check the balance and see 100, then
 * she will withdraw $100 before Ryan.
 * And the Ryan will update the balance to 50, but Monica already withdrew 100, so the final balance should be -50.
 */
public class RyanAndMonicaTest implements Runnable{
    private static final BankAccount account = new BankAccount();
    private final String name;
    private final int amountToSpend;

    public RyanAndMonicaTest(BankAccount account, String name, int amountToSpend) {
        this.name = name;
        this.amountToSpend = amountToSpend;
    }

    private void goShopping(int amount) {
        System.out.println(name + " is about to spend");
        if (account.spend(name, amount)) {
            System.out.println(name + " completes the spend of " + amount);
        } else {
            System.out.println(name + " could not complete the spend of " + amount);
        }
    }

    //getters and setters
    public BankAccount getAccount() {
        return account;
    }
    public String getName() {
        return name;
    }
    public int getAmountToSpend() {
        return amountToSpend;
    }

    public static void main(String[] args) {
        RyanAndMonicaTest ryan = new RyanAndMonicaTest(account, "Ryan", 50);
        RyanAndMonicaTest monica = new RyanAndMonicaTest(account, "Monica", 100);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(ryan);
        executor.execute(monica);
        executor.shutdown();
    }

    @Override
    public void run() {
        goShopping(amountToSpend);
    }
}
