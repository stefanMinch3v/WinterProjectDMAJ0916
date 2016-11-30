package ModelLayer;
import java.util.*;

/**
 * Created by RedJohn on 23-Nov-16.
 */
public abstract class Order {

    private String numberID;
    private int quantity;
    private double price;
    private Customer customer;
    private ArrayList<Item> items;

    public Order(String numberID, int quantity, double price, Customer customer) {
        this.numberID = numberID;
        this.quantity = quantity;
        this.price = price;
        this.customer = customer;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
