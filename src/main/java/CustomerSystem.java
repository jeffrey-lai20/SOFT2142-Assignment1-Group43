import java.util.*;

public class CustomerSystem {

        // Can type in product name or a unique code
        // Can select more than one item in one go.
        // Can cancel transaction before buying.
        private ArrayList<Item.TYPE> cart = new ArrayList<>();
        private ArrayList<Integer> cartQuantity = new ArrayList<>();
        private ArrayList<Item> items;

        CustomerSystem(ArrayList<Item> items) {
            this.items = items;
        }

        // Select item (availability), specify number of items
        public void itemsAvaliable() {

                // Sort each items into categories and print them
                ArrayList<Item> drinks = new ArrayList<Item>();
                ArrayList<Item> chocolates = new ArrayList<Item>();
                ArrayList<Item> chips = new ArrayList<Item>();
                ArrayList<Item> lollies = new ArrayList<Item>();

                for (Item i : items) {
                        if (i.getType()== Item.TYPE.DRINKS) {
                            drinks.add(i);
                        } else if (i.getType() == Item.TYPE.CHOCOLATES) {
                                chocolates.add(i);
                        } else if (i.getType() == Item.TYPE.CHIPS) {
                                chips.add(i);
                        } else if (i.getType() == Item.TYPE.LOLLIES) {
                                lollies.add(i);
                        }
                }

                System.out.println("Here are our items available: \n");

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

        public void enterItem(String input) {
                // Type in product name or unique code
                // Do for while loop until user EOF

                String itemSelected = input;
                // Checks if item entered is valid
                int itemExists = 0;
                while (itemExists == 0) {
                        if (itemSelected == null) {
                                System.out.println("Invalid input.");
                                System.exit(1);
                        }
                        if (itemSelected.equalsIgnoreCase("Cancel")) {
                                break;
                                //Stop the transaction, either back to start or end program.
                        }

                        for (Item i : items) {
                                if (itemSelected.equalsIgnoreCase(i.getName())) {
                                        itemExists = 1;
                                        break;
                                }
                        }

                        if (itemExists != 1) {
                                System.out.println("Invalid Item. Please enter again.");
                                break;
                        }
                }

                // Checks if quantity entered is valid



        }

        public void enterQuantity (int quantity, String itemSelected) {
            int quantitySelected = quantity;
            int amountValid = 0;
            while (amountValid == 0) {
                if (quantitySelected <= 0) {
                    System.out.println("Invalid quantity input.");
                } else {
                    for (Item i : items) {
                        if (itemSelected.equalsIgnoreCase(i.getName())) {
                            if (i.getQuantity() >= quantitySelected) {
                                System.out.println("Quantity requested exceeds stock quantity.");
                                amountValid = 1;
                                break;
                            }
                        }
                    }
                    if (amountValid != 1) {
                        System.out.println("Invalid item.");
                        break;
                    }
                }
            }
        }


        public void confirmation(int quantitySelected, String itemSelected, String answer) {

                if (answer.equalsIgnoreCase("y")) {
                        //Deduct money and items from stock.
                    if (quantitySelected == 1) {
                        System.out.println("You have selected " + itemSelected);
                    } else {
                        System.out.println("You have selected " + quantitySelected + " " + itemSelected + "s ");
                    }

                    // Add to cart
                    // Need to do this for specific selections when specific items have been determined in other code.
                    if (itemSelected != null) {
                        switch (itemSelected) {
                            case ("Chips"):
                                cart.add(Item.TYPE.CHIPS);      //Adds item to cart.
                                cartQuantity.add(quantitySelected);     //Adds quantity to list, same index as cart.
                                break;
                            case ("Drinks"):
                                cart.add(Item.TYPE.DRINKS);
                                cartQuantity.add(quantitySelected);
                                break;
                            case("Chocolates"):
                                cart.add(Item.TYPE.CHOCOLATES);
                                cartQuantity.add(quantitySelected);
                                break;
                            case("Lollies"):
                                cart.add(Item.TYPE.LOLLIES);
                                cartQuantity.add(quantitySelected);
                                break;
                            default:
                                System.out.println("Invalid selection.");
                        }
                    }

                } else if (answer.equalsIgnoreCase("n")) {
                        //Cancel
                        cart.clear();
                        cartQuantity.clear();
                } else {
                        System.out.println("Invalid input.");
                }
        }

        public ArrayList<Item.TYPE> getCart () {
                return cart;
        }

        public ArrayList<Integer> getCartQuantity() {
                return cartQuantity;
        }


}
