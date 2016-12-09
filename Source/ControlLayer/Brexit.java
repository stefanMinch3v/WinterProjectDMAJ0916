package ControlLayer;
import ModelLayer.ContractorContainer;
import ModelLayer.Customer;
import ModelLayer.Contractor;
import ModelLayer.Employee;
import ModelLayer.CustomerContainer;
import ModelLayer.EmployeeContainer;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by EU on 2016-12-09.
 */
public class Brexit {

    CustomerContainer customerContainer;
    EmployeeContainer employeeContainer;
    ContractorContainer contractorContainer;
    public Brexit()
    {
        customerContainer = CustomerContainer.getInstance();
        employeeContainer = EmployeeContainer.getInstance();
        contractorContainer = ContractorContainer.getInstance();
    }

    public void exit()
    {
        try{
            // create new file
            String content;
            String pathCustomer="Source//DATA//Customer.txt";
            String pathContractor="Source//DATA//Contractorr.txt";
            String pathEmployee = "Source//DATA//Employee.txt";
            //TODO:for Item, Sale, Leasing when they are ready

            File dir = new File("Source//DATA"); // create the folder "DATA"
            dir.mkdir();

            File fileCustomer = new File(pathCustomer);
            File fileContractor = new File(pathContractor);
            File fileEmployee = new File(pathEmployee);

            // if file doesnt exists, then create it
            if ( !fileCustomer.exists() ) {
                fileCustomer.createNewFile();
            }


//CUSTOMER
            FileWriter fw1 = new FileWriter(fileCustomer.getAbsoluteFile());
            BufferedWriter bw1 = new BufferedWriter(fw1);
            // write in file
            bw1.write( customerContainer.getCustomersSize()+"\r\n" );
            for(int i = 0; i < customerContainer.getCustomersSize(); i++)
            {
                content = null;
                content =  customerContainer.saveData(i);
                bw1.write( content );
            }
//EMPLOYEE
            FileWriter fw2 = new FileWriter(fileEmployee.getAbsoluteFile());
            BufferedWriter bw2 = new BufferedWriter(fw2);
            // write in file
            bw2.write( employeeContainer.getCustomersSize()+"\r\n" );
            for(int i = 0; i < employeeContainer.getCustomersSize(); i++)
            {
                content = null;
                content =  employeeContainer.saveData(i);
                bw2.write( content );
            }
//CONTRACTOR
            FileWriter fw3 = new FileWriter(fileContractor.getAbsoluteFile());
            BufferedWriter bw3 = new BufferedWriter(fw3);
            // write in file
            bw3.write( contractorContainer.getContractorSize()+"\r\n" );
            for(int i = 0; i < contractorContainer.getContractorSize(); i++)
            {
                content = null;
                content =  contractorContainer.saveData(i);
                bw3.write( content );
            }

            // close connection
            bw1.close();
            bw2.close();
            bw3.close();

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void load()
    {
        loadCustomer();
        loadContractor();
        loadEmployee();
    }

    private boolean loadEmployee() {
        ArrayList<String>fields = new ArrayList<>();
        int k=0;

        File file = new File("Source//DATA//Employee.txt");
        if (!file.exists()) {
            return false;

        }

        try {
            FileInputStream fis = new FileInputStream(file);
            char current;
            String field = "";
            current = (char) fis.read();
            if( String.valueOf(current).matches("[0-9]+") ) // if it is an integer
            {
                int size = Integer.parseInt( String.valueOf( current) );
                for(int i = 0; i < size; i++) // read everything that is after it
                {
                    current = (char) fis.read();
                    current = (char) fis.read();
                    current = (char) fis.read();
                    while( current != '\n' )
                    {
                        if( current != ' ' )
                            field = field + current;
                        else
                        {
                            fields.add(field);
                            field = "";
                        }
                        current = (char) fis.read();
                    }
                    fields.add(field);
                    field = "";
                    Employee employee = new Employee(fields.get(k), fields.get(k+1), fields.get(k+2), fields.get(k+3), fields.get(k+4), fields.get(k+5), fields.get(k+6));
                    employeeContainer.addEmployee(employee);
                    k=k+7;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    private boolean loadContractor(){
        ArrayList<String>fields = new ArrayList<>();
        int k=0;

        File file = new File("Source//DATA//Contractor.txt");
        if (!file.exists()) {
            return false;

        }

        try {
            FileInputStream fis = new FileInputStream(file);
            char current;
            String field = "";
            current = (char) fis.read();
            if( String.valueOf(current).matches("[0-9]+") ) // if it is an integer
            {
                int size = Integer.parseInt( String.valueOf( current) );
                for(int i = 0; i < size; i++) // read everything that is after it
                {
                    current = (char) fis.read();
                    current = (char) fis.read();
                    current = (char) fis.read();
                    while( current != '\n' )
                    {
                        if( current != ' ' )
                            field = field + current;
                        else
                        {
                            fields.add(field);
                            field = "";
                        }
                        current = (char) fis.read();
                    }
                    fields.add(field);
                    field = "";
                    Contractor contractor = new Contractor(fields.get(k), fields.get(k+1), fields.get(k+2), fields.get(k+3), fields.get(k+4), fields.get(k+5));
                    contractorContainer.addContractor(contractor);
                    k=k+6;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;

    }

    private boolean loadCustomer()
    {
        ArrayList<String>fields = new ArrayList<>();
        int k=0;

        File file = new File("Source//DATA//Customer.txt");
        if (!file.exists()) {
            return false;

        }

        try {
            FileInputStream fis = new FileInputStream(file);
            char current;
            String field = "";
                current = (char) fis.read();
                if( String.valueOf(current).matches("[0-9]+") ) // if it is an integer
                {
                    int size = Integer.parseInt( String.valueOf( current) );
                    for(int i = 0; i < size; i++) // read everything that is after it
                    {
                        current = (char) fis.read();
                        current = (char) fis.read();
                        current = (char) fis.read();
                        while( current != '\n' )
                        {
                            if( current != ' ' )
                                field = field + current;
                            else
                            {
                                fields.add(field);
                                field = "";
                            }
                            current = (char) fis.read();
                        }
                        fields.add(field);
                        field = "";
                        Customer customer = new Customer(fields.get(k), fields.get(k+1), fields.get(k+2), fields.get(k+3), fields.get(k+4), fields.get(k+5));
                        customerContainer.addCustomer(customer);
                        k=k+6;
                    }

                }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
}
