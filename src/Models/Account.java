package Models;

public class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        this.balance += amount;
    }

    public synchronized void withdraw(double amount) {
        this.balance -= amount;
    }

    public synchronized double getBalance() {
        return balance;
    }
}
