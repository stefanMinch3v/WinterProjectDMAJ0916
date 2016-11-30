package ModelLayer;

import java.util.ArrayList;

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

    public  void addEItem(Item item) {
        items.add(item);
    }

    public   Item getItem(int index) {
        return items.get(index);
    }

    public  int getItemsSize() {
        return items.size();
    }

    public  void removeItem(int index) {
        items.remove(index);
    }

}
