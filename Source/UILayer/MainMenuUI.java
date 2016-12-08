package UILayer;

import static UILayer.MenuText.*;


/**
 * Created by RaidenRabit on 23-Nov-16.
 */
public class MainMenuUI {
    public static void runMainLoop() {

        CustomerMenu customerMenu = new CustomerMenu();
        EmployeeMenu employeeMenu = new EmployeeMenu();
        ContractorMenu contractorMenu = new ContractorMenu();
        SaleMenu saleMenu = new SaleMenu();
        //LoanMenu loanMenu = new LoanMenu();
        int choice;
        do {
            MenuText.write(MAIN_MENU);
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
                     choice = contractorMenu.menu();
                    break;
                case 5:
                    choice = saleMenu.menu();
                    break;
                case 6:
               //     choice = loanMenu.menu();
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
