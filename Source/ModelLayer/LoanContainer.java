package ModelLayer;

import java.util.ArrayList;

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

}
