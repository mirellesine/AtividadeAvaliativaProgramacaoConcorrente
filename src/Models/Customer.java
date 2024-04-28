package Models;

import java.util.Random;

public class Customer extends Thread {
    private final Account account;

    public Customer() {
        this.account = new Account(1000);
    }

    @Override
    public void run() {
        Random random = new Random();
        int index = 0;
        while (account.getBalance() >= 100) {
            double amount = random.nextBoolean() ? 100 : 200;
            int storeIndex = index % 2 == 0 ? 0 : 1;
            System.out.printf("Customer is purchasing a product for %.2f at store %d\n", amount, storeIndex);
            Store.stores.get(storeIndex).processPurchase(account, amount);
            index++;
        }
    }

    public Account getAccount() {
        return account;
    }
}
