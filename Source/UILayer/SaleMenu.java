package UILayer;

import ControlLayer.SaleControl;

import java.util.ArrayList;
import java.util.HashMap;

import static UILayer.MenuText.*;

/**
 * Created by Admin on 12/7/2016.
 */
public class SaleMenu {
    public int menu() {
        SaleControl saleControl = new SaleControl();
        int choice;

        do {
            MenuText.write(SALE_MENU);
            choice = Input.readInt();

            switch (choice) {
                case 1:
                    String place = InputChecker.verifyPlace();
                    HashMap<String, Integer> items = new HashMap<>();
                    String barcode;
                    int quantity;
                    do {
                        barcode = InputChecker.verifyItemBarcode();
                        if (!barcode.isEmpty() && !barcode.equals("done")) {
                            quantity = InputChecker.getQuantityAtPlace(place, barcode);
                            if (quantity > 0) items.put(barcode, quantity);
                        }
                    } while (!barcode.equals("done"));
                    saleControl.getAvailableItems(place, items, InputChecker.verifySaleNumberID(), InputChecker.verifyId(2));
                    break;
                case 2: // read
                    ArrayList<String> sales = saleControl.readSale(InputChecker.verifySaleNumberID());
                    if (sales!=null)
                        for (String sale : sales)
                        {
                            System.out.println(sale);
                        }
                    else {
                        MenuText.write(FAILURE);
                    }
                    break;
                case 3: // update
                    String numberID = InputChecker.verifySaleNumberID();
                    ArrayList<String> sales2 = saleControl.readSale(numberID);
                    if (sales2!=null) {
                        for (String sale : sales2)
                        {
                            System.out.println(sale);
                        }
                    } else {
                        MenuText.write(FAILURE);
                        break;
                    }
                    int fieldNumber = InputChecker.verifyFieldNumber(sales2.size());
                    Object fieldInfo = checkData(fieldNumber);
                    if (saleControl.updateSale(numberID, fieldNumber, fieldInfo)) {
                        MenuText.write(SUCCESS);
                    }
                case 4:
                    //go back
                    break;
                case 5:
                    //go back
                    break;
                case 6:
                    //exit code
                    break;
                default:
                    System.out.println("Choice must be a value between 1 and 5.");
            }
        } while (choice != 4 && choice != 5 && choice != 6);
        if (choice == 6) {
            return 7;
        } else if (choice == 4) {
            return 5;
        } else {
            return 1;
        }
    }

    public Object checkData(int fieldNumber) {
        switch (fieldNumber) {
            case 1:
                return InputChecker.verifySaleNumberID();
            case 2:
                return InputChecker.verifyQuantity();
            case 3:
                return InputChecker.verifyPrice();
            case 4:
                return InputChecker.verifyId(2);
            default:
                return null;
        }
    }
}
