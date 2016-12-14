package ModelLayer;

import UILayer.AesEncrypter;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by RedJohn on 23-Nov-16.
 */
public class ContractorContainer {
    private ArrayList<Contractor> contractors;
    private static ContractorContainer instance;

    private ContractorContainer() {
        contractors = new ArrayList<>();
    }

    public static ContractorContainer getInstance() {
        if (instance == null) {
            instance = new ContractorContainer();
        }
        return instance;
    }

    public boolean addContractor(Contractor contractor) {
        contractors.add(contractor);
        return true;
    }

    public boolean removeContractorByCvr(String cvr) {
        Iterator<Contractor> it = contractors.iterator();
        while (it.hasNext()) {
            Contractor contractor = it.next();
            if (contractor.getCvr().equals(cvr)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public Contractor findContractorByCvr(String cvr) {
        Contractor foundCont = null;

        Iterator<Contractor> it = contractors.iterator();
        while (it.hasNext()) {//!found
            Contractor recordCont = it.next();
            if (recordCont.getCvr().equals(cvr)) {
                //found = true;
                foundCont = recordCont;
            }
        }
        return foundCont;
    }

    public ArrayList<String> getContractorFieldsByCvr(String cvr) {
        ArrayList<String> fields = new ArrayList<>();
        for (Contractor contractor : contractors) {
            if (contractor.getCvr().equals(cvr)) {
                fields.add("1. CVR: " + contractor.getCvr());
                fields.add("2. Name: " + contractor.getName());
                fields.add("3. Address: " + contractor.getAddress());
                fields.add("4. Email: " + contractor.getEmail());
                fields.add("5. Phone: " + contractor.getPhone());
                fields.add("6. City: " + contractor.getCity());
                return fields;
            }
        }
        return null;
    }

    public int getContractorSize() {
        return contractors.size();
    }

    public String saveData(int index) {
        String data = "";
        Contractor contractor = contractors.get(index);

        AesEncrypter.encrypt(contractor.getName());
        data = data + AesEncrypter.getEncryptedString() + " ";
        AesEncrypter.encrypt(contractor.getAddress());
        data = data + AesEncrypter.getEncryptedString() + " ";
        AesEncrypter.encrypt(contractor.getEmail());
        data = data + AesEncrypter.getEncryptedString() + " ";
        AesEncrypter.encrypt(contractor.getPhone());
        data = data + AesEncrypter.getEncryptedString() + " ";
        AesEncrypter.encrypt(contractor.getCity());
        data = data + AesEncrypter.getEncryptedString() + " ";
        AesEncrypter.encrypt(contractor.getCvr());
        data = data + AesEncrypter.getEncryptedString() + "\n";

        return data;
    }
}
