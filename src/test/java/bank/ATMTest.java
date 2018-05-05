package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ATMTest {

    @Mock private Bank stubBank;
    @Mock private Customer stubCustomer1;
    @Mock private Customer stubCustomer2;
    @Mock private BankAccount mockAccount1;
    @Mock private BankAccount mockAccount2;

    // CUT
    private ATM atm;

    @BeforeEach
    void initMocks() {
        MockitoAnnotations.initMocks(this);
        atm = new ATM(stubBank);
    }

    @Test
    void testTransfer() {
        int senderId = 1;
        int receiverId = 2;
        int amount = 500;

        when(stubBank.findCustomerById(senderId)).thenReturn(stubCustomer1);
        when(stubCustomer1.getAccount()).thenReturn(mockAccount1);

        when(stubBank.findCustomerById(receiverId)).thenReturn(stubCustomer2);
        when(stubCustomer2.getAccount()).thenReturn(mockAccount2);

        atm.transfer(senderId, receiverId, amount);

        verify(mockAccount1).withdraw(amount);
        verify(mockAccount2).deposit(amount);
    }

    @Test
    void testDeposit() {
        int id = 2;
        int amount = 200;

        when(stubBank.findCustomerById(id)).thenReturn(stubCustomer2);
        when(stubCustomer2.getAccount()).thenReturn(mockAccount2);

        atm.deposit(id, amount);

        verify(mockAccount2).deposit(amount);
    }

    @Test
    void testWithdraw() {
        int id = 1;
        int amount = 500;

        when(stubBank.findCustomerById(id)).thenReturn(stubCustomer1);
        when(stubCustomer1.getAccount()).thenReturn(mockAccount1);

        atm.withdraw(id, amount);

        verify(mockAccount1).withdraw(amount);
    }
}