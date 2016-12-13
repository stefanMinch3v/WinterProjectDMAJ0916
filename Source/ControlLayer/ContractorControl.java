package ControlLayer;

import ModelLayer.Contractor;
import ModelLayer.ContractorContainer;

import java.util.ArrayList;


/**
 * Created by RedJohn on 23-Nov-16.
 */
public class ContractorControl {
    private ContractorContainer contractorContainer;

    public ContractorControl() {
        contractorContainer = ContractorContainer.getInstance();
    }

    //CREATE
    public boolean createContractor(String cvr, String name, String address, String email, String phone, String city) {
        Contractor contractor = new Contractor(name, address, email, phone, city, cvr);
        return contractorContainer.addContractor(contractor);
    }

    //READ
    public ArrayList<String> readContractor(String cvr) {
        return contractorContainer.getContractorFieldsByCvr(cvr);
    }

    //UPDATE
    public boolean changeContractorFieldByCvr(String cvr, int fieldNumber, Object fieldInfo) {
        Contractor contractor = contractorContainer.findContractorByCvr(cvr);
        return contractor.setField(fieldNumber, fieldInfo);
    }

    //DELETE
    public boolean deleteContractor(String cvr) { // asumes there is at least 1 customer in the system
        return contractorContainer.removeContractorByCvr(cvr);
    }

}
