package ModelLayer;

import UILayer.AesEncrypter;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by RaidenRabit on 23-Nov-16.
 */
public class CustomerContainer {
    private ArrayList<Customer> customers;
    private static CustomerContainer instance;

    private CustomerContainer() {
        customers = new ArrayList<>();
    }

    public static CustomerContainer getInstance() {
        if (instance == null) {
            instance = new CustomerContainer();
        }
        return instance;
    }

    public boolean addCustomer(Customer customer) {
        customers.add(customer);
        return true;
    }

    public Customer findCustomerByCpr(String cpr) {
        for (Customer customer : customers) {
            if (customer.getCpr().equals(cpr))
                return customer;
        }
        return null;
    }

    public ArrayList<String> getCustomerFieldsByCpr(String cpr) {
        ArrayList<String> fields = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getCpr().equals(cpr)) {
                fields.add("1. CPR: " + customer.getCpr());
                fields.add("2. Name: " + customer.getName());
                fields.add("3. Address: " + customer.getAddress());
                fields.add("4. Email: " + customer.getEmail());
                fields.add("5. Phone: " + customer.getPhone());
                fields.add("6. City: " + customer.getCity());
                return fields;
            }
        }
        return null;
    }

    public boolean removeCustomerByCPR(String cpr) {
        Iterator<Customer> it = customers.iterator();
        while (it.hasNext()) {
            Customer customer = it.next();
            if (customer.getCpr().equals(cpr)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public int getCustomersSize() {
        return customers.size();
    }

    public String saveData(int index) {
        String data = "";
        Customer customer = customers.get(index);

        AesEncrypter.encrypt(customer.getCpr().trim()); // encrypt
        data = data + AesEncrypter.getEncryptedString() + " "; // add
        AesEncrypter.encrypt(customer.getName().trim());
        data = data + AesEncrypter.getEncryptedString() + " ";
        AesEncrypter.encrypt(customer.getAddress().trim());
        data = data + AesEncrypter.getEncryptedString() + " ";
        AesEncrypter.encrypt(customer.getEmail().trim());
        data = data + AesEncrypter.getEncryptedString() + " ";
        AesEncrypter.encrypt(customer.getPhone().trim());
        data = data + AesEncrypter.getEncryptedString() + " ";
        AesEncrypter.encrypt(customer.getCity().trim());
        data = data + AesEncrypter.getEncryptedString() + " \n";


        return data;
    }


}

