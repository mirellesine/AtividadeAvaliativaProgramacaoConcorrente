import Models.*;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        for (int i = 0; i < 2; i++) {
            Store.stores.add(createStore(bank));
        }
        Customer[] customers = new Customer[5];
        for (int i = 0; i < 5; i++) {
            customers[i] = new Customer();
            customers[i].start();
        }
        for (Customer customer : customers) {
            try {
                customer.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        // Print the balances of all stores and their employees.
        for (int i = 0; i < Store.stores.size(); i++) {
            Store store = Store.stores.get(i);
            System.out.printf("Store %d has balance of $%.2f\n", i, store.getAccount().getBalance());
            for (int j = 0; j < store.getEmployees().length; j++) {
                Employee employee = store.getEmployees()[j];
                System.out.printf("Employee %d has a balance of $%.2f in his salary account\n", j, employee.getSalaryAccount().getBalance());
                System.out.printf("Employee %d has a balance of $%.2f in his investment account\n", j, employee.getInvestmentAccount().getBalance());
            }
        }
        // Print the balances of all customers.
        for (int i = 0; i < customers.length; i++) {
            System.out.printf("Customer %d has balance of $%.2f\n", i, customers[i].getAccount().getBalance());
        }
    }

    private static Store createStore(Bank bank) {
        return new Store(new Account(0), bank, createEmployeesForStore());
    }

    private static Employee[] createEmployeesForStore() {
        return new Employee[]{createEmployee(), createEmployee()};
    }

    private static Employee createEmployee() {
        return new Employee(new Account(0), new Account(0));
    }
}
