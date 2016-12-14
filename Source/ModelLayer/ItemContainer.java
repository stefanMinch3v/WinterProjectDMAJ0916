package ModelLayer;

import UILayer.AesEncrypter;

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
        if (instance == null) {
            instance = new ItemContainer();
        }
        return instance;
    }

    public boolean addItem(Item item) {
        items.add(item);
        return true;
    }

    public Item getOrderItem(String place, String barcode, int quantity) {

        for (Item item : items) {
            if (item.getBarcode().equals(barcode)) {
                if (place.equals("timber"))
                {
                    int aux = item.getQuantityAtTimber() - quantity;
                    item.setQuantityAtTimber(aux);
                }
                else
                {
                    int aux = item.getQuantityAtTimber() - quantity;
                    item.setQuantityAtDIY(aux);
                }
                Item myItem = new Item(item.getName(),item.getType(),item.getBarcode(),item.getCostPrice(),item.getTradeAllowance(),item.getRetailPrice(),quantity,place);
                return myItem;
            }
        }
        return null;
    }

    public Item findItemByBarcode(String barcode) {
        for (Item item : items) {
            if (item.getBarcode().equals(barcode)) return item;
        }
        return null;
    }

    public int getItemsSize() {
        return items.size();
    }

    public int getQuantityPlace(String place, String barcode) {
        for (Item item : items) {
            if (item.getBarcode().equals(barcode)) {
                if (place.equals("timber")) return item.getQuantityAtTimber();
                else return item.getQuantityAtDIY();
            }

        }
        return 0;
    }

    public ArrayList<String> getItemsFieldsByBarcode(String barcode) {
        ArrayList<String> itemFields = new ArrayList<>();
        for (Item item : items) {
            if (item.getBarcode().equals(barcode)) {
                itemFields.add("1. Name: " + item.getName());
                itemFields.add("2. Type: " + item.getType());
                itemFields.add("3. Barcode: " + item.getBarcode());
                itemFields.add("4. Cost price: " + item.getCostPrice());
                itemFields.add("5. Trade allowance: " + item.getTradeAllowance());
                itemFields.add("6. Retail price: " + item.getRetailPrice());
                itemFields.add("7. Quantity of " + item.getName() + " at DIY: " + item.getQuantityAtDIY());
                itemFields.add("8. Quantity of " + item.getName() + " at Timber: " + item.getQuantityAtTimber());
                return itemFields;
            }
        }
        return null;
    }

    public boolean removeItemByBarcode(String barcode) {
        Iterator<Item> it = items.iterator();
        while (it.hasNext()) {
            Item item = it.next();
            if (item.getBarcode().equals(barcode)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public String saveData(int index) {
        String data = "";
        Item item = items.get(index);

        AesEncrypter.encrypt(item.getName().trim()); // encrypt
        data = data + AesEncrypter.getEncryptedString() + " "; // add
        AesEncrypter.encrypt(item.getType().trim()); // encrypt
        data = data + AesEncrypter.getEncryptedString() + " "; // add
        AesEncrypter.encrypt(item.getBarcode().trim()); // encrypt
        data = data + AesEncrypter.getEncryptedString() + " "; // add
        AesEncrypter.encrypt(Double.toString(item.getCostPrice()).trim()); // convert to string then encrypt
        data = data + AesEncrypter.getEncryptedString() + " "; // add
        AesEncrypter.encrypt(Double.toString(item.getTradeAllowance()).trim()); // convert to string then encrypt
        data = data + AesEncrypter.getEncryptedString() + " "; // add
        AesEncrypter.encrypt(Double.toString(item.getRetailPrice()).trim()); // convert to string then encrypt
        data = data + AesEncrypter.getEncryptedString() + " "; // add
        AesEncrypter.encrypt(Integer.toString(item.getQuantityAtDIY()).trim()); // convert to string then encrypt
        data = data + AesEncrypter.getEncryptedString() + " "; // add
        AesEncrypter.encrypt(Integer.toString(item.getQuantityAtTimber()).trim()); // convert to string then encrypt
        data = data + AesEncrypter.getEncryptedString() + " \n"; // add

        return data;

    }

}
