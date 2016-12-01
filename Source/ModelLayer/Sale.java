package ModelLayer;

import java.util.ArrayList;

/**
 * Created by Admin on 11/28/2016.
 */
public class Sale extends Order{
    private ArrayList<Item> items;

    public Sale(String numberID, int quantity, double price, Customer customer) {
        super(numberID, quantity, price, customer);
        items = new ArrayList<>();
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
