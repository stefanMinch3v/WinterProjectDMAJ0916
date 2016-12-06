package ModelLayer;

import java.util.*;

/**
 * Created by RedJohn on 23-Nov-16.
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

    public void removeContractor(String CVR) {
        for (Contractor c : contractors) {
            if (c.getCVR().equals(CVR)) {
                contractors.remove(CVR);
                System.out.println("Removed");
            }
        }
    }
    public Contractor getContractorByID(String CVR) {
        Contractor foundCont = null;

        Iterator<Contractor> it = contractors.iterator();
        while(it.hasNext()) {//!found
            Contractor recordCont = it.next();
            if(recordCont.getCVR().equals(CVR)) {
                //found = true;
                foundCont = recordCont;
            }
        }
        return foundCont;
    }
}
