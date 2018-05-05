package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class BankDataServiceTest {
    private Bank bank;

    @BeforeEach
    void setup() {
        bank = new Bank("Bank", new DataServiceStub());
        bank.addAllCustomers();
    }

    @Test
    void testFindCustomerById1() {
        Customer cust = bank.findCustomerById(1);
        assertEquals("Sanpath", cust.getName());
    }

    @Test
    void testFindCustomerById2() {
        Customer cust = bank.findCustomerById(2);
        assertEquals("Jeab", cust.getName());
    }

//    @Test
//    void testFindCustomerById3() {
//        Customer cust = bank.findCustomerById(1);
//        assertEquals("Jeab", cust.getName());
//    }

    private class DataServiceStub implements IDataService {
        @Override
        public Iterator<Customer> getAllObjects() {
            ArrayList<Customer> list = new ArrayList<>();
            list.add(new Customer(1, 1234, "Sanpath"));
            list.add(new Customer(2, 5678, "Jeab"));
            return list.iterator();
        }
    }
}
