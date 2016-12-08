package ControlLayer;

import ModelLayer.*;

import java.util.ArrayList;

/**
 * Created by Admin on 12/1/2016.
 */
public class SaleControl {
    private SaleContainer saleContainer;
    private CustomerContainer customerContainer;

    public SaleControl() {
        saleContainer = SaleContainer.getInstance();
        customerContainer = CustomerContainer.getInstance();
    }

    public boolean addSale(String numberID, int quantity, double price, String customerCPR) {
        Customer customer = customerContainer.findCustomerByCpr(customerCPR);
        Sale sale = new Sale(numberID, quantity, price, customer);
        //saleContainer.addSale(new Sale(numberID,quantity,price,customer));
        return saleContainer.addSale(sale);
    }

    public ArrayList<String> readSale(String numberID) {
        return saleContainer.getSaleByNumberID(numberID);
    }

    public boolean updateSale(String numberID, int fieldNumber, Object fieldInfo) {
        Sale sale = saleContainer.getSaleByID(numberID);
        return sale.updateFields(fieldNumber, fieldInfo);
    }
}
