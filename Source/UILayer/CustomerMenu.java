package UILayer;

import ControlLayer.Brexit;
import ControlLayer.CustomerControl;

import java.util.ArrayList;

import static UILayer.ErrorCode.NO_SUCH_CUSTOMER;
import static UILayer.MenuText.*;


/**
 * Created by EU on 2016-12-01.
 */
public class CustomerMenu {

    private CustomerControl customerControler;

    public int menu() {
        customerControler = new CustomerControl();
        Brexit brexit = new Brexit();

        int choice;

        do {
            MenuText.write(CUSTOMER_MENU);
            choice = Input.readInt();

            switch (choice) {
                case 1: // create
                    if (customerControler.createCustomer(InputChecker.verifyId(1), InputChecker.verifyName(), InputChecker.verifyAddress(), InputChecker.verifyEmail(), InputChecker.verifyPhone(), InputChecker.verifyCity()))
                        MenuText.write(SUCCESS);
                    else
                        MenuText.write(FAILURE);
                    break;
                case 2: // read
                    ArrayList<String> aux = customerControler.getCustomerByCpr(InputChecker.verifyId(2));
                    if (aux!=null)
                        for(String au:aux)System.out.println(au);
                    else
                        ErrorCode.print(NO_SUCH_CUSTOMER);
                    break;
                case 3: // update
                    String cpr = InputChecker.verifyId(2);
                    ArrayList<String> aux2 = customerControler.getCustomerByCpr(cpr);
                    if (aux2!=null)
                        for(String au:aux2)
                            System.out.println(au);
                    else {
                        ErrorCode.print(NO_SUCH_CUSTOMER);
                        break;
                    }
                    int fieldNumber = InputChecker.verifyFieldNumber(aux2.size());
                    String fieldInfo = checkData(fieldNumber);
                    if (customerControler.changeCustomerFieldByCpr(cpr, fieldNumber, fieldInfo))
                        MenuText.write(SUCCESS);
                    else
                        MenuText.write(FAILURE);
                    break;
                case 4: // delete
                    if (customerControler.deleteCustomer(InputChecker.verifyId(3)))
                        MenuText.write(SUCCESS);
                    else
                        ErrorCode.print(NO_SUCH_CUSTOMER);
                    break;
                case 5:
                    // go back
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Choice must be a value between 1 and 6.");
            }
        } while (choice != 5 && choice != 6);
        brexit.exit();
        if (choice == 6) return 7;
        else return 1;
    }

    private String checkData(int fieldNumber) {
        switch (fieldNumber) {
            case 1:
                return InputChecker.verifyId(2);
            case 2:
                return InputChecker.verifyName();
            case 3:
                return InputChecker.verifyAddress();
            case 4:
                return InputChecker.verifyEmail();
            case 5:
                return InputChecker.verifyPhone();
            case 6:
                return InputChecker.verifyCity();
            default:
                return null;
        }
    }
}
