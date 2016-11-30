package ModelLayer;

import java.text.DateFormat;

/**
 * Created by Admin on 11/28/2016.
 */
public class Loan extends Order{
    private DateFormat startDate;
    private int periodOfTime;

    public Loan(String numberID, int quantity, DateFormat startDate, int periodOfTime) {
        super(numberID, quantity);
        this.startDate = startDate;
        this.periodOfTime = periodOfTime;
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

}
