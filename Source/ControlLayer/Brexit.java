package ControlLayer;
import ModelLayer.Customer;
import ModelLayer.CustomerContainer;
import com.sun.org.apache.xpath.internal.operations.Equals;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by EU on 2016-12-09.
 */
public class Brexit {

    CustomerContainer customerContainer;
    public Brexit()
    {
        customerContainer = CustomerContainer.getInstance();
    }

    public void exit()
    {
        try{
            // create new file
            String content;
            String pathCustomer="Source//DATA//Customer.txt";
            File file = new File(pathCustomer);

            // if file doesnt exists, then create it
            if ( !file.exists() ) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            // write in file

            bw.write( customerContainer.getCustomersSize()+"\r\n" );
            for(int i = 0; i < customerContainer.getCustomersSize(); i++)
            {
                content = null;
                content =  customerContainer.saveData(i);
                bw.write( content );
            }

            // close connection
            bw.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void load()
    {
        loadCustomer();
    }

    private void loadCustomer()
    {
        ArrayList<String>fields = new ArrayList<>();
        int k=0;

        File file = new File("Source//DATA//Customer.txt");
        if (!file.exists()) {
            System.out.println(" does not exist.");

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
    }
}
