import ControlLayer.Authentication;
import UILayer.AesEncrypter;

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
        AesEncrypter.setKey("EncryptingPassword123");

        Authentication p = new Authentication();
        p.login();


    }
}
