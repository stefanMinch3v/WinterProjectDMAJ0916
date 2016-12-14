package ModelLayer;

import java.util.HashMap;

/**
 * Created by Luke on 01/12/2016.
 */
public class LoginContainer {
    private HashMap<String, String> mapList;
    private static LoginContainer instance;

    private LoginContainer() {
        mapList = new HashMap<String, String>();
        mapList.put("username", "nopass");
        mapList.put("admin", "adminpass");
    }


    public static LoginContainer getInstance() {
        if (instance == null) {
            instance = new LoginContainer();
        }
        return instance;
    }

    public void addUser(Login user) {
        mapList.put(user.getUsername(), user.getPassword());
    }

    public HashMap<String, String> getMapList() {
        return mapList;
    }
}