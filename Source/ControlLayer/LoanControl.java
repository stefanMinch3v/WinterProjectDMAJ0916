package ControlLayer;

import ModelLayer.*;

import java.text.DateFormat;
import java.util.ArrayList;

/**
 * Created by Admin on 12/1/2016.
 */
public class LoanControl {
    private LoanContainer loanContainer;

    public LoanControl() {
        loanContainer = LoanContainer.getInstance();
    }

    public void addLoan(String numberID, int quantity, double price, Customer customer, DateFormat startDate, int periodOfTime) {
        //Loan loan = new Loan(numberID, quantity, price,customer, startDate, periodOfTime);
        loanContainer.addLoan(new Loan(numberID, quantity, price, customer, startDate, periodOfTime));
    }

    public ArrayList<Item> readLoan(String numberID) {
        Loan l = loanContainer.getLoanByID(numberID);
        return l.getItems();
    }

    //update loan TODO
}
