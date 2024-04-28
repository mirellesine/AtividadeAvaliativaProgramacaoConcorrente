package Models;

import java.util.ArrayList;
import java.util.List;

public class Store {
    public static List<Store> stores = new ArrayList<>();

    private final Account account;
    private final Bank bank;
    private final Employee[] employees;

    public Store(Account account, Bank bank, Employee[] employees) {
        this.account = account;
        this.bank = bank;
        this.employees = employees;
    }

    // A synchronized method to process a purchase. It prints the purchase amount,
    // makes a transaction, and pays salaries if possible.
    public synchronized void processPurchase(Account customerAccount, double amount) {
        System.out.printf("Store is processing a purchase of %.2f\n", amount);
        bank.makeTransaction(amount, account, customerAccount);
        paySalariesIfPossible();
    }

    // Method to pay salaries to employees if the store has enough balance.
    private void paySalariesIfPossible() {
        double salary = 700;
        double salarySum = employees.length * salary;
        if (account.getBalance() >= salarySum) {
            System.out.printf("Store is paying $%.2f of salaries to employees\n", salarySum);
            for (int i = 0; i < employees.length; i++) {
                Employee employee = employees[i];
                System.out.printf("Employee %d is receiving a salary of %.2f\n", i, salary);
                employee.receiveSalary(salary, account, bank);
            }
        }
    }

    public Account getAccount() {
        return account;
    }

    public Employee[] getEmployees() {
        return employees;
    }
}
