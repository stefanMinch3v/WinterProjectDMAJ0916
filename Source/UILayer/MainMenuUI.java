package UILayer;

import ControlLayer.CustomerControl;
import UILayer.Input;
import UILayer.ErrorWriter;
import UILayer.UpdateMenu;
import static UILayer.MenuText.*;


/**
 * Created by RaidenRabit on 23-Nov-16.
 */
public class MainMenuUI {
    public void runMainLoop() {
        MenuText.write(MAIN_MENU);
        int choice;
        do {
            choice = Input.readInt();

            switch (choice) {
                case 1:
                    customerMenu();
                    break;
                case 2:
                    // .. exit program
                    break;
                default:
                    System.out.println("Choice must be a value between 1 and 4.");
            }
        } while (choice != 2);
    }

    private int customerMenu() {


        int choice;
        String cpr;
        do {
            MenuText.write(CUSTOMER_MENU);
            choice = Input.readInt();

            switch (choice) {
                case 1:
                    CustomerInputChecker.addCustomer();
                    break;
                case 2:
                    cpr = CustomerControl.readCustomer(CustomerInputChecker.verifyCpr());
                    if( cpr.length() <= 2 ) // if the string is composed of only 1 character, it means the methode returned only -1, which means there is no such customer in the system
                        ErrorWriter.print(ErrorCode.NO_SUCH_CUSTOMER);
                    else
                        System.out.println( cpr );
                    break;
                case 3:
                    cpr = CustomerControl.readCustomer(CustomerInputChecker.verifyCpr());
                    if( cpr.length() <= 2 ) // if the string is composed of only 1 character, it means the methode returned only -1, which means there is no such customer in the system
                        ErrorWriter.print(ErrorCode.NO_SUCH_CUSTOMER);
                    else
                    {
                        System.out.println( cpr ); // print current information of the customer
                        UpdateMenu.customerInfo( CustomerInputChecker.verifyCpr() );      // go to update menu
                    }
                    break;
                case 4:
                    cpr = CustomerInputChecker.verifyCpr();
                    if ( CustomerControl.deleteCustomer( cpr ) < 0) // if there is no such customer display error, else customer is deleted automatically.
                        ErrorWriter.print(ErrorCode.NO_SUCH_CUSTOMER);
                    break;
                case 5:
                    //...
                    break;
                case 6:
                    //...
                    break;
                default:
                    System.out.println("Choice must be a value between 1 and 6.");
            }
        } while (choice != 5 && choice != 6);

        return (choice == 6) ? 4 : 1;
    }

}
