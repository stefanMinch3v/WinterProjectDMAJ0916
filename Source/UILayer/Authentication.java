package UILayer;

import ModelLayer.*;

/**
 * Created by Luke on 01/12/2016.
 */
public class Authentication {
private LoginContainer loginContainer;

    public Authentication() {
        loginContainer = new LoginContainer();
    }

    public void login(){
        String user;
        String pass;
        System.out.println("Log in:");
        System.out.println("Insert username: ");
        user = Input.readString();
        if(!loginContainer.getMapList().containsKey(user)) {
            System.out.println("You entered wrong username.");
            login();
        }
        else {

            System.out.println("Username accepted");
            System.out.println("Insert password: ");

        }

            pass = Input.readString();
            if(!loginContainer.getMapList().get(user).equals(pass)){
                System.out.println("You entered wrong password");
                login();
            }
            else

        System.out.println("You are logged in");

//                MainMenuUI c = new MainMenuUI();
//                c.runMainLoop();


        }








    }

