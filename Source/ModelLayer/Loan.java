package ModelLayer;

import java.text.DateFormat;
import java.util.ArrayList;

/**
 * Created by Admin on 11/28/2016.
 */
public class Loan extends Order{
    private DateFormat startDate;
    private int periodOfTime;
    private boolean status;
    private ArrayList<Item> items;

    public Loan(String numberID, int quantity, double price,Customer customer, DateFormat startDate, int periodOfTime) {
        super(numberID, quantity, price, customer);
        this.startDate = startDate;
        this.periodOfTime = periodOfTime;
        items = new ArrayList<>();
        status = false;
    }

    public DateFormat getStartDate() {
        return startDate;
    }

    public void setStartDate(DateFormat startDate) {
        this.startDate = startDate;
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

    public String getNumberID() {
        return getNumberID();
    }
}
