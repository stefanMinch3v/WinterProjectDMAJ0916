package UILayer;
import ControlLayer.ItemControl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static UILayer.ErrorCode.*;

/**
 * Created by EU on 2016-12-01.
 */
public class InputChecker {
    private static String id, name, address, email, phone, city, workId, numberID, barcode, type, place; // not ready yet.
    private static int quantity, periodOfTime;
    private static double price, costPrice, tradeAllowance, retailPrice;
    private static boolean ok;
    public static ItemControl itemControl = new ItemControl();;
    public static ArrayList<String> existingIds = new ArrayList<>();
    public static ArrayList<String> existingBarcodes = new ArrayList<>();// keeping track of all of the CPR and CVR so we can make sure they are unique
    private static InputChecker instance;

    public InputChecker() {
        existingIds = new ArrayList<>();
        existingBarcodes = new ArrayList<>();

    }

    public static InputChecker getInstance() {
        if (instance == null) {
            instance = new InputChecker();
        }
        return instance;
    }

    public static String verifyId(int check) {
        id = null; // making sure it is empty before starting the process
        do {
            System.out.println("Please input user's CPR/CVR.");
            ok = true;
            id = Input.readString();
            if (id.length() != 10 || (!id.matches("[0-9]+"))) { // checking if the ID(CPR/CVR) is correct from a logical point of view(10 numbers and no characters)
                ok = false;
                ErrorCode.print(WRONG_CPR_INPUT);
            }


            if (existingIds.size() > 0 && check != 2 && ok) {
                for (int i = 0; i < existingIds.size(); i++) // if the ID (CPR/CVR) already exists in the system
                {
                    if (check == 3) //if you want to delete one customer/contractor
                        existingIds.remove(i); // remove his CPR/CVR from the system

                    if (existingIds.get(i).equals(id) && check == 1) {
                        ok = false;
                        ErrorCode.print(ID_ALREADY_EXISTS);
                    }
                }
            }

        } while (!ok);

        if (check == 1)
            existingIds.add(id); // adding the unique id to the system


        return id;
    }

    public static String verifyName() {
        name = null;    // making sure it is empty before starting the process
        do {
            System.out.println("Please input the name.");
            ok = true;
            name = Input.readString();
            if (name.length() <= 3) {
                ok = false;
                ErrorCode.print(WRONG_NAME_INPUT);
            }
        } while (!ok);

        return name;
    }

    public static String verifyAddress() {
        address = null; // making sure it is empty before starting the process

        do {
            System.out.println("Please input the address.");
            ok = true;
            address = Input.readString();
            if (!address.matches(".*\\d+.*") || address.length() < 3) //checks if there is at least one number in the string
            {
                ok = false;
                ErrorCode.print(WRONG_ADDRESS_INPUT);
            }
        } while (!ok);

        return address;
    }

    public static String verifyEmail() {
        do {
            System.out.println("Please input user's email.");
            email = null; // making sure it is empty before starting the process
            ok = true;
            email = Input.readString();
            if (!(email.toLowerCase().contains("@") && email.toLowerCase().contains(".")) || email.length() < 5) // checks if email is at least 5 characters and contains @ and .
            {
                ok = false;
                ErrorCode.print(WRONG_EMAIL_INPUT);
            }
        } while (!ok);

        return email;
    }

    public static String verifyPhone() {
        phone = null; // making sure it is empty before starting the process

        do {
            System.out.println("Please input the phone number.");
            ok = true;
            phone = Input.readString();
            if (!phone.matches("[0-9]+")) //checks if string is composed only of numbers
            {
                ok = false;
                ErrorCode.print(WRONG_PHONE_INPUT);
            }

            if (phone.length() < 6 || phone.length() > 16) {
                ok = false;
                ErrorCode.print(WRONG_PHONE_LENGTH_INPUT);
            }
        } while (!ok);

        return phone;
    }

    public static int verifyFieldNumber(int index) {
        int inputIndex; //

        do {
            System.out.println("Please input the field's number.");
            ok = true;
            inputIndex = Input.readInt();
            if (inputIndex > index) {
                ok = false;
                ErrorCode.print(WRONG_INT_INPUT);
            }
        } while (!ok);

        return inputIndex;
    }

    public static String verifyCity() {
        city = null; // making sure it is empty before starting the process

        do {
            System.out.println("Please input the city.");
            ok = true;
            city = Input.readString();
            if (city.length() < 3) {
                ok = false;
                ErrorCode.print(WRONG_CITY_INPUT);
            }
        } while (!ok);

        return city;
    }

    public static String verifyWorkId(int check) {
        workId = null; // making sure it is empty before starting the process

        do {
            System.out.println("Please input the worker's identification number.");
            ok = true;
            workId = Input.readString();
            if (workId.length() != 6 || (!workId.matches("[0-9]+"))) // checking if
            {
                ok = false;
                ErrorCode.print(WRONG_WORKID_INPUT);
            }

            if (existingIds.size() > 0)
                for (int i = 0; i < existingIds.size(); i++) // if the WorkI already exists in the system
                {
                    if (check == 3) // if you want to delete an employee
                        existingIds.remove(i); // remove his workId from the system aswell

                    if (existingIds.get(i).equals(workId) && check == 1) {
                        ok = false;
                        ErrorCode.print(ID_ALREADY_EXISTS);
                    }
                }

        } while (!ok);

        if (check == 1)
            existingIds.add(workId); // adding the workId to the list

        return workId;
    }

