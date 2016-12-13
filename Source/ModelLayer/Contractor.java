package ModelLayer;

/**
 * Created by RedJohn on 23-Nov-16.
 */
public class Contractor extends Person {
    private String cvr;

    public Contractor(String name, String address, String email, String phone, String city, String cvr) {
        super(name, address, email, phone, city);
        this.cvr = cvr;
    }

    public String getCvr() {
        return cvr;
    }

    public void setCvr(String cvr) {
        this.cvr = cvr;
    }

    public boolean setField(int fieldNumber, Object fieldInfo) {
        switch (fieldNumber) {
            case 1:
                setCvr((String) fieldInfo);
                return true;
            case 2:
                setName((String) fieldInfo);
                return true;
            case 3:
                setAddress((String) fieldInfo);
                return true;
            case 4:
                setEmail((String) fieldInfo);
                return true;
            case 5:
                setCity((String) fieldInfo);
                return true;
            case 6:
                setPhone((String) fieldInfo);
                return true;

            default:
                return false;
        }
    }
}
