package ModelLayer;

/**
 * Created by RedJohn on 23-Nov-16.
 */
public class Customer extends Person {
    private String cpr;

    public Customer(String cpr, String name, String address, String email, String phone, String city) {
        super(name, address, email, phone, city);
        this.cpr = cpr;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public boolean setField(int fieldNumber, Object fieldInfo) {
        switch (fieldNumber) {
            case 1:
                setCpr((String) fieldInfo);
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
