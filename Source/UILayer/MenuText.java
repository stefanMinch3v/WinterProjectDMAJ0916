package UILayer;

/**
 * Created by EU on 2016-11-27.
 */
public enum MenuText {
    MAIN_MENU("***MAIN MENU***\n* 1)Customer Menu *\n* 2)Customer Menu *\n* 3)Customer Menu *\n* 4)Customer Menu *\n* 5) Exit Program *\n************"),
    CUSTOMER_MENU("***CUSTOMER MENU***\n* 1)Create Customer *\n* 2)Read Customer *\n* 3)Update Customer *\n* 4)Delete Customer *\n* 5)Previous Menu *\n* 6)Exit Program *"),
    EMPLOYEE_MENU("***EMPLOYEE MENU***\n* 1)Create Employee *\n* 2)Read Employee *\n* 3)Edit Employee *\n* 4)Delete Employee *\n* 5)Previous Menu *\n* 6)Exit Program *");
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
