package UILayer;

import UILayer.ErrorCode;

/**
 * Created by EU on 2016-11-26.
 */
public class ErrorWriter {
        public static void print(ErrorCode code) {
            String errMsg = "Operation failed! ";
            errMsg += code.getErrorMessage();
            if (code.getErrorMessage() == "" || code.getErrorMessage() == null) {
                errMsg += "Unknown error.";
            }
            System.out.println(errMsg);
        }
}
