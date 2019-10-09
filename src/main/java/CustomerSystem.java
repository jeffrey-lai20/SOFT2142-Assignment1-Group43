import java.util.*;
import java.io.*;

public class CustomerSystem {

    // Select item ( availability), specify number of items
    // Can type in product name or a unique code
    // Can select more than one item in one go.
    // Can cancel transaction before buying.

    public static void main(String[] args) {

        // Shows items available and number of items available
        System.out.println("Items Avaliable: ");


        // Type in product name or unique code
            // Do for while loop until user EOF
        System.out.println("Select Item: ");

        // Confirmation
        System.out.println("To confirm, items selected are: ");

        // Continue with transaction or cancel
        System.out.println("Continue with transaction? (Y/N)");
            // If yes, take out money and minus the stock available
            // If no, cancel the transaction
    }


}
