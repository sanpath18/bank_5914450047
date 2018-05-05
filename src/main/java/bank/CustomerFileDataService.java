package bank;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomerFileDataService implements IDataService {
    @Override
    public Iterator<Customer> getAllObjects() {
        List<Customer> customers = new ArrayList<>();
        try {
            FileReader file = new FileReader("customer.csv");
            BufferedReader in = new BufferedReader(file);

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File customer.csv cannot be found");
        } catch (IOException e) {
            System.err.println("Error reading file customer.csv");
            e.printStackTrace();
        }
        return customers.iterator();
    }
}
