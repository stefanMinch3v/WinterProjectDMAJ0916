package ModelLayer;

/**
 * Created by RedJohn on 23-Nov-16.
 */
public class Item {
    private String name;
    private String type;
    private String barcode;
    private double costPrice;
    private double tradeAllowance;
    private double retailPrice;
    private int quantityAtDIY;
    private int quantityAtTimber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    int getQuantityAtDIY() {
        return quantityAtDIY;
    }

    public void setQuantityAtDIY(int quantityAtDIY) {
        this.quantityAtDIY = quantityAtDIY;
    }

    public int getQuantityAtTimber() {
        return quantityAtTimber;
    }

    public Item(String name, String type, String barcode, double costPrice, double tradeAllowance, double retailPrice, int quantity, String place) {
        this.type = type;
        this.name = name;
        this.barcode = barcode;
        this.costPrice = costPrice;
        this.tradeAllowance = tradeAllowance;
        this.retailPrice = retailPrice;
        if(place.equals("DIY"))this.quantityAtDIY += quantity;
        else this.quantityAtTimber+= quantity;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public double getTradeAllowance() {
        return tradeAllowance;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public String getType() {
        return type;
    }

    public String getBarcode() {
        return barcode;
    }

    public boolean setField(int fieldNumber, Object fieldInfo){
        switch (fieldNumber)
        {
            case 1:
                name = (String) fieldInfo;
                return true;
            case 2:
                type = (String) fieldInfo;
                return true;
            case 3:
                costPrice = (double) fieldInfo;
                return true;
            case 4:
                tradeAllowance = (double) fieldInfo;
                return true;
            case 5:
                retailPrice = (double) fieldInfo;
                break;
            case 6:
                quantityAtDIY = (int) fieldInfo;
                break;
            case 7:
                quantityAtTimber = (int) fieldInfo;
                break;
            default:
                return false;
        }
        return false;
    }
}
