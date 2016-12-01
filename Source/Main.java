import UILayer.Authentication;

/**
 * Created by RaidenRabit on 2016-11-25.
 */

/*public class Main {

    public static void main(String[] args) {
        MainMenuUI p = new MainMenuUI();
        p.runMainLoop();
    }
}*/
import ModelLayer.LoginContainer;

public class Main {
    private LoginContainer loginContainer;

    public static void main(String[] args) {

        Authentication p = new Authentication();
        p.login();


    }
}
