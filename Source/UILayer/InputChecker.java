package UILayer;
import java.util.ArrayList;

import static UILayer.ErrorCode.*;

/**
 * Created by EU on 2016-12-01.
 */
public class InputChecker {
    private static String id, name, address, email, phone, city; // not ready yet.
    private static boolean ok;
    private static ArrayList<String> existingIds; // keeping track of all of the CPR and CVR so we can make sure they are unique

    public static String verifyId() {
        id = null; // making sure it is empty before starting the process
        do {
            ok = true;
            id = Input.readString();
            if (id.length() != 10 || (!id.matches("[0-9]+"))) { // checking if the ID(CPR/CVR) is correct from a logical point of view(10 numbers and no characters)
                ok = false;
                ErrorCode.print(WRONG_CPR_INPUT);
            }


            for(int i=0; i < existingIds.size(); i++) // if the ID (CPR/CVR) already exists in the system
                if(existingIds.get(i).equals(id))
                {
                    ok = false;
                    ErrorCode.print(ID_ALREADY_EXISTS);
                }

        } while (!ok);

        existingIds.add(id); // adding the unique id to the system

        return id;
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
