package Models;

import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    // Creating an immutable instance of a Lock to control access to resources.
    private final ReentrantLock lock = new ReentrantLock();

    public void makeTransaction(double amount, Account receiver, Account sender) {
        // Block the access to resources.
        lock.lock();
        if (amount <= sender.getBalance()) {
            System.out.printf("Bank starting transaction of %.2f\n", amount);
            receiver.deposit(amount);
            sender.withdraw(amount);
            System.out.println("Bank finished the transaction");
        }
        // Block the access to resources.
        lock.unlock();
    }
}
