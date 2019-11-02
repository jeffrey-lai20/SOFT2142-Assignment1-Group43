import java.util.ArrayList;
import java.util.Scanner;

public class CustomerSystem {

        // Can type in product name or a unique code
        // Can select more than one item in one go.
        // Can cancel transaction before buying.
        private ArrayList<String> cart = new ArrayList<>();
        private ArrayList<Integer> cartQuantity = new ArrayList<>();
        private ArrayList<Item> items;
        private double cost = 0;
        CustomerSystem(ArrayList<Item> items) {
            this.items = items;
        }

        // Select item (availability), specify number of items
        public void itemsAvailable() {

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

                System.out.print("Here are our items available: \n");

                System.out.print("\nDrinks - \n");
                for (Item i : drinks) {
                        System.out.print(i.getCode() + " - " + i.getName()+": "+i.getQuantity()+"\n");
                }
                System.out.print("\nChocolates - \n");
                for (Item i : chocolates) {
                        System.out.print(i.getCode() + " - " + i.getName()+": "+i.getQuantity()+"\n");
                }
                System.out.print("\nChips - \n");
                for (Item i : chips) {
                        System.out.print(i.getCode() + " - " + i.getName()+": "+i.getQuantity()+"\n");
                }
                System.out.print("\nLollies - \n");
                for (Item i : lollies) {
                        System.out.print(i.getCode() + " - " + i.getName()+": "+i.getQuantity()+"\n");
                }
                System.out.print("\n");
        }

        public boolean enterItemChecker(String input) {
                for(Item i :items) {
                    if (i.getName().equalsIgnoreCase(input) || i.getCode().equalsIgnoreCase(input)) {
                        return true;
                    } else if (input.equalsIgnoreCase("Cancel")) {
                        System.out.print("Transaction cancelled, have a good day!\n");
                        return false;
                    }
                }
                System.out.print("Invalid input please try again.\n");
                return false;
        }

        public String convertCodeToName(String code) {
            String name = null;
            for(Item i :items) {
                if (i.getCode().equalsIgnoreCase(code)) {
                    name = i.getName();
                }
            }
            return name;
        }

        public void takeAwayItem(String item, int quantity){
            for(Item i : items){
                if(i.getName().equalsIgnoreCase(item) || i.getCode().equalsIgnoreCase(item)){
                    i.setQuantity(i.getQuantity()-quantity);
                }
            }
        }

        // Checks if quantity entered is valid
        public boolean enterQuantityChecker(int quantity, String itemSelected) {
            for(Item i : items){
                if(i.getName().equalsIgnoreCase(itemSelected) || i.getCode().equalsIgnoreCase(itemSelected)){
                    if(i.getQuantity() < quantity){
                        System.out.print("Quantity requested exceeds stock quantity. Please try again.\n");
                        return false;
                    } else if(quantity<=0){
                        System.out.print("Quantity must be at least 1 and less than availability. Please try again.\n");
                        return false;
                    } else {
                        return true;
                    }
                }
            }
            return false;
        }

        //prints confirmation menu
        public void confirmationText(){
            System.out.print("Please choose the next action by entering the corresponding number:\n");
            System.out.print("  1. Proceed to checkout.\n");
            System.out.print("  2. Continue to shop.\n");
            System.out.print("  3. Cancel Transaction.\n");
            System.out.print("  4. View Cart.\n");
        }

        //checks user input for confirmation stage
        public boolean confirmation(int quantitySelected, String itemSelected, int answer) {
            switch(answer){
                case 1 :
                    //calculate cost
                    CashSystem cs = new CashSystem();
                    cs.cashInput(10);
                    ArrayList<String> emptyCart1 = new ArrayList<>();
                    ArrayList<Integer> emptyCartQuantity1 = new ArrayList<>();
                    cart = emptyCart1;
                    cartQuantity = emptyCartQuantity1;
                    return true;

                case 2:
                    takeAwayItem(itemSelected,quantitySelected);
                    buyingPage();
                    return true;

                case 3:
                    System.out.print("Transaction cancelled. Have a good day!\n");
                    ArrayList<String> emptyCart2 = new ArrayList<>();
                    ArrayList<Integer> emptyCartQuantity2 = new ArrayList<>();
                    cart = emptyCart2;
                    cartQuantity = emptyCartQuantity2;
                    return false;

                case 4:
                    viewCart(cart,cartQuantity);
                    confirmationText();
                    Scanner input = new Scanner(System.in);
                    int number = Integer.parseInt(input.nextLine());
                    confirmation(0, null, number);
                    return true;

                default:
                    System.out.print("Invalid input please try again.\n");
                    return false;
            }
        }

        //the loop responsible for select item,quantity and confirmation
        public void buyingPage(){
            itemsAvailable();

            Scanner input = new Scanner(System.in);
            String itemSelected = null;
            int quantitySelected =0;

            //takes in item and checks if input is correct
            System.out.println("Please make a selection.");
            System.out.println("Enter Item: ");
            if (input.hasNextLine()) {
                itemSelected = input.nextLine(); //Testing scanner input, not working.
                while(!enterItemChecker(itemSelected)){
                    itemSelected = input.nextLine();
                }
                if (itemSelected.length() == 2) {
                    itemSelected = convertCodeToName(itemSelected);
                }
            }

            //takes in quantity and checks if quantity is correct.
            System.out.println("Enter quantity: ");
            if (input.hasNextLine()) {
                try {
                    String in = input.nextLine();
                    if (in.equalsIgnoreCase("Cancel")) {
                        System.out.println("Transaction cancelled. Have a good day!");
                        System.exit(0);
                    }
                    quantitySelected = Integer.parseInt(in);
                    while(!enterQuantityChecker(quantitySelected, itemSelected)){
                        in = input.nextLine();
                        quantitySelected = Integer.parseInt(in);
                    }
                } catch(Exception e) {
                    System.out.println("Invalid input. Please try again.");
                }

            }

            //Provide customer next action to take.
            if (quantitySelected == 1) {
                System.out.println("\nYou have selected one " + itemSelected);
            } else if (quantitySelected != 0){
                System.out.println("\nYou have selected " + quantitySelected + " " + itemSelected + "s ");
            } else {
                buyingPage();
                return;
            }
            confirmationText();
            this.cart.add(itemSelected);
            this.cartQuantity.add(quantitySelected);
            while (input.hasNextLine()) {
                try {
                    int answer = Integer.parseInt(input.nextLine());
                    if (answer < 5 && answer > 0) {
                        confirmation(quantitySelected, itemSelected, answer);
                        break;
                    } else {
                        System.out.println("Invalid input. Please try again.\n");
                        confirmationText();
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again.\n");
                    confirmationText();
                }
            }
        }

        // to do get calculate price for transaction
        public double priceCalculation(){
            for(String i:cart){
            }
            return 0;
        }

        public void viewCart(ArrayList<String> cart, ArrayList<Integer> cartQuantity) {
            System.out.println("Cart: ");
            int i;
            for (i=0;i<cart.size();i++) {
                System.out.println(cart.get(i) + ": " + cartQuantity.get(i));
            }
            System.out.println();
        }

        public ArrayList<String> getCart () {
                return cart;
        }

        public ArrayList<Integer> getCartQuantity() {
                return cartQuantity;
        }
}
