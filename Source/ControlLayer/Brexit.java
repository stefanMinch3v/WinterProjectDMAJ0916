package ControlLayer;
import ModelLayer.*;
import UILayer.AesEncrypter;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by EU on 2016-12-09.
 */
public class Brexit {

    CustomerContainer customerContainer;
    EmployeeContainer employeeContainer;
    ContractorContainer contractorContainer;
    ItemContainer itemContainer;
    public Brexit()
    {
        customerContainer = CustomerContainer.getInstance();
        employeeContainer = EmployeeContainer.getInstance();
        contractorContainer = ContractorContainer.getInstance();
        itemContainer = ItemContainer.getInstance();
    }

    public void exit()
    {
        try{
            // create new file
            String content;
            String pathCustomer="Source//DATA//Customer.txt";
            String pathContractor="Source//DATA//Contractorr.txt";
            String pathEmployee = "Source//DATA//Employee.txt";
            String pathItem = "Source//DATA//Item.txt";
            //TODO:for Sale, Leasing when they are ready fix for Contractor when is ready

            File dir = new File("Source//DATA"); // create the folder "DATA" if it doesn't exist already
            dir.mkdir();

            File fileCustomer = new File(pathCustomer);
            File fileContractor = new File(pathContractor);
            File fileEmployee = new File(pathEmployee);
            File fileItem = new File(pathItem);




//CUSTOMER
            if(customerContainer.getCustomersSize() > 0) {

                if ( !fileCustomer.exists() ) {
                    fileCustomer.createNewFile();
                }

                FileWriter fw1 = new FileWriter(fileCustomer.getAbsoluteFile());
                BufferedWriter bw1 = new BufferedWriter(fw1);
                // write in file
                bw1.write(customerContainer.getCustomersSize() + "\r\n");  // write the number of customers and 2 new lines
                for (int i = 0; i < customerContainer.getCustomersSize(); i++) {
                    content = null;
                    content = customerContainer.saveData(i);
                    bw1.write(content);
                }
                bw1.close();
            }
//EMPLOYEE
            if(employeeContainer.getEmployeesSize() > 0) {

                if ( !fileCustomer.exists() ) {
                    fileEmployee.createNewFile();
                }

                FileWriter fw2 = new FileWriter(fileEmployee.getAbsoluteFile());
                BufferedWriter bw2 = new BufferedWriter(fw2);
                // write in file
                bw2.write(employeeContainer.getCustomersSize() + "\r\n");  // write the number of employees and 2 new lines
                for (int i = 0; i < employeeContainer.getCustomersSize(); i++) {
                    content = null;
                    content = employeeContainer.saveData(i);
                    bw2.write(content);
                }
                bw2.close();
            }
//CONTRACTOR
            if(contractorContainer.getContractorSize() > 0) {

                if ( !fileCustomer.exists() ) {
                    fileContractor.createNewFile();
                }

                FileWriter fw3 = new FileWriter(fileContractor.getAbsoluteFile());
                BufferedWriter bw3 = new BufferedWriter(fw3);
                // write in file
                bw3.write(contractorContainer.getContractorSize() + "\r\n");  // write the number of contractors and 2 new lines
                for (int i = 0; i < contractorContainer.getContractorSize(); i++) {
                    content = null;
                    content = contractorContainer.saveData(i);// get the encrypted string
                    bw3.write(content);// write it in the file
                }
                bw3.close();// close the file
            }

//ITEM
            if(itemContainer.getItemsSize() > 0){
                if( !fileItem.exists() ){
                    fileItem.createNewFile();
                }

                FileWriter fw4 = new FileWriter(fileItem.getAbsoluteFile()); // the filewriter will write in this absolute file (overwrite it each time it is called)
                BufferedWriter bw4 = new BufferedWriter(fw4);
                //write in file
                bw4.write(itemContainer.getItemsSize()+"\r\n"); // write the number of items and 2 new lines
                for(int i = 0; i < itemContainer.getItemsSize(); i++){
                    content = null;
                    content = itemContainer.saveData(i); // get the encrypted string
                    bw4.write(content); // write it in the file
                }
                bw4.close(); // close the file
            }



        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void load()
    {
        loadCustomer();
        loadContractor();
        loadEmployee();
        loadItem();
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
                            AesEncrypter.decrypt(field); // decript the string
                            fields.add(AesEncrypter.getDecryptedString()); // add it to the arraylist
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
                            AesEncrypter.decrypt(field); // decript the string
                            fields.add(AesEncrypter.getDecryptedString()); // add it to the arrayList
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
                                AesEncrypter.decrypt(field); // decript the string
                                fields.add(AesEncrypter.getDecryptedString()); // add it to the arrayList
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

    private boolean loadItem() {
        ArrayList<String>fields = new ArrayList<>();
        int k=0;

        File file = new File("Source//DATA//Item.txt");
        if (!file.exists()) { // if file doesn't exist
            return false;
        }
            try{
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
                        // Item fields read loop
                        while( current != '\n' )
                        {
                            if( current != ' ' )
                                field = field + current;
                            else
                            {
                                AesEncrypter.decrypt(field); // decript the string
                                fields.add(AesEncrypter.getDecryptedString()); // add it to the arrayList
                                field = "";
                            }
                            current = (char) fis.read();
                        }

                        fields.add(field);
                        field = "";
                        Item item = new Item(fields.get(k), fields.get(k+1),fields.get(k+2), Double.parseDouble( fields.get(k+3) ), Double.parseDouble( fields.get(k+4) ),  Double.parseDouble( fields.get(k+5) ), Integer.parseInt( fields.get(k+6) ), "DIY");
                        item.setQuantityAtTimber( Integer.parseInt(fields.get(k+7)) );
                        itemContainer.addItem(item);
                        k=k+8;
                    }

                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return true;
            }



}
