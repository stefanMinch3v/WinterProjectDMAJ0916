package ControlLayer;
import ModelLayer.*;

import java.util.ArrayList;

/**
 * Created by RedJohn on 23-Nov-16.
 */
public class EmployeeControl {
private EmployeeContainer employeeContainer;

    public EmployeeControl() {
        employeeContainer = EmployeeContainer.getInstance();
    }
    //CREATE
    public void addEmployee(String name, String address, String email, String phone, String city, String CPR, String workID) {

        Employee employee = new Employee(name, address, email, phone, city, CPR, workID);
        employeeContainer.addEmployee(employee);
    }

    //READ
    public ArrayList<String> getEmployeeByCPR(String CPR){
        return employeeContainer.getEmployeesFieldsByCPR(CPR);
    }

/*//UPDATE
    public boolean changeEmployeeFieldByCPR(String CPR, int fieldNumber, Object fieldInfo)
{
    Employee employee = employeeContainer.getEmployeeByCPR(CPR);
    return employee.setField(fieldNumber,fieldInfo);*/
//TODO: Update, will create cannot be done same as item since we use superclases
//}
//DELETE
public boolean deleteEmployee(String CPR){

    return employeeContainer.removeEmployeeByCPR(CPR);
}

}
