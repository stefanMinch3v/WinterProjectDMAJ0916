package UILayer;

import ControlLayer.CustomerControl;
import static UILayer.MenuText.*;



/**
 * Created by EU on 2016-12-01.
 */
public class CustomerMenu {

    private  CustomerControl customerControler;
    public int menu() {
        customerControler = new CustomerControl();

        int choice;

        do {
            MenuText.write(CUSTOMER_MENU);
            choice = Input.readInt();

            switch (choice) {
                case 1: // create
                    createCustomer();
                    break;
                case 2: // read

                    break;
                case 3: // update

                    break;
                case 4: // delete

                    break;
                case 5:
                    //go back
                    break;
                case 6:
                    //exit code
                    break;
                default:
                    System.out.println("Choice must be a value between 1 and 6.");
            }
        } while (choice != 5 && choice != 6);
        if(choice == 6) return 7;
        else return 1;
    }

    private  void createCustomer() {
        String cpr, name, address, email, phone, city;
        CustomerControl customerControl = new CustomerControl();
        cpr = InputChecker.verifyId();
        name = InputChecker.verifyName();
        address = InputChecker.verifyAddress();
        email = InputChecker.verifyEmail();
        phone = InputChecker.verifyPhone();
        city = InputChecker.verifyCity();
        customerControl.addCustomer(cpr, name, address, email, phone, city);
    }
}
