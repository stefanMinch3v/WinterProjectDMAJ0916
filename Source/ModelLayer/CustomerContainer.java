package ModelLayer;

import java.util.ArrayList;

/**
 * Created by RaidenRabit on 23-Nov-16.
 */
public class CustomerContainer {
    private  ArrayList<Customer> customers;
    private static CustomerContainer instance;

    private CustomerContainer() {
        customers = new ArrayList<>();
    }

    public static CustomerContainer getInstance() {
        if(instance==null){
            instance = new CustomerContainer();
        }
        return instance;
    }

    public  void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public  Customer getCustomer(int index) {
        return customers.get(index);
    }

    public  int getCustomersSize() {
        return customers.size();
    }

    public  void removeCustomer(int index) {
        customers.remove(index);
    }

    public Customer getCustomerByCPR(String cpr) {
        Customer cust = null;
        for(Customer c: customers) {
            if(c.getCPR().equals(cpr)) {
                cust = c;
            }
        }
        return cust;
    }

}

