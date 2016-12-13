package ModelLayer;

import java.util.ArrayList;

/**
 * Created by Admin on 11/28/2016.
 */
public class Sale extends Order {
    private ArrayList<Item> items;

    public Sale(ArrayList<Item> items, String numberID, double price, Customer customer) {
        super(numberID, price, customer);
        this.items = items;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public boolean updateFields(int fieldNumber, Object fieldInfo) {
        switch (fieldNumber) {
            case 1:
                setNumberID((String) fieldInfo);
                return true;
            case 2:
                setPrice((double) fieldInfo);
                return true;
            case 3:
                setCustomer((Customer) fieldInfo);
                return true;
            default:
                return false;
        }
    }
}
