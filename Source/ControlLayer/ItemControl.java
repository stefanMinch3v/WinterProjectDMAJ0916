package ControlLayer;

import ModelLayer.Item;
import ModelLayer.ItemContainer;

import java.util.ArrayList;

/**
 * Created by RedJohn on 28-Nov-16.
 */
public class ItemControl {
    private ItemContainer itemContainer;

//CREATE
    public boolean addItem(String name,String type,String barcode, double costPrice, double tradeAllowance, double retailPrice, int quantity, String place) {
        Item item = new Item(name, type, barcode, costPrice, tradeAllowance, retailPrice, quantity, place);
        return itemContainer.addEItem(item);
    }

//READ
    public ArrayList<String> getItemByBarcode(String barcode){
        return itemContainer.getItemsFieldsByBarcode(barcode);
    }

//UPDATE
    public boolean changeItemFieldByBarcode(String barcode, int fieldNumber, Object fieldInfo)
    {
        Item item = itemContainer.findItemByBarcode(barcode);
        return item.setField(fieldNumber,fieldInfo);
    }

    //DELETE
    public boolean deleteItem(String barcode)
    {
        return itemContainer.removeItemByBarcode(barcode);
    }
}
