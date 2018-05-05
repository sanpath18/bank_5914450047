package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;
    private double defaultBalance = 500;

    @BeforeEach
    void setup() {
        account = new BankAccount(defaultBalance);
    }

    @Test
    void createBankAccountWithNegativeBalance() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    int i = 500;
                    new BankAccount(-i);
                });
        assertEquals("Balance must not be negative value", exception.getMessage());
    }

    @Test
    void createBankAccountWithSlightlyNegativeBalance() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new BankAccount(-0.01));
        assertEquals("Balance must not be negative value", exception.getMessage());
    }

    @Test
    void createBankAccountWithZeroBalance() {
        BankAccount account = new BankAccount(0);
        assertEquals(0, account.getBalance());
    }

    @Test
    void createBankAccountWithPositiveBalance() {
        BankAccount account = new BankAccount(500);
        assertEquals(500, account.getBalance());
    }

    @Test
    void createBankAccountWithSlightlyPositiveBalance() {
        BankAccount account = new BankAccount(0.01);
        assertEquals(0.01, account.getBalance());
    }

    @Test
    void depositNegativeAmount() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> account.deposit(-100));
        assertEquals("Amount must be greater than zero", exception.getMessage());
    }

    @Test
    void depositSlightlyNegativeAmount() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> account.deposit(-0.01));
        assertEquals("Amount must be greater than zero", exception.getMessage());
    }

    @Test
    void depositZeroAmount() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> account.deposit(0));
        assertEquals("Amount must be greater than zero", exception.getMessage());
    }

    @Test
    void depositPositiveAmount() {
        double amount = 100;
        account.deposit(amount);
        assertEquals(defaultBalance + amount, account.getBalance());
    }

    @Test
    void depositSlightlyPositiveAmount() {
        double amount = 0.01;
        account.deposit(amount);
        assertEquals(defaultBalance + amount, account.getBalance());
    }

    @Test
    void withdrawNegativeAmount() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(-100));
        assertEquals("Amount must be greater than zero", exception.getMessage());
    }

    @Test
    void withdrawSlightlyNegativeAmount() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(-0.01));
        assertEquals("Amount must be greater than zero", exception.getMessage());
    }

    @Test
    void withdrawZeroAmount() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(0));
        assertEquals("Amount must be greater than zero", exception.getMessage());
    }

    @Test
    void withdrawPositiveAmount() {
        double amount = 100;
        account.withdraw(amount);
        assertEquals(defaultBalance - amount, account.getBalance());
    }

    @Test
    void withdrawSlightlyPositiveAmount() {
        double amount = 0.01;
        account.withdraw(amount);
        assertEquals(defaultBalance - amount, account.getBalance());
    }

    @Test
    void withdrawEqualToBalance() {
        account.withdraw(defaultBalance);
        assertEquals(0, account.getBalance());
    }

    @Test
    void withdrawMoreThanBalance() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(defaultBalance + 100));
        assertEquals("Can't withdraw more than balance", exception.getMessage());
    }

    @Test
    void withdrawSlightlyMoreThanBalance() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(defaultBalance + 0.01));
        assertEquals("Can't withdraw more than balance", exception.getMessage());
    }
}