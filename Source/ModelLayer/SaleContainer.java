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

    public void addSale(Sale sale1) {
        sale.add(sale1);
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

    public void removeSale(String numberID) {
        for (Sale s: sale) {
            if (s.getNumberID().equals(numberID)) {
                sale.remove(numberID);
                System.out.println("Removed");
            }
        }
    }
}
