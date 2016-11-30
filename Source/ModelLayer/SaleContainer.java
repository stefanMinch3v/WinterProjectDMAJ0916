package ModelLayer;

import java.util.ArrayList;

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
}
