package ModelLayer;

import java.util.ArrayList;

/**
 * Created by RedJohn on 23-Nov-16.
 */
public class EmployeeContainer {
    private  ArrayList<Employee> employees;
    private static EmployeeContainer instance;

    private EmployeeContainer() {
        employees = new ArrayList<>();
    }

    public static EmployeeContainer getInstance() {
        if(instance==null){
            instance = new EmployeeContainer();
        }
        return instance;
    }

    public  void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public  Employee getEmployee(int index) {
        return employees.get(index);
    }

    public  int getEmployeesSize() {
        return employees.size();
    }

    public  void removeEmployee(int index) {
        employees.remove(index);
    }

}
