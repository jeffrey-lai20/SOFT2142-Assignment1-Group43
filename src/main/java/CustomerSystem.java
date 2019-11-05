import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerSystem {

        private Transaction transaction = new Transaction();
        private ArrayList<Item> items;
        private List<Integer> totalQuantity = new ArrayList<>() ;
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
                        System.out.print(i.toString());
                }
                System.out.print("\nChocolates - \n");
                for (Item i : chocolates) {
                        System.out.print(i.toString());
                }
                System.out.print("\nChips - \n");
                for (Item i : chips) {
                        System.out.print(i.toString());
                }
                System.out.print("\nLollies - \n");
                for (Item i : lollies) {
                        System.out.print(i.toString());
                }
                System.out.print("\n");
        }

        public boolean enterItemChecker(String input) {
                for(Item i :items) {
                    if (i.getName().equalsIgnoreCase(input) || i.getCode().equalsIgnoreCase(input)) {
                        return true;
                    } else if (input.equalsIgnoreCase("Cancel")) {
                        System.out.print("Transaction cancelled, have a good day!\n\n");
                        transaction = new Transaction();
                        VendingMachine.firstPage();
                        return false;
                    }
                }
                System.out.print("Invalid input please try again.\n");
                return false;
        }

        public Item convertCodeToName(String code) {
            Item item = null;
            for(Item i :items) {
                if (i.getCode().equalsIgnoreCase(code)) {
                    return i;
                }
            }
            return item;
        }

//        public void takeAwayItem(String item, int quantity){
//            for(Item i : items){
//                if(i.getName().equalsIgnoreCase(item) || i.getCode().equalsIgnoreCase(item)){
//                    i.setQuantity(i.getQuantity()-quantity);
//                }
//            }
//        }

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
        public boolean confirmation(int quantitySelected, String itemSelected, int answer, ArrayList<Transaction> transactions) {
            switch(answer){
                case 1 :
                    CashSystem cs = new CashSystem();
                    if(cs.cashInput(priceCalculation())){
                        this.transaction.complete();
                        this.transaction.setChange(cs.getChange());
                        this.transaction.setInputtedCash(cs.getInputtedCash());
                        this.transaction.printTransaction();
                        transactions.add(this.transaction);
                        int i,j;
                        for (i=0;i<items.size();i++) {
                            for (j=0;j<transaction.getItems().size();j++) {
                                if (items.get(i).getName().equals(transaction.getItems().get(j).getName())) {
                                    items.get(i).setQuantity(items.get(i).getQuantity() - transaction.getQuantity().get(j));
                                }
                            }
                        }
                        // this.clearCart();
                    }
                    else {
                        return false;
                    }
                    this.transaction = new Transaction();
                    return true;

                case 2:
//                    takeAwayItem(itemSelected,quantitySelected);
                    buyingPage(transactions);
                    return true;

                case 3:
                    System.out.print("Transaction cancelled. Have a good day!\n");
                    transactions.add(this.transaction);
                    transaction = new Transaction();
                    return false;

                case 4:
                    viewCart();
                    confirmationText();
                    Scanner input = new Scanner(System.in);
                    int number = Integer.parseInt(input.nextLine());
                    confirmation(0, null, number, transactions);
                    return true;

                default:
                    System.out.print("Invalid input please try again.\n");
                    return false;
            }
        }

        //the loop responsible for select item,quantity and confirmation
        public void buyingPage(ArrayList<Transaction> transactions){
            itemsAvailable();
            Scanner input = new Scanner(System.in);
            String itemSelected = null;
            Item item = null;
            int quantitySelected = 0;
            //takes in item and checks if input is correct
            System.out.print("Please make a selection.\n");
            System.out.print("Enter Item:\n");
            if (input.hasNextLine()) {
                itemSelected = input.nextLine(); //Testing scanner input, not working.
                while(!enterItemChecker(itemSelected) && input.hasNextLine()){
                    itemSelected = input.nextLine();
                }
                if (itemSelected.length() == 2) {
                    item = convertCodeToName(itemSelected);
                    itemSelected = item.getName();
                }
            }

            //takes in quantity and checks if quantity is correct.
            System.out.print("Enter quantity:\n");
            while (input.hasNextLine()) {
                try {
                    String in = input.nextLine();
                    if (in.equalsIgnoreCase("Cancel")) {
                        System.out.println("Transaction cancelled. Have a good day!");
                        transactions.add(this.transaction);
                        this.transaction = new Transaction();
                        System.exit(0);
                        break;
                    }
                    quantitySelected = Integer.parseInt(in);
                    while(!enterQuantityChecker(quantitySelected, itemSelected)){
                        in = input.nextLine();
                        quantitySelected = Integer.parseInt(in);
                    }
                    totalQuantity.add(quantitySelected);
                    break;
                } catch(Exception e) {
                    System.out.println("Invalid input. Please try again.");
                }

            }

            //Provide customer next action to take.
            if (quantitySelected == 1) {
                System.out.println("\nYou have selected one " + itemSelected);
            } else if (quantitySelected != 0) {
                System.out.println("\nYou have selected " + quantitySelected + " " + itemSelected + "s ");
            } else {
                input.close();
//                buyingPage(transactions);
                return; 
            }
            confirmationText();
            for (Item i :items) {
                if (i.getName().equalsIgnoreCase(itemSelected)) {
                    transaction.addItem(i, quantitySelected);
                }
            }
            while (input.hasNextLine()) {
                try {
                    int answer = Integer.parseInt(input.nextLine());
                    if (answer < 5 && answer > 0) {
                        confirmation(quantitySelected, itemSelected, answer, transactions);
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
            input.close();
        }

        public double priceCalculation(){
            int counter = 0;
            cost = 0;
            for(Item i : transaction.getItems())    {
                cost+= i.getPrice()*transaction.getQuantity().get(counter);
                counter+=1;
            }
            return cost;
        }

        public void viewCart() {
            System.out.print("\nCart: \n");
            int i;
            for (i=0;i<transaction.getQuantity().size();i++) {
                System.out.println(transaction.getItems().get(i).getName() + ": " + transaction.getQuantity().get(i)+
                        " = $"+transaction.getItems().get(i).getPrice()*transaction.getQuantity().get(i));
            }
            System.out.print("Total: $"+transaction.totalAmount() + "\n");
            System.out.print("\n");
        }

        public void clearCart(){
            transaction.clearItems();
        }

}
