package UILayer;

import static UILayer.CustomerMenu.customerMenu;
import static UILayer.MenuText.*;


/**
 * Created by RaidenRabit on 23-Nov-16.
 */
public class MainMenuUI {
    public static void runMainLoop() {
        MenuText.write(MAIN_MENU);
        int choice;
        do {
            choice = Input.readInt();

            switch (choice) {
                case 1:
                    customerMenu();
                    break;
                case 2:
                   // emoployeeMenu();
                    break;
                case 3:
                  //  itemMenu();
                    break;
                case 4:
                //    contractorMenu();
                    break;
                case 5:
                    // exit program
                default:
                    System.out.println("Choice must be a value between 1 and 4.");
            }
        } while (choice != 5);
    }


}
