package ModelLayer;
import java.lang.reflect.Array;
import java.util.*;
/**
 * Created by Luke on 01/12/2016.
 */
public class LoginContainer {
   public HashMap<String, String> mapList;

    public LoginContainer(){
        mapList = new HashMap<String, String>();
        mapList.put("Dement", "Kokot");
        mapList.put("Dement1", "Kokot1");

    }
    public void addUser(Login user){
     mapList.put(user.getUsername(),user.getPassword());
    }
    public HashMap<String, String> getMapList() {
        return mapList;
    }
}