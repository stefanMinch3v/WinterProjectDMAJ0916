package UILayer;
import ControlLayer.*;

import java.util.ArrayList;

import static UILayer.MenuText.*;

/**
 * Created by EU on 2016-12-01.
 */
public class EmployeeMenu {
    public int menu() {
        EmployeeControl employeeControl = new EmployeeControl();

        int choice;

        do {
            MenuText.write(EMPLOYEE_MENU);
            choice = Input.readInt();

            switch (choice) {
                case 1: // create

                    if(employeeControl.addEmployee(InputChecker.verifyName(),InputChecker.verifyAddress(),InputChecker.verifyEmail(),InputChecker.verifyPhone(),InputChecker.verifyCity(),InputChecker.verifyId(1),InputChecker.verifyWorkId(1))) MenuText.write(SUCCESS);
                    else MenuText.write(FAILURE);
                    break;
                case 2: // read
                    ArrayList<String> aux = employeeControl.getEmployeeByWorkId(InputChecker.verifyId(2));
                    if(aux != null) System.out.println(aux);
                    else MenuText.write(FAILURE);
                    break;
                case 3: // update
                    String workId = InputChecker.verifyId(2);
                    ArrayList<String> aux2 = employeeControl.getEmployeeByWorkId(workId);
                    if(aux2 != null) System.out.println(aux2);
                    else {
                        MenuText.write(FAILURE);
                        break;
                    }
                    int fieldNumber = InputChecker.verifyFieldNumber(aux2.size());
                    String fieldInfo = checkData(fieldNumber);
                    if(employeeControl.changeEmployeeFieldByWorkId(workId, fieldNumber, fieldInfo)) MenuText.write(SUCCESS);
                case 4: // delete
                    if(employeeControl.deleteEmployee( InputChecker.verifyId(3))) MenuText.write(SUCCESS);
                    else MenuText.write(FAILURE);
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
    public String checkData(int fieldNumber)
    {
        switch (fieldNumber)
        {
            case 1:
                return InputChecker.verifyName();
            case 2:
                return InputChecker.verifyAddress();
            case 3:
                return InputChecker.verifyEmail();
            case 4:
                return InputChecker.verifyPhone();
            case 5:
                return InputChecker.verifyCity();
            case 7:
                return InputChecker.verifyWorkId(2);
            case 8:
                return InputChecker.verifyId(2);
            default:
                return null;
        }
    }
}
