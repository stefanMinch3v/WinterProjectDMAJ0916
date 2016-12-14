package ModelLayer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Admin on 11/28/2016.
 */
public class Loan extends Order {
    private String startDate = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").format(Calendar.getInstance().getTime());
    private int periodOfTime;
    private boolean status;
    private ArrayList<Item> items = new ArrayList<>();

    public Loan(ArrayList<Item> items, String numberID, double price, Customer customer, int periodOfTime) {
        super(numberID, price, customer);
        this.periodOfTime = periodOfTime;
        this.items = items;
        status = true;
    }
    public String getStatus(){
        if(status) return "Not returned";
        else return "Returned";
    }
    public String getStartDate() {
        return startDate;
    }

    public int getPeriodOfTime() {
        return periodOfTime;
    }

    public void setPeriodOfTime(int periodOfTime) {
        this.periodOfTime = periodOfTime;
    }

    public boolean isReturned() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getNumberId() {
        return getNumberID();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public boolean updateFields(int fieldNumber, Object fieldInfo) {
        switch (fieldNumber) {
            case 1:
                setNumberID((String) fieldInfo);
                return true;
            case 2:
                setPrice((double) fieldInfo);
                return true;
            case 3:
                setCustomer((Customer) fieldInfo);
                return true;
            case 4:
                periodOfTime = (int) fieldInfo;
                return true;
            default:
                return false;
        }
    }
}
