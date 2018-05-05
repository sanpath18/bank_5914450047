package bank;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Bank {
    private String bankName;

    private Map<Integer, Customer> customers;
    private IDataService dataService;

    public Bank(String name) {
        this(name, new CustomerFileDataService());
    }

    protected Bank(String name, IDataService dataService) {
        if (name.trim().length() == 0) {
            throw new IllegalArgumentException("Bank name can not be empty");
        }
        this.bankName = name.trim();
        this.customers = new HashMap<>();
        this.dataService = dataService;
    }

    public void addCustomer(Customer c) {
        customers.put(c.getId(), c);
    }

    public Customer findCustomerById(int custId) {
        return customers.get(custId);
    }

    public final boolean validateCustomer(int custId, int pin) {
        Customer customer = findCustomerById(custId);
        return customer != null && customer.match(pin);
    }

    public void addAllCustomers() {
        Iterator<Customer> itr = dataService.getAllObjects();
        while (itr.hasNext()) {
            addCustomer(itr.next());
        }
    }
}
