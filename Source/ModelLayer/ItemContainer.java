package ModelLayer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by RedJohn on 23-Nov-16.
 */
public class ItemContainer {

    private ArrayList<Item> items;
    private static ItemContainer instance;

    private ItemContainer() {
        items = new ArrayList<>();
    }

    public static ItemContainer getInstance() {
        if(instance==null){
            instance = new ItemContainer();
        }
        return instance;
    }

    public  boolean addEItem(Item item) {
        items.add(item);
        return true;
    }

    public   Item getItem(int index) {
        return items.get(index);
    }

    public Item findItemByBarcode(String barcode){
        for (Item item:items) {
            if(item.getBarcode().equals(barcode))return item;
        }
        return null;
    }

    public  int getItemsSize() {
        return items.size();
    }

    public ArrayList<String> getItemsFieldsByBarcode(String barcode){
        ArrayList<String> fields = new ArrayList<>();
        for (Item item:items) {
            if(item.getBarcode().equals(barcode)) {
                fields.add("1. Name: "+ item.getName());
                fields.add("2. Type: "+ item.getType());
                fields.add("3. Barcode: "+ item.getBarcode());
                fields.add("4. Cost price: "+ item.getCostPrice());
                fields.add("5. Trade allowance: "+ item.getTradeAllowance());
                fields.add("6. Retail price: "+ item.getRetailPrice());
                fields.add("7. Quantity of "+item.getName()+" at DIY: "+ item.getQuantityAtDIY());
                fields.add("7. Quantity of "+item.getName()+" at Timber: "+ item.getQuantityAtTimber());
            }
        }
        return fields;
    }

    public  boolean removeItemByBarcode(String barcode) {
        Iterator<Item> it = items.iterator();
        while(it.hasNext()){
            Item item = it.next();
            if(item.getBarcode().equals(barcode)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

}
