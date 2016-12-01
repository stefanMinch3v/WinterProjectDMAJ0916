package UILayer;

import ControlLayer.CustomerControl;
import UILayer.Input;
import UILayer.ErrorCode;
import UILayer.ErrorWriter;

import java.io.PrintWriter;


/**
 * Created by EU on 2016-11-26.
 */
public abstract class CustomerInputChecker {
    private CustomerControl customerControl;
    static String cpr, name, address, email, phone, city;
    static boolean ok;

    public void addCustomer() {
        cpr = verifyCpr();
        name = verifyName();
        address = verifyAddress();
        email = verifyEmail();
        phone = verifyPhone();
        city = verifyCity();

        customerControl.addCustomer(cpr, name, address, email, phone, city); // create customer and add to container
    }

    public static String verifyCpr() {
        cpr = null; // making sure it is empty before starting the process
        do {
            ok = true;
            cpr = Input.readString();
            if (cpr.length() != 10 || (!cpr.matches("[0-9]+"))) {
                ok = false;
                ErrorWriter.print(ErrorCode.WRONG_CPR_INPUT);
            }
        } while (!ok);

        return cpr;
    }

    public static String verifyName() {
        name = null;    // making sure it is empty before starting the process
        do {
            ok = true;
            name = Input.readString();
            if (name.length() <= 3) {
                ok = false;
                ErrorWriter.print(ErrorCode.WRONG_NAME_INPUT);
            }
        } while (!ok);

        return name;
    }

    public static String verifyAddress() {
        address = null; // making sure it is empty before starting the process

        do {
            ok = true;
            address = Input.readString();
            if (address.matches(".*\\d+.*") || address.length() < 3) //checks if there is at least one number in the string
            {
                ok = false;
                ErrorWriter.print(ErrorCode.WRONG_ADDRESS_INPUT);
            }
        } while (!ok);

        return address;
    }

    public static String verifyEmail() {


        do {
            email = null; // making sure it is empty before starting the process
            ok = true;
            email = Input.readString();
            if (!(email.toLowerCase().contains("@") && email.toLowerCase().contains(".")) || email.length() < 5) // checks if email is at least 5 characters and contains @ and .
            {
                ok = false;
                ErrorWriter.print(ErrorCode.WRONG_EMAIL_INPUT);
            }
        } while (!ok);

        return email;
    }

    public static String verifyPhone() {
        phone = null; // making sure it is empty before starting the process

        do {
            ok = true;
            phone = Input.readString();
            if (!phone.matches("[0-9]+")) //checks if string is composed only of numbers
            {
                ok = false;
                ErrorWriter.print(ErrorCode.WRONG_PHONE_INPUT);
            }

            if (phone.length() < 6 || phone.length() > 16) {
                ok = false;
                ErrorWriter.print(ErrorCode.WRONG_PHONE_LENGTH_INPUT);
            }
        } while (!ok);

        return phone;
    }

    public static String verifyCity() {
        city = null; // making sure it is empty before starting the process

        do {
            ok = true;
            city = Input.readString();
            if (city.length() < 3) {
                ok = false;
                ErrorWriter.print(ErrorCode.WRONG_CITY_INPUT);
            }
        } while (!ok);

        return city;
    }
}
