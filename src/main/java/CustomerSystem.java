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
                        if (i.getType() == Item.TYPE.DRINKS) {
                                drinks.add(i);
                        } else if (i.getType() == Item.TYPE.CHOCOLATES) {
                                chocolates.add(i);
                        } else if (i.getType() == Item.TYPE.CHIPS) {
                                chips.add(i);
                        } else if (i.getType() == Item.TYPE.LOLLIES) {
                                lollies.add(i);
                        }
                }

                System.out.println("Items Avaliable: ");

                System.out.println("Drinks - ");
                for (Item i : drinks) {
                        System.out.println(i.getName()+": "+i.getQuantity());
                }
                System.out.println();

                System.out.println("Chocolates - ");
                for (Item i : chocolates) {
                        System.out.println(i.getName()+": "+i.getQuantity());
                }
                System.out.println();

                System.out.println("Chips - ");
                for (Item i : chips) {
                        System.out.println(i.getName()+": "+i.getQuantity());
                }
                System.out.println();

                System.out.println("Lollies - ");
                for (Item i : lollies) {
                        System.out.println(i.getName()+": "+i.getQuantity());
                }
                System.out.println();
        }

        private void enterItem(ArrayList<Item> items) {
                // Type in product name or unique code
                // Do for while loop until user EOF
                Scanner input = new Scanner(System.in);

                String itemSelected = null;
                int quantitySelected = 0;

                // Checks if item entered is valid
                int itemExists = 0;
                while (itemExists == 0) {
                        System.out.println("Enter Item: ");
                        itemSelected = input.nextLine();

                        for (Item i : items) {
                                if (itemSelected.equalsIgnoreCase(i.getName())) {
                                        itemExists = 1;
                                        break;
                                }
                        }

                        if (itemExists != 1) {
                                System.out.println("Invalid Item. Please enter again.");
                        }
                }

                // Checks if quantity entered is valid
                int amountValid = 0;
                while (amountValid == 0) {
                        System.out.println("Enter quantity: ");
                        quantitySelected = input.nextInt();

                        for (Item i : items) {
                                if (itemSelected.equalsIgnoreCase(i.getName())) {
                                        if (i.getQuantity() >= quantitySelected) {
                                                amountValid = 1;
                                                break;
                                        }
                                }
                        }

                }

                if (quantitySelected == 1) {
                        System.out.println("You have selected " + itemSelected);
                } else {
                        System.out.println("You have selected " + quantitySelected + " " + itemSelected + "s ");
                }

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
