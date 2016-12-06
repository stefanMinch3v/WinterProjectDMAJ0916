package ModelLayer;

/**
 * Created by RedJohn on 23-Nov-16.
 */
public class Contractor extends Person {
    private String CVR;
    public Contractor(String name, String address, String email, String phone, String city, String CVR) {
        super(name, address, email, phone, city);
        this.CVR = CVR;
    }

    public String getCVR() {
        return CVR;
    }

    public void setCVR(String CVR) {
        this.CVR = CVR;
    }
    public boolean updateFields(int fieldNumber, Object fieldInfo) {
        switch (fieldNumber) {
            case 1:
                setName((String)fieldInfo);
                return true;
            case 2:
                setAddress((String)fieldInfo);
                return true;
            case 3:
                setEmail((String)fieldInfo);
                return true;
            case 4:
                setCity((String)fieldInfo);
                return true;
            case 5:
                setPhone((String)fieldInfo);
                return true;
            case 6:
                CVR = (String)fieldInfo;
                return true;
            default:
                return false;
        }
    }
}
