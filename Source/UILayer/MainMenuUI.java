package UILayer;

import static UILayer.MenuText.*;


/**
 * Created by RaidenRabit on 23-Nov-16.
 */
public class MainMenuUI {
    public static void runMainLoop() {
        MenuText.write(MAIN_MENU);
        CustomerMenu customerMenu = new CustomerMenu();
        EmployeeMenu employeeMenu = new EmployeeMenu();
        SaleManu saleManu = new SaleManu();
        LoanMenu loanMenu = new LoanMenu();
        int choice;
        do {
            choice = Input.readInt();

            switch (choice) {
                case 1:
                    choice = customerMenu.menu();
                    break;
                case 2:
                    choice = employeeMenu.menu();
                    break;
                case 3:
                    //  itemMenu();
                    break;
                case 4:
                    //    contractorMenu();
                    break;
                case 5:
                    choice = saleManu.menu();
                    break;
                case 6:
                    choice = loanMenu.menu();
                    break;
                case 7:
                    //exit
                    break;
                default:
                    System.out.println("Choice must be a value between 1 and 7.");
            }
        } while (choice != 7);
    }


}
