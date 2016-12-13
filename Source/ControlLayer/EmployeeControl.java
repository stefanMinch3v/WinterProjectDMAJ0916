package ControlLayer;

import ModelLayer.Employee;
import ModelLayer.EmployeeContainer;
import ModelLayer.LoginContainer;

import java.util.ArrayList;

/**
 * Created by RedJohn on 23-Nov-16.
 */
public class EmployeeControl {
    private EmployeeContainer employeeContainer;
    private LoginContainer loginContainer;

    public EmployeeControl() {
        employeeContainer = EmployeeContainer.getInstance();
        loginContainer = LoginContainer.getInstance();
    }

    //CREATE
    public boolean addEmployee(String name, String address, String email, String phone, String city, String CPR, String workID) {

        Employee employee = new Employee(name, address, email, phone, city, CPR, workID);
        loginContainer.getMapList().put(workID, CPR.substring(5, 9));
        return employeeContainer.addEmployee(employee);

    }

    //READ
    public ArrayList<String> getEmployeeByWorkId(String workId) {
        return employeeContainer.getEmployeesFieldsByWorkId(workId);
    }

    //UPDATE
    public boolean changeEmployeeFieldByWorkId(String workId, int fieldNumber, Object fieldInfo) {
        Employee employee = employeeContainer.findEmployeeByWorkId(workId);
        return employee.setField(fieldNumber, fieldInfo);

    }

    //DELETE
    public boolean deleteEmployee(String workId) {

        return employeeContainer.removeEmployeeByWorkId(workId);
    }
}
