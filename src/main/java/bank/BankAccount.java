package bank;

public class BankAccount {
    private double balance;

    BankAccount(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance must not be negative value");
        }
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        amountValidation(amount);
        this.balance += amount;
    }

    public void withdraw(double amount) {
        amountValidation(amount);
        if (amount > balance) {
            throw new IllegalArgumentException("Can't withdraw more than balance");
        }
        this.balance -= amount;
    }

    private void amountValidation(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
    }
}