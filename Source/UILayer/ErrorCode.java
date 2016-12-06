package UILayer;
/**
 * Created by RaidenRabit on 2016-11-25.
 */
public enum ErrorCode {
    // when you want to introduce new error code, put it before this one and put " , " instead of " ; ", only the last one should have " ; "
    WRONG_CPR_INPUT("CPR/CVR must be 10 digits long and must not contain letters."),
    ID_ALREADY_EXISTS("workId/CPR/CVR already exists in the system"),
    WRONG_NAME_INPUT("NAME must consist of at least 4 characters"),
    WRONG_ADDRESS_INPUT("ADDRESS must contain both the street and house number and must consist of at least 3 characters"),
    WRONG_EMAIL_INPUT("EMAIL must contain \"@\" and \".\" and must consist of at least 5 characters."),
    WRONG_PHONE_LENGTH_INPUT("PHONE must be between 5 and 15 numbers"),
    WRONG_PHONE_INPUT("PHONE must not contain and letters"),
    WRONG_CITY_INPUT("CITY must consist of at least 3 characters"),
    WRONG_INPUT_INTEGER("Please introduce a number, not a character"),
    WRONG_WORKID_INPUT("WORKID must be 6 digits long and must not contain letters."),
    NO_SUCH_CUSTOMER("There is no Customer with this CPR");


    private String errorMessage;

    ErrorCode (String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public static void print(ErrorCode code) {
        String Msg = "";
        Msg += code.getErrorMessage();
        if (code.getErrorMessage() == "" || code.getErrorMessage() == null) {
            Msg += "Unknown error.";
        }
        System.out.println(Msg);
    }
}
