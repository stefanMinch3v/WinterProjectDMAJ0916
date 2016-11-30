package UILayer;

/**
 * Created by EU on 2016-11-27.
 */
public enum MenuText {
    MAIN_MENU("***MAIN MENU***\n* 1)Customer Menu *\n* 2) Exit Program *\n************"),
    CUSTOMER_MENU("***CUSTOMER MENU***\n* 1)Create Customer *\n* 2)Read Customer *\n* 3)Update Customer *\n* 4)Delete Customer *\n* 5)Previous Menu *\n* 6)Exit Program *"),
    UPDATE_CUSTOMER_MENU("***UPDATE CUSTOMER MENU***\n* 1)Update CPR *\n* 2)Update Name *\n* 3)Update Address *\n* 4)Update Email *\n* 5)Update Phone *\n* 6)Update City *\n* 7)Previous Menu *\n*************************");

    private String errorMessage;

    MenuText (String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMenuMessage() {
        return errorMessage;
    }

    public static void write(MenuText code) {
        String mnuMsg = "";
        mnuMsg += code.getMenuMessage();
        if (code.getMenuMessage() == "" || code.getMenuMessage() == null) {
            mnuMsg += "Unknown error.";
        }
        System.out.println(mnuMsg);
    }
}
