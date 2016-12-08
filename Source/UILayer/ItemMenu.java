package UILayer;
import ControlLayer.*;
import ModelLayer.ItemContainer;

import java.util.ArrayList;

import static UILayer.MenuText.*;
/**
 * Created by Luke on 08/12/2016.
 */
public class ItemMenu {
    ItemControl itemControl = new ItemControl();
    public int Menu(){
        ItemControl itemControl = new ItemControl();

        int choice;

        do{
           MenuText.write(ITEM_MENU);
            choice = Input.readInt();
            switch(choice) {
                case 1: //create
                    if (itemControl.addItem(Input.readString(), Input.readString(), Input.readString(), +Input.readInt(), Input.readInt(), Input.readInt(), Input.readInt(), Input.readString())){
                        MenuText.write(SUCCESS);
            }
                    else {
                         MenuText.write(FAILURE);
            }
                    break;

                case 2: //read
                    ArrayList<String> loans = loanControl.readLoan(InputChecker.verifySaleNumberID());
                    if (loans != null) {
                        System.out.println(loans);
                    }
                    else {
                        MenuText.write(FAILURE);
                    }
                    break;
                case 3: // update
                    String numberID = InputChecker.verifySaleNumberID();
                    ArrayList<String> loans2 = loanControl.readLoan(numberID);
                    if (loans2 != null) {
                        System.out.println(loans2);
                    }
                    else {
                        MenuText.write(FAILURE);
                        break;
                    }
                    int fieldNumber = InputChecker.verifyFieldNumber(loans2.size());
                    Object fieldInfo = checkData(fieldNumber);
                    if (loanControl.updateLoan(numberID, fieldNumber, fieldInfo)) {
                        MenuText.write(SUCCESS);
                    }
                case 4:
                    //retrieve leasing
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

    public Object checkData(int fieldNumber)
    {
        switch (fieldNumber)
        {
            case 1:
                return InputChecker.verifySaleNumberID();
            case 2:
                return InputChecker.verifyQuantity();
            case 3:
                return InputChecker.verifyPrice();
            case 4:
                return InputChecker.verifyId(2);
            case 5:
                return InputChecker.verifyDate();
            case 6:
                return InputChecker.verifyPeriod();
            default:
                return null;
        }
    }
}