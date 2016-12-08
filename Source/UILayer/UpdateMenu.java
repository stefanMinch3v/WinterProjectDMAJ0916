package UILayer;

import ControlLayer.CustomerControl;

import static UILayer.MenuText.*;

/**
 * Created by EU on 2016-11-27.
 */
public abstract class UpdateMenu {

    public static void customerInfo(String indexS) {
        MenuText.write(UPDATE_CUSTOMER_MENU);
        int indexI = Integer.parseInt(indexS);
        int choice;
        String updatedInfo = "";
        do {
            choice = Input.readInt();

            switch (choice) {
                case 1: // CPR
                    updatedInfo = InputChecker.verifyId();

                    System.out.println("Update successful, customers new info is:\n"+ CustomerControl.updateCustomer(indexI, 1, updatedInfo) );
                    break;
                case 2: // Name
                    updatedInfo = InputChecker.verifyName();

                    System.out.println("Update successful, customers new info is:\n"+ CustomerControl.updateCustomer(indexI, 2, updatedInfo) );
                    break;
                case 3: // Address
                    updatedInfo = InputChecker.verifyAddress();
                    System.out.println("Update successful, customers new info is:\n"+ CustomerControl.updateCustomer(indexI, 3, updatedInfo) );
                    break;
                case 4: // Email
                    updatedInfo = InputChecker.verifyEmail();
                    System.out.println("Update successful, customers new info is:\n"+ CustomerControl.updateCustomer(indexI, 4, updatedInfo) );
                    break;
                case 5: // Phone
                    updatedInfo = InputChecker.verifyPhone();
                    System.out.println("Update successful, customers new info is:\n"+ CustomerControl.updateCustomer(indexI, 5, updatedInfo) );
                    break;
                case 6: // City
                    updatedInfo = InputChecker.verifyCity();
                    System.out.println("Update successful, customers new info is:\n"+ CustomerControl.updateCustomer(indexI, 6, updatedInfo) ); // print the new information
                    break;
                case 7:
                    // .. exit program
                    break;
                default:
                    System.out.println("Choice must be a value between 1 and 7.");
            }
        } while (choice != 7);
    }
}
