package ModelLayer;
/**
 * Created by RedJohn on 23-Nov-16.
 */
public class Employee extends Person {
    private String workID;
    private String CPR;
    private Person person;

    public Employee(String name, String address, String email, String phone, String city, String workID, String CPR) {
       super(name, address, email, phone, city);
        this.workID = workID;
        this.CPR = CPR;
    }

    public String getWorkID() {
        return workID;
    }

    public void setWorkID(String workID) {
        this.workID = workID;
    }

    public String getCPR() {
        return CPR;
    }

    public void setCPR(String CPR) {
        this.CPR = CPR;
    }


}
