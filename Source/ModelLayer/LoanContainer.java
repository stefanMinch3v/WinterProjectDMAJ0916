package ModelLayer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Admin on 11/28/2016.
 */
public class LoanContainer {
    private ArrayList<Loan> loan;
    private static LoanContainer instance;

    private LoanContainer() {
        loan = new ArrayList<>();
    }

    public static LoanContainer getInstance() {
        if(instance==null){
            instance = new LoanContainer();
        }
        return instance;
    }

    public void addLoan(Loan loan1) {
        loan.add(loan1);
    }

    public ArrayList<Loan> getLoan() {
        return loan;
    }

    public void removeLoan(String numberID) {
        for (Loan l: loan) {
            if (l.getNumberID().equals(numberID)) {
                loan.remove(numberID);
                System.out.println("Removed");
            }
        }
    }
    //Search for a specific loan by his unique numberID
    public Loan getLoanByID(String numberID) {
        //boolean found = false;
        Loan foundLoan = null;

        Iterator<Loan> it = loan.iterator();
        while(it.hasNext()) {//!found
            Loan recordLoan = it.next();
            if(recordLoan.getNumberID().equals(numberID)) {
                //found = true;
                foundLoan = recordLoan;
            }
        }
        return foundLoan;
    }
}
