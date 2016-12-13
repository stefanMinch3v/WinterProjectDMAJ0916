package ControlLayer;

import ModelLayer.Customer;
import ModelLayer.CustomerContainer;

import java.util.ArrayList;

/**
 * Created by RaidenRabit on 23-Nov-16.
 */
public class CustomerControl {
    private CustomerContainer customerContainer;


    public CustomerControl() {
        customerContainer = CustomerContainer.getInstance();
    }

    //CREATE
    public boolean createCustomer(String cpr, String name, String address, String email, String phone, String city) {
        Customer customer = new Customer(cpr, name, address, email, phone, city);
        return customerContainer.addCustomer(customer);
    }

    //READ
    public ArrayList<String> getCustomerByCpr(String cpr) {
        return customerContainer.getCustomerFieldsByCpr(cpr);
    }

    //UPDATE
    public boolean changeCustomerFieldByCpr(String cpr, int fieldNumber, Object fieldInfo) {
        Customer customer = customerContainer.findCustomerByCpr(cpr);
        return customer.setField(fieldNumber, fieldInfo);
    }

    //DELETE
    public boolean deleteCustomer(String cpr) { // asumes there is at least 1 customer in the system
        return customerContainer.removeCustomerByCPR(cpr);
    }

}
