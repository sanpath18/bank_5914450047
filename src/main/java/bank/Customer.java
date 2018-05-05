package bank;

public class Customer {
    private int id;
    private int pin;
    private String name;

    private IAccountManager manager;

    Customer(int id, int pin, String name) {
        if (id < 0) {
            throw new IllegalArgumentException("ID must not be negative value");
        }
        if (pin < 0) {
            throw new IllegalArgumentException("PIN must not be negative value");
        }
        nameValidation(name);
        this.id = id;
        this.pin = pin;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public final boolean match(int pin) {
        return this.pin == pin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        nameValidation(name);
        this.name = name;
    }

    public BankAccount getAccount() {
        return manager.getAccount(this.id);
    }

    protected void setAccountManager(IAccountManager manager) {
        this.manager = manager;
    }

    private void nameValidation(String name) {
        if (name.trim().length() == 0) {
            throw new IllegalArgumentException("Customer name must not be empty");
        }
    }
}