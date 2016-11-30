package ControlLayer;

import ModelLayer.Customer;

/**
 * Created by RaidenRabit on 23-Nov-16.
 */
public class CustomerControl {
    private ModelLayer.CustomerContainer CustomerContainer;

    public void addCustomer(String cpr, String name, String address, String email, String phone, String city) {

        Customer customer = new Customer(cpr, name, address, email, phone, city); // creating customer
        CustomerContainer.addCustomer(customer);                                  // adding customer to system
    }

    public  String readCustomer(String cpr) {
        if( findCustomer(cpr) >= 0 )
        {   Customer customer = CustomerContainer.getCustomer(findCustomer(cpr));
            return ( "NAME: "+customer.getName()+"\nCITY: "+customer.getCity()+"\nADDRESS: "+customer.getAddress()+"\nCPR: "+customer.getCPR()+"\nEMAIL: "+customer.getEmail()+"\nPHONE: "+customer.getPhone() );
        }
        else
            return String.valueOf(findCustomer(cpr));
    }

    public String updateCustomer(int index, int updateType, String newInfo) {
        switch(updateType)
        {
            case 1:
                CustomerContainer.getCustomer(index).setCpr(newInfo);
                break;
            case 2:
                CustomerContainer.getCustomer(index).setName(newInfo);
                break;
            case 3:
                CustomerContainer.getCustomer(index).setAddress(newInfo);
                break;
            case 4:
                CustomerContainer.getCustomer(index).setEmail(newInfo);
                break;
            case 5:
                CustomerContainer.getCustomer(index).setPhone(newInfo);
                break;
            case 6:
                CustomerContainer.getCustomer(index).setCity(newInfo);
                break;
        }
        return newInfor( CustomerContainer.getCustomer(index).getCPR() );
    }

    private String newInfor(String cpr)
    {
        Customer customer = CustomerContainer.getCustomer(findCustomer(cpr));
        return ( "NAME: "+customer.getName()+"\nCITY: "+customer.getCity()+"\nADDRESS: "+customer.getAddress()+"\nCPR: "+customer.getCPR()+"\nEMAIL: "+customer.getEmail()+"\nPHONE: "+customer.getPhone() );
    }

    public int deleteCustomer(String cpr) { // asumes there is at least 1 customer in the system
        if (findCustomer(cpr) >= 0) // if there is such customer
        {
            CustomerContainer.removeCustomer(findCustomer(cpr)); // remove him from the container
            return findCustomer(cpr);
        } else
            return findCustomer(cpr);
    }

    private int findCustomer(String cpr) {
        for (int i = 0; i < CustomerContainer.getCustomersSize() ; i++)
            if ( CustomerContainer.getCustomer(i).getCPR().equals(cpr) )
                return i;
        return -1; // there is no such customer
    }
}
