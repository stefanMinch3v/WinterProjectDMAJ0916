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


    public  String updateContractor(int index, int updateType, String newInfo) {
        switch(updateType)
        {
            case 1:
                contractorContainer.getContractor(index).setCVR(newInfo);
                break;

            case 2:
                contractorContainer.getContractor(index).setName(newInfo);
                break;
            case 3:
                contractorContainer.getContractor(index).setAddress(newInfo);
                break;
            case 4:
                contractorContainer.getContractor(index).setEmail(newInfo);
                break;
            case 5:
                contractorContainer.getContractor(index).setPhone(newInfo);
                break;
            case 6:
               contractorContainer.getContractor(index).setCity(newInfo);
                break;

        }
        return newInfor( contractorContainer.getContractor(index).getCVR() );
    }

    private  String newInfor(String name)
    {
        Contractor contractor = contractorContainer.getContractor(findContractor(name));
        return ( "NAME: "+contractor.getName()+"\nCITY: "+contractor.getCity()+"\nADDRESS: "+contractor.getAddress()+"\nCVR: "+contractor.getCVR()+"\nEMAIL: "+contractor.getEmail()+"\nPHONE: "+contractor.getPhone() );
    }

    public  int deleteContractor(String name) {
        if (findContractor(name) >= 0)
        {
            contractorContainer.removeContractor(findContractor(name));
            return findContractor(name);
        } else
            return findContractor(name);
    }

    private  int findContractor(String name) {
        for (int i = 0; i < contractorContainer.getContractorsSize(); i++)
            if (contractorContainer.getContractor(i).getName().equals(name))
                return i;
        return -1;
    }
}

