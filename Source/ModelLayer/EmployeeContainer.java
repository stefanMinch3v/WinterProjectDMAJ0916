package ModelLayer;

import UILayer.AesEncrypter;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by RedJohn on 23-Nov-16.
 */
public class EmployeeContainer {
    private ArrayList<Employee> employees;
    private static EmployeeContainer instance;

    private EmployeeContainer() {
        employees = new ArrayList<>();
    }

    public static EmployeeContainer getInstance() {
        if (instance == null) {
            instance = new EmployeeContainer();
        }
        return instance;
    }

    public boolean addEmployee(Employee employee) {
        employees.add(employee);
        return true;
    }


    public Employee getEmployeeByCPR(String cpr) {
        for (Employee employee : employees) {
            if (employee.getCpr().equals(cpr)) return employee;
        }
        return null;
    }

    public Employee getEmployee(int index) {
        return employees.get(index);
    }

    public int getEmployeesSize() {
        return employees.size();
    }

    public ArrayList<String> getEmployeesFieldsByWorkId(String workId) {
        ArrayList<String> employeeFields = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getWorkId().equals(workId)) {
                employeeFields.add("1. Name: " + employee.getName());
                employeeFields.add("2. Address: " + employee.getAddress());
                employeeFields.add("3. Email: " + employee.getEmail());
                employeeFields.add("4. Phone: " + employee.getPhone());
                employeeFields.add("5. City: " + employee.getCity());
                employeeFields.add("6. WorkID: " + employee.getWorkId());
                employeeFields.add("7. CPR:" + employee.getCpr());
                return employeeFields;
            }
        }
        return null;
    }

    public Employee findEmployeeByWorkId(String workId) {
        for (Employee employee : employees) {
            if (employee.getWorkId().equals(workId)) return employee;
        }
        return null;
    }

    public boolean removeEmployeeByWorkId(String workId) {
        Iterator<Employee> it = employees.iterator();
        while (it.hasNext()) {
            Employee employee = it.next();
            if (employee.getWorkId().equals(workId)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public int getCustomersSize() {
        return employees.size();
    }

    public String saveData(int index) {
        String data = "";
        Employee employee = employees.get(index);

        AesEncrypter.encrypt(employee.getName());
        data = data + AesEncrypter.getEncryptedString() + " ";
        AesEncrypter.encrypt(employee.getAddress());
        data = data + AesEncrypter.getEncryptedString() + " ";
        AesEncrypter.encrypt(employee.getEmail());
        data = data + AesEncrypter.getEncryptedString() + " ";
        AesEncrypter.encrypt(employee.getPhone());
        data = data + AesEncrypter.getEncryptedString() + " ";
        AesEncrypter.encrypt(employee.getCity());
        data = data + AesEncrypter.getEncryptedString() + " ";
        AesEncrypter.encrypt(employee.getCpr());
        data = data + AesEncrypter.getEncryptedString() + " ";
        AesEncrypter.encrypt(employee.getWorkId());
        data = data + AesEncrypter.getEncryptedString() + " \n";


        return data;
    }

}
