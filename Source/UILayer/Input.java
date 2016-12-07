package UILayer;
import java.util.Scanner;
import UILayer.ErrorCode;

/**
 * Created by EU on 2016-11-25.
 */
public abstract class Input {
    private static String inputString;

    public static String readString() {
        inputString = null; // clearing it before reading from keyboard
        Scanner scan = new Scanner(System.in);

        inputString = scan.nextLine();

        return inputString;
    }

    public static int readInt() {
        inputString = null; // clearing it before reading from keyboard
        Scanner scan = new Scanner(System.in);

        inputString = scan.nextLine();

        if( !inputString.matches("[0-9]+") )// if whatever is read is not mainly made out of numbers
        {
            System.out.println( ErrorCode.WRONG_INPUT_INTEGER );
            return 0;
        }

        return Integer.parseInt( inputString );
    }
}
