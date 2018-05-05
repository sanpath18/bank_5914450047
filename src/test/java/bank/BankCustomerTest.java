package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankCustomerTest {
    private Bank bank;
    private Customer cust;

    @BeforeEach
    void setup() {
        bank = new Bank("Bank");
        cust = new Customer(1, 1234, "Sanpath");
        bank.addCustomer(cust);
    }

    @Test
    void testCreateBankWithEmptyName() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Bank(""));
        assertEquals("Bank name can not be empty", exception.getMessage());
    }

    @Test
    void testCreateBankWithSpaceOnlyName() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Bank("    "));
        assertEquals("Bank name can not be empty", exception.getMessage());
    }

    @Test
    void testCustomerNotFound() {
        Customer found = bank.findCustomerById(0);
        assertNull(found);
    }

    @Test
    void testCustomerFound() {
        Customer found = bank.findCustomerById(1);
        assertNotNull(found);
        assertSame(cust, found);
    }

    @Test
    void testAddAnotherCustomer() {
        Customer anotherCust = new Customer(2, 5678, "Jeab");
        bank.addCustomer(anotherCust);

        Customer found = bank.findCustomerById(2);
        assertNotNull(found);
        assertSame(anotherCust, found);
    }

    @Test
    void testValidateCorrectPin() {
        assertTrue(bank.validateCustomer(1, 1234));
    }

    @Test
    void testValidateIncorrectPin() {
        assertFalse(bank.validateCustomer(1, 1111));
    }

    @Test
    void testValidateNonExistingCustomer() {
        assertFalse(bank.validateCustomer(0, 0000));
    }
}