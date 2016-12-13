package ControlLayer;

import ModelLayer.LoginContainer;
import UILayer.Input;
import UILayer.MainMenuUI;


/**
 * Created by Luke on 01/12/2016.
 */
public class Authentication {
    private LoginContainer loginContainer;


    public Authentication() {
        loginContainer = LoginContainer.getInstance();
    }

    public void login() {
        String admin;
        String user;
        String pass;
        System.out.println("Log in:");
        System.out.println("Insert username: ");
        user = Input.readString();
        if (!loginContainer.getMapList().containsKey(user)) {
            System.out.println("You entered wrong username.");
            login();
        } else {

            System.out.println("Username accepted");
            System.out.println("Insert password: ");

        }

        pass = Input.readString();
        if (!loginContainer.getMapList().get(user).equals(pass)) {
            System.out.println("You entered wrong password");
            login();
        } else

            System.out.println("You are logged in");

        MainMenuUI c = new MainMenuUI();
        Brexit brexit = new Brexit();
        brexit.load(); // load the files right before going in the first menu
        c.runMainLoop();


    }

    public boolean adminLogin() {
        String pw;
        String admin = "admin";
        System.out.println("Please input administrator password in order to continue: ");
        pw = Input.readString();
        if (loginContainer.getMapList().get(admin).equals(pw)) {
            System.out.println("Authentication successful");
            return true;
        } else {
            System.out.println("You have entered wrong password. ");
            return false;
        }
    }


}










