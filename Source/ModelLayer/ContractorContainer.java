package ModelLayer;

import java.util.ArrayList;

/**
 * Created by RedJohn on 23-Nov-16. porn
 */
public class ContractorContainer {
    private  ArrayList<Contractor> contractors;
    private static ContractorContainer instance;

    private ContractorContainer() {
        contractors = new ArrayList<>();
    }

    public static ContractorContainer getInstance() {
        if(instance==null){
            instance = new ContractorContainer();
        }
        return instance;
    }

    public  void addContractor(Contractor contractor) {
        contractors.add(contractor);
    }

    public  Contractor getContractor(int index) {
        return contractors.get(index);
    }

    public  int getContractorsSize() {
        return contractors.size();
    }

    public  void removeContractor(int index) {
        contractors.remove(index);
    }

}

