package UILayer;

import ControlLayer.CustomerControl;
import static UILayer.MenuText.*;



/**
 * Created by EU on 2016-12-01.
 */
public class CustomerMenu {

    private static CustomerControl customerControler;
     public static void customerMenu() {
        customerControler = new CustomerControl();

        int choice;

        do {
            MenuText.write(CUSTOMER_MENU);
            choice = Input.readInt();

            switch (choice) {
                case 1: // create
                    createCustomer(customerControler);
                    break;
                case 2: // read

                    break;
                case 3: // update

                    break;
                case 4: // delete

                    break;
                case 5:
                    MainMenuUI.runMainLoop(); //go back to the previous menu
                    break;
                case 6:
                    //TODO:exit
                    break;
                default:
                    System.out.println("Choice must be a value between 1 and 6.");
            }
        } while (choice != 5 && choice != 6);

    }

    private static void createCustomer(CustomerControl customerControler) {
         String cpr, name, address, email, phone, city;

         //cpr = InputChecker.verifyCPR();
         name = InputChecker.verifyName();
         address = InputChecker.verifyAddress();
         email = InputChecker.verifyEmail();
         phone = InputChecker.verifyPhone();
         city = InputChecker.verifyCity();
         //customerControler.addCustomer(cpr, name, address, email, phone, city);
        //TODO: Fix imput checker for cpr since its not working corectly (null pointer) and fix addCustomer.
    }
}
