package ModelLayer;

import java.util.ArrayList;
import java.util.Iterator;

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

    public  boolean addEmployee(Employee employee) {
        employees.add(employee);
        return true;
    }



    public Employee getEmployeeByCPR(String CPR){
        for (Employee employee:employees){
            if(employee.getCPR().equals(CPR))return employee;
        }
        return null;
    }
    public  Employee getEmployee(int index) {
        return employees.get(index);
    }

    public  int getEmployeesSize() {
        return employees.size();
    }

    public ArrayList<String> getEmployeesFieldsByCPR(String CPR){
        ArrayList<String> employeeFields = new ArrayList<>();
        for (Employee employee:employees) {
            if(employee.getCPR().equals(CPR)) {
                employeeFields.add("1. Name: "+ employee.getName());
                employeeFields.add("2. Address: "+ employee.getAddress());
                employeeFields.add("3. Email: "+ employee.getEmail());
                employeeFields.add("4. Phone: "+ employee.getPhone());
                employeeFields.add("5. City: "+ employee.getCity());
                employeeFields.add("6. WorkID: "+ employee.getWorkID());
                employeeFields.add("7. CPR"+employee.getCPR());
            }
        }
        return employeeFields;
    }

    public Employee findEmployeeByCPR(String CPR){
        for (Employee employee:employees) {
            if(employee.getCPR().equals(CPR))return employee;
        }
        return null;
    }

    public  boolean removeEmployeeByCPR(String CPR) {
        Iterator<Employee> it = employees.iterator();
        while(it.hasNext()){
           Employee employee= it.next();
            if(employee.getCPR().equals(CPR)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

}