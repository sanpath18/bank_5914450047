package bank;

public class ATM {
    private Bank bank;

    ATM(Bank bank) {
        this.bank = bank;
    }

    void transfer(int fromCustId, int toCustID, double amount) {
        Customer sendingCustomer = bank.findCustomerById(fromCustId);
        BankAccount sendingAccount = sendingCustomer.getAccount();

        Customer receivingCustomer = bank.findCustomerById(toCustID);
        BankAccount receivingAccount = receivingCustomer.getAccount();

        sendingAccount.withdraw(amount);
        receivingAccount.deposit(amount);
    }

    void deposit(int custId, double value) {
        Customer customer = bank.findCustomerById(custId);
        BankAccount account = customer.getAccount();

        account.deposit(value);
    }

    void withdraw(int custId, double value) {
        Customer customer = bank.findCustomerById(custId);
        BankAccount account = customer.getAccount();

        account.withdraw(value);
    }
}
