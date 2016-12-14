package UILayer;

import ControlLayer.LoanControl;

import java.util.ArrayList;
import java.util.HashMap;

import static UILayer.MenuText.*;


/**
 * Created by Admin on 12/7/2016.
 */
public class LoanMenu {
    public int menu() {
        LoanControl loanControl = new LoanControl();
        int choice;

        do {
            MenuText.write(LOAN_MENU);
            choice = Input.readInt();

            switch (choice) {
                case 1: //create
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
                    loanControl.getAvailableItems(place, items, InputChecker.verifySaleNumberID(), InputChecker.verifyId(2), InputChecker.verifyPeriod());
                    break;
                case 2: //read
                    ArrayList<String> loans = loanControl.readLoan(InputChecker.verifySaleNumberID());
                    if (loans!=null) {
                        for(String loan: loans)System.out.println(loan);
                    } else {
                        MenuText.write(FAILURE);
                    }
                    break;
                case 3: // update
                    String numberID = InputChecker.verifySaleNumberID();
                    ArrayList<String> loans2 = loanControl.readLoan(numberID);
                    if (loans2!=null) {
                        for(String loan: loans2)System.out.println(loan);
                    } else {
                        MenuText.write(FAILURE);
                        break;
                    }
                    int fieldNumber = InputChecker.verifyFieldNumber(loans2.size());
                    Object fieldInfo = checkData(fieldNumber);
                    if (loanControl.updateLoan(numberID, fieldNumber, fieldInfo)) {
                        MenuText.write(SUCCESS);
                    }
                    break;
                case 4:
                    String numberID2 = InputChecker.verifySaleNumberID();
                    if(loanControl.retrieveLoan(numberID2))MenuText.write(SUCCESS);
                    else MenuText.write(FAILURE);;
                    break;
                case 5:
                    //go back
                    break;
                case 6:
                    //exit
                    break;
                default:
                    System.out.println("Choice must be a value between 1 and 6.");
            }
        }
        while (choice != 5 && choice != 6);
        return choice == 6 ? 7 : 1;
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
            case 5:
                return InputChecker.verifyPeriod();
            default:
                return null;
        }
    }
}