    public static String verifySaleNumberID() {
        numberID = null; // make sure it is empty before starting the process

        do {
            System.out.println("Please input the identification number.");
            ok = true;
            numberID = Input.readString();
            if (numberID.length() <= 4 || (!numberID.matches("[0-9]+"))) {
                ok = false;
                ErrorCode.print(WRONG_SALE_OR_LOAN_NUMBERID);
            }
            /*if(existingIds.isEmpty())getInstance();
            for (int i = 0; i < existingIds.size(); i++) // if the WorkI already exists in the system
                if (existingIds.get(i).equals(workId)) {
                    ok = false;
                    ErrorCode.print(ID_ALREADY_EXISTS);
                }*/
        } while (!ok);

        //existingIds.add(numberID); // adding the workId to the list
        return numberID;
    }

    public static int verifyQuantity() {
        quantity = 0; // make sure it is empty before starting the process

        do {
            System.out.println("Please input the quantity.");
            ok = true;
            quantity = Input.readInt();
            if (quantity <= 0) {
                ok = false;
                ErrorCode.print(WRONG_QUANTITY);
            }
        } while (!ok);

        return quantity;
    }

    public static double verifyPrice() {
        price = 0; // make sure it is empty before starting the process

        do {
            System.out.println("Please input the current price.");
            ok = true;
            price = Input.readInt();
            if (price <= 0) {
                ok = false;
                ErrorCode.print(WRONG_PRICE);
            }
        } while (!ok);

        return price;
    }

    public static int verifyPeriod() {
        periodOfTime = 0; // make sure it is empty before starting the process

        do {
            System.out.println("Please input the period of time,in days.");
            ok = true;
            periodOfTime = Input.readInt();
            if (periodOfTime <= 0) {
                ok = false;
                ErrorCode.print(WRONG_PERIOD);
            }
        } while (!ok);

        return periodOfTime;
    }

    public static String verifyItemBarcode() {
        System.out.println("Type done if there is no barcode to be inputted.");
        do {
            System.out.println("Please input item's barcode. ");

            ok = true;
            barcode = Input.readString().toLowerCase();
            if(barcode.length()<4){
                ok = false;
            }

        } while (!ok);
    return barcode;
    }
    public static int getQuantityAtPlace(String place, String barcode)
    {
       int availableQuantity = itemControl.getQuantityAtPlace(place, barcode);
        do {
            System.out.println("Please input a quantity that is lesser or equal to " + availableQuantity + ".");
            ok = true;
            quantity = Input.readInt();
            if (quantity > availableQuantity) {
                ok = false;
                ErrorCode.print(WRONG_QUANTITY);
            }
        } while (!ok);

        return quantity;

    }

    public static double verifyCostPrice()

    {
        costPrice = 0; // make sure it is empty before starting the process

        do {
            System.out.println("Please input item's cost price. ");
            ok = true;
            costPrice = Input.readInt();
            if (costPrice <= 0) {
                ok = false;
                ErrorCode.print(WRONG_PRICE);
            }
        } while (!ok);

        return (double) costPrice;
    }

    public static double verifyTradeAllowance()

    {
        tradeAllowance = 0; // make sure it is empty before starting the process

        do {
            System.out.println("Please input item's trade allowance price. ");
            ok = true;
            tradeAllowance = Input.readInt();
            if (tradeAllowance < 0) {
                ok = false;
                ErrorCode.print(WRONG_PRICE);
            }
        } while (!ok);
        return (double) tradeAllowance;


    }

    public static double verifyRetailPrice() {
        retailPrice = 0; // make sure it is empty before starting the process

        do {
            System.out.println("Please input item's retail price. ");
            ok = true;
            retailPrice = Input.readInt();
            if (retailPrice < 0) {
                ok = false;
                ErrorCode.print(WRONG_PRICE);
            }
        } while (!ok);
        return (double) retailPrice;


    }

    public static String verifyType() {
        type = null;    // making sure it is empty before starting the process
        do {
            System.out.println("Please input item's type. ");
            ok = true;
            type = Input.readString();
            if (type.length() < 2) {
                ok = false;
                ErrorCode.print(WRONG_NAME_INPUT);
            }
        } while (!ok);

        return type;
    }

    public static String verifyPlace() {
        place = null;    // making sure it is empty before starting the process
        do {
            System.out.println("Please input item's place, Timber or DIY.");
            ok = true;
            place = Input.readString().toLowerCase();
            if (!((place.equals("timber"))||(place.equals("diy")))) {
                ok = false;
                ErrorCode.print(WRONG_NAME_INPUT);
            }
        } while (!ok);

        return place;
    }
}