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

    public boolean addLoan(/*ArrayList<Item> items,*/String numberID, int quantity, double price, String customerCPR, int periodOfTime) {
        Customer customer = customerContainer.findCustomerByCpr(customerCPR);
        Loan loan = new Loan(/*items,*/ numberID, quantity, price, customer, periodOfTime);
        //loanContainer.addLoan(new Loan(numberID, quantity, price, customer, startDate, periodOfTime));
        return loanContainer.addLoan(loan);
    }

    public ArrayList<String> readLoan(String numberID) {
        return loanContainer.getLoanByNumberID(numberID);
    }

    public boolean updateLoan(String numberID, int fieldNumber, Object fieldInfo) {
        Loan loan = loanContainer.getLoanByID(numberID);
        return loan.updateFields(fieldNumber, fieldInfo);
    }
}
