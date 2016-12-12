import UILayer.AesEncrypter;
import UILayer.MainMenuUI;

/**
 * Created by RaidenRabit on 2016-11-25.
 */

/*public class Main {

    public static void main(String[] args) {
        MainMenuUI p = new MainMenuUI();
        p.runMainLoop();
    }
}*/

public class Main {

    public static void main(String[] args) {

     //   Authentication p = new Authentication();
      //  p.adminLogin();

        AesEncrypter.setKey("EncryptingPassword123");
       MainMenuUI mainMenuUI = new MainMenuUI();
       mainMenuUI.runMainLoop();

    }
}
