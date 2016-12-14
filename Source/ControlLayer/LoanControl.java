package ControlLayer;

import ModelLayer.*;

import java.util.*;

/**
 * Created by Admin on 12/1/2016.
 */
public class LoanControl {
    private LoanContainer loanContainer;
    private CustomerContainer customerContainer;
    private ItemContainer itemContainer;

    public LoanControl() {
        loanContainer = LoanContainer.getInstance();
        itemContainer = ItemContainer.getInstance();
        customerContainer = CustomerContainer.getInstance();
    }

    public boolean addLoan(ArrayList<Item> items, String numberID, double price, Customer customer, int periodOfTime) {
        Loan loan = new Loan(items, numberID, price, customer, periodOfTime);
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

    public boolean getAvailableItems(String place, HashMap<String, Integer> items, String numberId, String customerCPR, int periodOfTime) {
        ArrayList<Item> orderItems = new ArrayList<>();
        // Get a set of the entries
        Set set = items.entrySet();

        // Get an iterator
        Iterator i = set.iterator();

        // Display elements
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            //System.out.print(me.getKey() + ": ");
            //System.out.println(me.getValue());
            String barcode = (String) me.getKey();
            int quantity = (Integer) me.getValue();
            orderItems.add(itemContainer.getOrderItem(place, barcode, quantity));
        }
        double price = 0;
        for (Item item : orderItems) {
            price += item.getQuantityAtTimber() * item.getRetailPrice();
        }
        Customer customer = customerContainer.findCustomerByCpr(customerCPR);
        addLoan(orderItems, numberId, price, customer, periodOfTime);
        return true;
    }

    public boolean retrieveLoan(String numberID)
    {
        return loanContainer.retrieveLoanByID(numberID);
    }
}
