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

                    employeeControl.addEmployee(InputChecker.verifyName(),InputChecker.verifyAddress(),InputChecker.verifyEmail(),InputChecker.verifyPhone(),InputChecker.verifyCity(),InputChecker.verifyId(),InputChecker.verifyWorkId());
                    break;
                case 2: // read
                    ArrayList<String> aux = employeeControl.getEmployeeByWorkId(InputChecker.verifyId());
                    if(aux != null) System.out.println(aux);
                    else System.out.println("Employee not found");
                    break;
                case 3: // update
                    String workId = InputChecker.verifyId();
                    ArrayList<String> aux2 = employeeControl.getEmployeeByWorkId(workId);
                    if(aux2 != null) System.out.println(aux2);
                    int fieldNumber = InputChecker.verifyFieldNumber(aux2.size());
                    String fieldInfo = checkData(fieldNumber);
                    employeeControl.changeEmployeeFieldByWorkId(workId, fieldNumber, fieldInfo);
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
        if(choice == 5) return 1;
        else return 7;
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
                return InputChecker.verifyWorkId();
            case 8:
                return InputChecker.verifyId();
            default:
                return null;
        }
    }
}
