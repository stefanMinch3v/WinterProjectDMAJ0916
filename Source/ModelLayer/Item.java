package ModelLayer;

/**
 * Created by RedJohn on 23-Nov-16.
 */
public class Item {
    private String type;
    private String barcode;
    private double price;
    private int quantity;

    public Item(String type, String barcode, double price, int quantity) {
        this.type = type;
        this.barcode = barcode;
        this.price = price;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
