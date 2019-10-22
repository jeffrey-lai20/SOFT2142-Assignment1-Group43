import java.util.ArrayList;

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

                System.out.print("Here are our items available: \n");

                System.out.print("\nDrinks - \n");
                for (Item i : drinks) {
                        System.out.print(i.getName()+": "+i.getQuantity()+"\n");
                }
                System.out.print("\nChocolates - \n");
                for (Item i : chocolates) {
                        System.out.print(i.getName()+": "+i.getQuantity()+"\n");
                }
                System.out.print("\nChips - \n");
                for (Item i : chips) {
                        System.out.print(i.getName()+": "+i.getQuantity()+"\n");
                }
                System.out.print("\nLollies - \n");
                for (Item i : lollies) {
                        System.out.print(i.getName()+": "+i.getQuantity()+"\n");
                }
                System.out.print("\n");
        }

        private boolean enterItemChecker(String input) {
                for(Item i :items) {
                    if (i.getName().equalsIgnoreCase(input)) {
                        return true;
                    }
                }
            System.out.println("Invalid input please try again.");
                return false;
        }

                // Checks if quantity entered is valid

        private void takeAwayItem(String item,int quantity){
            for(Item i : items){
                if(i.getName().equalsIgnoreCase(item)){
                    i.setQuantity(i.getQuantity()-quantity);
                }
            }
        }
        private boolean enterQuantityChecker(int quantity, String itemSelected) {
            for(Item i : items){
                if(i.getName().equalsIgnoreCase(itemSelected)){
                    if(i.getQuantity() < quantity){
                        System.out.println("Quantity requested exceeds stock quantity.Please try again.");
                        return false;
                    }
                    else if(quantity<=0){
                        System.out.println("quantity must be more than 1 and less than availability.Please try again.");
                        return false;
                    }
                    else{
                        return true;
                    }
                }
            }
            return false;
        }
        public void confirmationText(){
            System.out.print("Please choose the next action by entering the corresponding number:\n");
            System.out.print("  1.Proceed to checkout.\n");
            System.out.print("  2.Continue to shop.\n");
            System.out.print("  3.Cancel Transaction.\n");
        }
        public boolean confirmation(int quantitySelected, String itemSelected, int answer) {

            switch(answer){
                case 1 :
                    //calculate cost
                    CashSystem cs = new CashSystem();
                    cs.cashInput(cost);
                    return true;
                case 2:
                    takeAwayItem(itemSelected,quantitySelected);
                    buyingPage();
                    return true;
                case 3:
                    System.out.println("Transaction cancelled, have a good day!");
                    System.exit(0);
                default:
                    System.out.println("invalid input please try again.");
                    return false;
            }
        }

        public void buyingPage(){
            itemsAvaliable();

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
            }

            //takes in quantity and checks if quantity is correct.
            System.out.println("Enter quantity: ");
            if (input.hasNextLine()) {
                quantitySelected = Integer.parseInt(input.nextLine());
                while(!enterQuantityChecker(quantitySelected, itemSelected)){
                    quantitySelected = Integer.parseInt(input.nextLine());
                };
            }

            //Provide customer next action to take.
            if (quantitySelected == 1) {
                System.out.println("\nYou have selected one " + itemSelected);
            } else {
                System.out.println("\nYou have selected " + quantitySelected + " " + itemSelected + "s ");
            }
            confirmationText();
            if (input.hasNextLine()) {
                this.cart.add(itemSelected);
                this.cartQuantity.add(quantitySelected);
                int answer = Integer.parseInt(input.nextLine());
                confirmation(quantitySelected, itemSelected, answer);

            }
        }


        public ArrayList<String> getCart () {
                return cart;
        }

        public ArrayList<Integer> getCartQuantity() {
                return cartQuantity;
        }


}
