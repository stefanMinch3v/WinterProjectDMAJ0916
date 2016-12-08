package ModelLayer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Admin on 11/28/2016.
 */
public class SaleContainer {
    private ArrayList<Sale> sale;
    private static SaleContainer instance;

    private SaleContainer() {
        sale = new ArrayList<>();
    }

    public static SaleContainer getInstance() {
        if(instance==null){
            instance = new SaleContainer();
        }
        return instance;
    }

    public ArrayList<Sale> getSale() {
        return sale;
    }

    public boolean addSale(Sale sale1) {
        sale.add(sale1);
        return true;
    }

    //Search for a specific sale by his unique numberID
    public Sale getSaleByID(String numberID) {
        Sale foundSale = null;

        Iterator<Sale> it = sale.iterator();
        while(it.hasNext()) {
            Sale recordSale = it.next();
            if(recordSale.getNumberID().equals(numberID)) {
                foundSale = recordSale;
            }
        }
        return foundSale;
    }

    /*public void removeSale(String numberID) {
        for (Sale s: sale) {
            if (s.getNumberID().equals(numberID)) {
                sale.remove(numberID);
                System.out.println("Removed");
            }
        }
    }*/

    public ArrayList<String> getSaleByNumberID(String numberID) {
        ArrayList<String> list = new ArrayList<>();
        for(Sale s: sale) {
            if(s.getNumberID().equals(numberID)) {
                list.add("1.NumberId: " + s.getNumberID());
                list.add("2.Quantity: " + s.getQuantity());
                list.add("3.Price: " + s.getPrice());
                list.add("4.Customer: " + s.getCustomer());
            }
        }
        return list;
    }
}
