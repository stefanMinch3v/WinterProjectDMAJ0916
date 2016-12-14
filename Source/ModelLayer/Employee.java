package ModelLayer;

/**
 * Created by RedJohn on 23-Nov-16.
 */
public class Employee extends Person {
    private String workId;
    private String cpr;

    public Employee(String name, String address, String email, String phone, String city, String cpr, String workId) {
        super(name, address, email, phone, city);
        this.workId = workId;
        this.cpr = cpr;
    }

    public boolean setField(int fieldNumber, Object fieldInfo) {
        switch (fieldNumber) {
            case 1:
                setName((String) fieldInfo);
                return true;
            case 2:
                setAddress((String) fieldInfo);
                return true;
            case 3:
                setEmail((String) fieldInfo);
                return true;
            case 4:
                setPhone((String) fieldInfo);
                return true;
            case 5:
                setCity((String) fieldInfo);
                return true;
            case 7:
                workId = ((String) fieldInfo);
                return true;
            case 8:
                cpr = ((String) fieldInfo);
                return true;
            default:
                return false;
        }
    }

    public String getWorkId() {
        return workId;
    }

    public String getCpr() {
        return cpr;
    }

}