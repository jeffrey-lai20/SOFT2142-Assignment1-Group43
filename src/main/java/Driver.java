import java.util.Scanner;

public class Driver {

    private static Inventory inventory;
    private static CustomerSystem customerSystem;
    private static CashSystem cashSystem;
    private static StaffSystem staffSystem;
    private static VendingMachine vendingMachine;

    public static void main(String[] args) {
        // System.out.println(System.getProperty("user.dir"));
        System.out.println("Welcome to Group 43's Vending Machine.");
        inventory = new Inventory();
        customerSystem = new CustomerSystem(inventory.getItems());
        cashSystem = new CashSystem();
        staffSystem = new StaffSystem();
        vendingMachine = new VendingMachine();
        String itemSelected = null;
        int quantitySelected = 0;

        System.out.println("Please select your role : \n1 : Customer\n2 : Staff");
        Scanner input = new Scanner(System.in);
        if (input.hasNextLine()) {
            String userInput = input.nextLine();
            while (userInput.equals("2")) {
                // Show Customer Login
                staffSystem.loginScreen();
                if (staffSystem.staffLoggedIn()) {
                    staffSystem.showMenu(inventory);
                }
                System.out.println("Please select your role : \n1 : Customer\n2 : Staff");
                userInput = input.nextLine();
            }
        }
        
        
        customerSystem.itemsAvaliable();
        System.out.println("Please make a selection.");
        System.out.println("Enter Item: ");
//        while (input.hasNext()) {
//            System.out.println(input.next());
//        }

//        input.nextLine();
        if (input.hasNextLine()) {
            itemSelected = input.nextLine(); //Testing scanner input, not working.
            customerSystem.enterItem(itemSelected);

                //Need to check if "Cancel is input"
        }

        System.out.println("Enter quantity: ");
        if (input.hasNextInt()) {
            quantitySelected = input.nextInt();
            customerSystem.enterQuantity(quantitySelected, itemSelected);
        }

        if (input.hasNextLine()) {
            // Confirmation
            System.out.println("To confirm, items selected are: ");
            for (int i = 0; i < customerSystem.getCart().size(); i++) {
                System.out.print("Item: " + customerSystem.getCart().get(i) + "/t Quantity: ");
                System.out.println(customerSystem.getCartQuantity().get(i));
            }
            // Continue with transaction or cancel
            System.out.println("Continue with transaction? (Y/N)");
            // If yes, take out money and minus the stock available
            // If no, cancel the transaction
            String buffer = input.nextLine();
            String answer = input.nextLine();
            customerSystem.confirmation(quantitySelected, itemSelected, answer);
        }

        input.close();


        // Item mountFranklin = new ItemImpl("Mount Franklin", 2.5, Item.TYPE.DRINKS);
        // i.addItem(mountFranklin);
        // System.out.println("Inventory size = " + i.getQuantity());
    }
}