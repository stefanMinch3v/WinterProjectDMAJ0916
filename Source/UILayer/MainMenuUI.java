package UILayer;

import ControlLayer.Authentication;
import ControlLayer.Brexit;

import static UILayer.MenuText.MAIN_MENU;


/**
 * Created by RaidenRabit on 23-Nov-16.
 */
public class MainMenuUI {
    public static void runMainLoop() {
        Authentication authentication = new Authentication();
        CustomerMenu customerMenu = new CustomerMenu();
        EmployeeMenu employeeMenu = new EmployeeMenu();
        ContractorMenu contractorMenu = new ContractorMenu();
        ItemMenu itemMenu = new ItemMenu();
        SaleMenu saleMenu = new SaleMenu();
        LoanMenu loanMenu = new LoanMenu();
        Authentication p = new Authentication();
        Brexit brexit = new Brexit();


        int choice;
        do {
            MenuText.write(MAIN_MENU);
            choice = Input.readInt();

            switch (choice) {
                case 1:
                    choice = customerMenu.menu();
                    break;
                case 2:
                    if (authentication.adminLogin())
                        choice = employeeMenu.menu();
                    break;
                case 3:
                    choice = itemMenu.menu();
                    break;
                case 4:
                    choice = contractorMenu.menu();
                    break;
                case 5:
                    choice = saleMenu.menu();
                    break;
                case 6:
                    choice = loanMenu.menu();
                    break;
                case 7:
                    brexit.exit();
                    break;
                case 8:
                    p.login();
                    break;
                default:
                    System.out.println("Choice must be a value between 1 and 7.");
            }
        } while (choice != 7);
    }


}
