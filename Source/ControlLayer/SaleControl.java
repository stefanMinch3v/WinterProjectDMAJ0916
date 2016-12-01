package ControlLayer;

import ModelLayer.*;

import java.util.ArrayList;

/**
 * Created by Admin on 12/1/2016.
 */
public class SaleControl {
    private SaleContainer saleContainer;

    public SaleControl() {
        saleContainer = SaleContainer.getInstance();
    }

    public void addSale(String numberID, int quantity, double price, Customer customer) {
        //Sale sale = new Sale(numberID, quantity, price, customer);
        saleContainer.addSale(new Sale(numberID,quantity,price,customer));
    }

    public ArrayList<Item> readSale(String numberID) {
        Sale s = saleContainer.getSaleByID(numberID);
        return s.getItems();
    }

    //update Sale TODO
}
