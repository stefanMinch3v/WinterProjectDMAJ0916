package UILayer;

import ControlLayer.Brexit;
import ControlLayer.EmployeeControl;

import java.util.ArrayList;

import static UILayer.ErrorCode.NO_SUCH_EMPLOYEE;
import static UILayer.MenuText.EMPLOYEE_MENU;
import static UILayer.MenuText.SUCCESS;

/**
 * Created by EU on 2016-12-01.
 */
public class EmployeeMenu {
    public int menu() {
        EmployeeControl employeeControl = new EmployeeControl();
        Brexit brexit = new Brexit();

        int choice;

        do {
            MenuText.write(EMPLOYEE_MENU);
            choice = Input.readInt();

            switch (choice) {
                case 1: // create

                    if (employeeControl.addEmployee(InputChecker.verifyName(), InputChecker.verifyAddress(), InputChecker.verifyEmail(), InputChecker.verifyPhone(), InputChecker.verifyCity(), InputChecker.verifyId(1), InputChecker.verifyWorkId(1)))
                        MenuText.write(SUCCESS);
                    else
                        ErrorCode.print(NO_SUCH_EMPLOYEE);
                    break;
                case 2: // read
                    ArrayList<String> aux = employeeControl.getEmployeeByWorkId(InputChecker.verifyWorkId(2));
                    if (aux!=null)
                        for(String au:aux) {
                        System.out.println(au);
                    }
                    else ErrorCode.print(NO_SUCH_EMPLOYEE);
                    break;
                case 3: // update
                    String workId = InputChecker.verifyWorkId(2);
                    ArrayList<String> aux2 = employeeControl.getEmployeeByWorkId(workId);
                    if (aux2!=null) for(String au:aux2) {
                        System.out.println(au);
                    }
                    else {
                        ErrorCode.print(NO_SUCH_EMPLOYEE);
                        break;
                    }
                    int fieldNumber = InputChecker.verifyFieldNumber(aux2.size());
                    String fieldInfo = checkData(fieldNumber);
                    if (employeeControl.changeEmployeeFieldByWorkId(workId, fieldNumber, fieldInfo))
                        MenuText.write(SUCCESS);
                    break;
                case 4: // delete
                    if (employeeControl.deleteEmployee(InputChecker.verifyWorkId(3))) MenuText.write(SUCCESS);
                    else ErrorCode.print(NO_SUCH_EMPLOYEE);
                    break;
                case 5:
                    //go back
                    break;
                case 6:

                    break;
                default:
                    System.out.println("Choice must be a value between 1 and 6.");
            }
        } while (choice != 5 && choice != 6);
        brexit.exit();
        return choice == 6 ? 7 : 1;
    }

    public String checkData(int fieldNumber) {
        switch (fieldNumber) {
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
