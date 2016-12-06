package ControlLayer;
import ModelLayer.*;


/**
 * Created by RedJohn on 23-Nov-16.
 */
public class ContractorControl {
    private ModelLayer.ContractorContainer contractorContainer;

    public ContractorControl() {
        contractorContainer = ContractorContainer.getInstance();
    }

    public  void addContractor(String name, String address, String email, String phone, String city, String CVR) {

        Contractor contractor = new Contractor(name, address, email, phone, city, CVR);
        contractorContainer.addContractor(contractor);
    }

    public  String readContractor(String name) { //TODO: return string of all the info that will be printed in MainMenuUI
        if( findContractor(name) >= 0 )
        {   Contractor contractor = contractorContainer.getContractor(findContractor(name));
            return ( "NAME: "+contractor.getName()+"\nCITY: "+contractor.getCity()+"\nADDRESS: "+contractor.getAddress()+"\nCPR: "+contractor.getCVR()+"\nEMAIL: "+contractor.getEmail()+"\nPHONE: "+contractor.getPhone() );
        }
        else
            return String.valueOf(findContractor(name));
    }

    public boolean updateContractor(String CVR, int fieldNumber, Object fieldInfo) {
        Contractor cont = contractorContainer.getContractorByID(CVR);
        return cont.updateFields(fieldNumber, fieldInfo);
    }

    public  int deleteContractor(String CVR) {
        if (findContractor(CVR) >= 0)
        {
            contractorContainer.removeContractor(findContractor(CVR));
            return findContractor(CVR);
        } else
            return findContractor(CVR);
    }

    private  int findContractor(String CVR) {
        for (int i = 0; i < contractorContainer.getContractorsSize(); i++)
            if (contractorContainer.getContractor(i).getName().equals(CVR))
                return i;
        return -1;
    }
}
