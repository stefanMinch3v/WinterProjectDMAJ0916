package UILayer;

import ControlLayer.ContractorControl;

import java.util.ArrayList;

import static UILayer.ErrorCode.NO_SUCH_CONTRACTOR;
import static UILayer.MenuText.*;

/**
 * Created by EU on 2016-12-08.
 */
public class ContractorMenu {

    private ContractorControl contractorControler;
    public int menu() {

        contractorControler = new ContractorControl();

        int choice;

        do {
            MenuText.write(CONTRACOTR_MENU);
            choice = Input.readInt();

            switch (choice) {
                case 1: // create
                    if(contractorControler.createContractor( InputChecker.verifyId(1), InputChecker.verifyName(),InputChecker.verifyAddress(),InputChecker.verifyEmail(),InputChecker.verifyPhone(),InputChecker.verifyCity()))
                        MenuText.write(SUCCESS);
                    else
                        MenuText.write(FAILURE);
                    break;
                case 2: // read
                    ArrayList<String> aux = contractorControler.readContractor(InputChecker.verifyId(2));
                    if(!aux.isEmpty())
                        System.out.println(aux);
                    else
                        ErrorCode.print(NO_SUCH_CONTRACTOR);
                    break;
                case 3: // update
                    String cvr = InputChecker.verifyId(2);
                    ArrayList<String> aux2 = contractorControler.readContractor(cvr);
                    if(!aux2.isEmpty()) System.out.println(aux2);
                    else {
                        ErrorCode.print(NO_SUCH_CONTRACTOR);
                        break;
                    }
                    int fieldNumber = InputChecker.verifyFieldNumber(aux2.size());
                    String fieldInfo = checkData(fieldNumber);
                    if(contractorControler.changeContractorFieldByCvr(cvr, fieldNumber, fieldInfo))
                        MenuText.write(SUCCESS);
                    else
                        MenuText.write(FAILURE);
                    break;
                case 4: // delete
                    if(contractorControler.deleteContractor( InputChecker.verifyId(3)))
                        MenuText.write(SUCCESS);
                    else
                        ErrorCode.print(NO_SUCH_CONTRACTOR);
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

    private String checkData(int fieldNumber) {

        switch (fieldNumber)
        {
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