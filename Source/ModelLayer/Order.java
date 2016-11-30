package ModelLayer;
import java.util.*;

/**
 * Created by RedJohn on 23-Nov-16.
 */
public abstract class Order {

    private String numberID;
    private int quantity;
    //private Item item TODO
    private ArrayList<Item> items;
    public Order(String numberID, int quantity) {
        this.numberID = numberID;
        items = new ArrayList<>();
    }

    public String getNumberID() {
        return numberID;
    }

    public void setNumberID(String numberID) {
        this.numberID = numberID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
