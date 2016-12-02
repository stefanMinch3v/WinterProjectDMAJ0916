package ControlLayer;
import ModelLayer.*;

/**
 * Created by RedJohn on 23-Nov-16.
 */
public class EmployeeControl {
private EmployeeContainer employeeContainer;

    public EmployeeControl() {
        employeeContainer = EmployeeContainer.getInstance();
    }
    public void addEmployee(String name, String address, String email, String phone, String city, String CPR, String workID) {

        Employee employee = new Employee(name, address, email, phone, city, CPR, workID);
        employeeContainer.addEmployee(employee);
    }

    public String readEmployee(String cpr) { //TODO: return string of all the info that will be printed in MainMenuUI
        if( findEmployee(cpr) >= 0 )
        {   Employee employee = employeeContainer.getEmployee(findEmployee(cpr));
            return ( "NAME: "+employee.getName()+"\nCITY: "+employee.getCity()+"\nADDRESS: "+employee.getAddress()+"\nCPR: "+employee.getCPR()+"\nEMAIL: "+employee.getEmail()+"\nPHONE: "+employee.getPhone() );
        }
        else
            return String.valueOf(findEmployee(cpr));
    }


    public String updateEmployee(int index, int updateType, String newInfo) {
        switch(updateType)
        {
            case 1:
                employeeContainer.getEmployee(index).setCPR(newInfo);
                break;
            case 2:
                employeeContainer.getEmployee(index).setName(newInfo);
                break;
            case 3:
                employeeContainer.getEmployee(index).setAddress(newInfo);
                break;
            case 4:
                employeeContainer.getEmployee(index).setEmail(newInfo);
                break;
            case 5:
                employeeContainer.getEmployee(index).setPhone(newInfo);
                break;
            case 6:
                employeeContainer.getEmployee(index).setCity(newInfo);
                break;
            case 7:
                employeeContainer.getEmployee(index).setWorkID(newInfo);
                break;
        }
        return newInfor( employeeContainer.getEmployee(index).getCPR() );
    }

    private String newInfor(String cpr)
    {
        Employee employee = employeeContainer.getEmployee(findEmployee(cpr));
        return ( "NAME: "+employee.getName()+"\nCITY: "+employee.getCity()+"\nADDRESS: "+employee.getAddress()+"\nCPR: "+employee.getCPR()+"\nEMAIL: "+employee.getEmail()+"\nPHONE: "+employee.getPhone() );
    }

    public int deleteEmployee(String CPR) {
        if (findEmployee(CPR) >= 0)
        {
            employeeContainer.removeEmployee(findEmployee(CPR));
            return findEmployee(CPR);
        } else
            return findEmployee(CPR);
    }

    private  int findEmployee(String CPR) {
        for (int i = 0; i < employeeContainer.getEmployeesSize(); i++)
            if (employeeContainer.getEmployee(i).getCPR().equals(CPR))
                return i;
        return -1; 
    }
}
