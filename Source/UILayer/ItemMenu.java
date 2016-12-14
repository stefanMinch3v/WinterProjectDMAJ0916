package UILayer;

import ControlLayer.Authentication;
import ControlLayer.Brexit;
import ControlLayer.ItemControl;

import java.util.ArrayList;

import static UILayer.ErrorCode.NO_SUCH_ITEM;
import static UILayer.MenuText.*;

/**
 * Created by Luke on 08/12/2016.
 */
public class ItemMenu {
    Authentication authentication = new Authentication();

    public int menu() {
        ItemControl itemControl = new ItemControl();
        Brexit brexit = new Brexit();

        int choice;

        do {
            MenuText.write(ITEM_MENU);
            choice = Input.readInt();
            switch (choice) {
                case 1: //create name, type, barcode, costPrice, tradeAllowance, retailPrice, quantity, place
                    if (authentication.adminLogin()) {
                        if (itemControl.addItem(InputChecker.verifyName(), InputChecker.verifyType(), InputChecker.verifyItemBarcode(), InputChecker.verifyCostPrice(), InputChecker.verifyTradeAllowance(), InputChecker.verifyRetailPrice(), InputChecker.verifyQuantity(), InputChecker.verifyPlace())) {
                            MenuText.write(SUCCESS);
                        } else {
                            MenuText.write(FAILURE);
                        }
                    }
                    break;

                case 2: //read
                    ArrayList<String> items = itemControl.getItemByBarcode(InputChecker.verifyItemBarcode());
                    if (items !=null) {
                        for(String item:items) {
                            System.out.println(item);
                        }
                    } else {
                        MenuText.write(FAILURE);
                    }
                    break;
                case 3: // update
                    String barcode = InputChecker.verifyItemBarcode();
                    ArrayList<String> items2 = itemControl.getItemByBarcode(barcode);
                    if (items2!= null) {
                        for(String item:items2) {
                            System.out.println(item);
                        }
                    } else {
                        MenuText.write(FAILURE);
                        break;
                    }
                    int fieldNumber = InputChecker.verifyFieldNumber(items2.size());
                    Object fieldInfo = checkData(fieldNumber);
                    if (itemControl.changeItemFieldByBarcode(barcode, fieldNumber, fieldInfo)) {
                        MenuText.write(SUCCESS);
                    }
                case 4: // delete
                    if (itemControl.deleteItem(InputChecker.verifyItemBarcode()))
                        MenuText.write(SUCCESS);
                    else
                        ErrorCode.print(NO_SUCH_ITEM);
                    break;
                case 5:
                    //go back
                    break;
                case 6:

                    break;
                default:
                    System.out.println("Choice must be a value between 1 and 6.");
            }
        }
        while (choice != 5 && choice != 6);
        brexit.exit();
        return choice == 6 ? 7 : 1;
    }

    public Object checkData(int fieldNumber) {
        switch (fieldNumber) {
            case 1:
                return InputChecker.verifyName();
            case 2:
                return InputChecker.verifyType();
            case 3:
                return InputChecker.verifyItemBarcode();
            case 4:
                return InputChecker.verifyCostPrice();
            case 5:
                return InputChecker.verifyTradeAllowance();
            case 6:
                return InputChecker.verifyRetailPrice();
            case 7:
                return InputChecker.verifyQuantity();
            case 8:
                return InputChecker.verifyQuantity();

            default:
                return null;
        }
    }
}
