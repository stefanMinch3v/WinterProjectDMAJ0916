package UILayer;

/**
 * Created by EU on 2016-11-27.
 */
public enum MenuText {
    SUCCESS("Operation finished with success."),
    FAILURE("Operation failed."),
    MAIN_MENU("***MAIN MENU***\n* 1)Customer Menu *\n* 2)Employee Menu *\n* 3)Item Menu *\n* 4)Contractor Menu *\n* 5) Sale menu *\n* 6) Leasing menu*\n* 7) Exit Program *\n* 8)Logout *************"),
    CUSTOMER_MENU("***CUSTOMER MENU***\n* 1)Create Customer *\n* 2)Read Customer *\n* 3)Update Customer *\n* 4)Delete Customer *\n* 5)Previous Menu *\n* 6)Exit Program *"),
    EMPLOYEE_MENU("***EMPLOYEE MENU***\n* 1)Create Employee *\n* 2)Read Employee *\n* 3)Edit Employee *\n* 4)Delete Employee *\n* 5)Previous Menu *\n* 6)Exit Program *"),
    SALE_MENU("***SALE MENU***\n* 1)Create Sale *\n* 2)Read Sale *\n* 3)Edit Sale *\n* 4)Previous Menu *\n* 5)Exit Program *"),
    LOAN_MENU("***LEASING MENU***\n* 1)Create Leasing *\n* 2)Read Leasing *\n* 3)Edit Leasing *\n* 4)Retrieve Leasing *\n* 5)Previous Menu *\n* 6)Exit Program *"),
    CONTRACTOR_MENU("***CONTRACTOR MENU***\n* 1)Create Contractor *\n* 2)Read Contractor *\n* 3)Update Contractor *\n* 4)Delete Contractor *\n* 5)Previous Menu *\n* 6)Exit Program"),
    ITEM_MENU("***ITEM MENU***\n* 1)Create Item *\n* 2)Read Item *\n* 3)Edit Item *\n* 4)Delete Menu *\n* 5)Previous menu* *\n* 6)Exit program");
    private String errorMessage;

    MenuText(String errorMessage) {
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
