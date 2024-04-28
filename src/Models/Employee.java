package Models;

public class Employee extends Thread {
    private final Account salaryAccount;
    private final Account investmentAccount;

    public Employee(Account salaryAccount, Account investmentAccount) {
        this.salaryAccount = salaryAccount;
        this.investmentAccount = investmentAccount;
    }

    // Method for the employee to receive a salary and divide it between accounts.
    public void receiveSalary(double amount, Account employerAccount, Bank bank) {
        System.out.printf("Employee received a salary of %.2f\n", amount);
        bank.makeTransaction(amount * 0.8, salaryAccount, employerAccount);
        bank.makeTransaction(amount * 0.2, investmentAccount, employerAccount);
    }

    public Account getSalaryAccount() {
        return salaryAccount;
    }

    public Account getInvestmentAccount() {
        return investmentAccount;
    }
}
