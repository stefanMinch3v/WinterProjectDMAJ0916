package ControlLayer;

import ModelLayer.*;

import java.util.*;

/**
 * Created by Admin on 12/1/2016.
 */
public class SaleControl {
    private SaleContainer saleContainer;
    private CustomerContainer customerContainer;
    private ItemContainer itemContainer;
    public SaleControl() {
        saleContainer = SaleContainer.getInstance();
        customerContainer = CustomerContainer.getInstance();
        itemContainer = ItemContainer.getInstance();
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
    public ArrayList<Item> getAvailableItems(String place, HashMap<String, Integer> items)
    {
        ArrayList<Item> orderItems = new ArrayList<>();
        // Get a set of the entries
        Set set = items.entrySet();

        // Get an iterator
        Iterator i = set.iterator();

        // Display elements
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            //System.out.print(me.getKey() + ": ");
            //System.out.println(me.getValue());
            String barcode = (String) me.getKey();
            int quantity = (Integer) me.getValue();
            orderItems.add(itemContainer.getOrderItem(place, barcode, quantity));
        }
        return orderItems;
    }

}
