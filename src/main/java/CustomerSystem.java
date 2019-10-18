import java.util.*;
import java.io.*;

public class CustomerSystem {

        // Can type in product name or a unique code
        // Can select more than one item in one go.
        // Can cancel transaction before buying.

        // Select item ( availability), specify number of items
        private void itemsAvaliable(ArrayList<Item> items) {

                // Sort each items into categories and print them
                ArrayList<Item> drinks = new ArrayList<Item>();
                ArrayList<Item> chocolates = new ArrayList<Item>();
                ArrayList<Item> chips = new ArrayList<Item>();
                ArrayList<Item> lollies = new ArrayList<Item>();

                for (Item i : items) {
                        if (i.getType() == DRINKS) {
                                drinks.add(i);
                        } else if (i.getType() == CHOCOLATES) {
                                chocolates.add(i);
                        } else if (i.getType() == CHIPS) {
                                chips.add(i);
                        } else if (i.getType() == LOLLIES) {
                                lollies.add(i);
                        }
                }

                System.out.println("Items Avaliable: ");

                System.out.println("Drinks - ");
                for (Item i : drinks) {
                        System.out.println(i.getName());
                }

                System.out.println("Chocolates - ");
                for (Item i : chocolates) {
                        System.out.println(i.getName());
                }

                System.out.println("Chips - ");
                for (Item i : chips) {
                        System.out.println(i.getName());
                }

                System.out.println("Lollies - ");
                for (Item i : lollies) {
                        System.out.println(i.getName());
                }

        }

        private void enterItem() {
                // Type in product name or unique code
                // Do for while loop until user EOF
                Scanner input = new Scanner(System.in);
                System.out.println("Enter Item: ");

                String itemSelected = input.nextLine();

                System.out.println("Enter amount: ");
                int amountSelected = input.nextInt();


                System.out.println("You have selected " + item_selected);

                // Add to cart
                // Decline --> does not match any product description
        }

        private void confirmation() {
                // Confirmation
                System.out.println("To confirm, items selected are: ");

                // Continue with transaction or cancel
                System.out.println("Continue with transaction? (Y/N)");
                // If yes, take out money and minus the stock available
                // If no, cancel the transaction
        }


}
