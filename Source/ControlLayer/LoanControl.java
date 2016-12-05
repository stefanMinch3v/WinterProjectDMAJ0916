package ControlLayer;

import ModelLayer.*;

import java.text.DateFormat;
import java.util.ArrayList;

/**
 * Created by Admin on 12/1/2016.
 */
public class LoanControl {
    private LoanContainer loanContainer;
    private CustomerContainer customerContainer;

    public LoanControl() {
        loanContainer = LoanContainer.getInstance();
        customerContainer = CustomerContainer.getInstance();
    }

    public void addLoan(String numberID, int quantity, double price, String customerCPR, DateFormat startDate, int periodOfTime) {
        //Loan loan = new Loan(numberID, quantity, price,customer, startDate, periodOfTime);
        Customer customer = customerContainer.findCustomerByCpr(customerCPR);
        loanContainer.addLoan(new Loan(numberID, quantity, price, customer, startDate, periodOfTime));
    }

    public ArrayList<String> readLoan(String numberID) {
        return loanContainer.getLoanByNumberID(numberID);
    }

    public boolean updateLoan(String numberID, int fieldNumber, Object fieldInfo) {
        Loan loan = loanContainer.getLoanByID(numberID);
        return loan.updateFields(fieldNumber, fieldInfo);
    }
}
