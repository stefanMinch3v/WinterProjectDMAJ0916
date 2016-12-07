package UILayer;

import ControlLayer.CustomerControl;

import java.util.ArrayList;

import static UILayer.ErrorCode.NO_SUCH_CUSTOMER;
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
                    if(customerControler.createCustomer(InputChecker.verifyId(), InputChecker.verifyName(),InputChecker.verifyAddress(),InputChecker.verifyEmail(),InputChecker.verifyPhone(),InputChecker.verifyCity()))
                        MenuText.write(SUCCESS);
                    else
                        MenuText.write(FAILURE);
                    break;
                case 2: // read
                    ArrayList<String> aux = customerControler.getCustomerByCpr(InputChecker.verifyId());
                    if(aux != null)
                        System.out.println(aux);
                    else
                        ErrorCode.print(NO_SUCH_CUSTOMER);
                    break;
                case 3: // update
                    String cpr = InputChecker.verifyId();
                    ArrayList<String> aux2 = customerControler.getCustomerByCpr(cpr);
                    if(aux2 != null) System.out.println(aux2);
                    else {
                        ErrorCode.print(NO_SUCH_CUSTOMER);
                        break;
                    }
                    int fieldNumber = InputChecker.verifyFieldNumber(aux2.size());
                    String fieldInfo = checkData(fieldNumber);
                    if(customerControler.changeCustomerFieldByCpr(cpr, fieldNumber, fieldInfo))
                        MenuText.write(SUCCESS);
                    else
                        MenuText.write(FAILURE);
                    break;
                case 4: // delete
                    if(customerControler.deleteCustomer( InputChecker.verifyId()))
                        MenuText.write(SUCCESS);
                    else
                        ErrorCode.print(NO_SUCH_CUSTOMER);
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

    private String checkData(int fieldNumber)
    {
        switch (fieldNumber)
        {
            case 1:
                return InputChecker.verifyId();
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
