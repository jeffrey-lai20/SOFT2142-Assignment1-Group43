import java.util.ArrayList;
import java.util.Scanner;

public class StaffSystem {
    final private String username = "staff";
    final private String password = "st@ff";
    private boolean loggedIn = false;

    public StaffSystem() {}

    public void loginScreen() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your username");
        if (input.hasNextLine()) {
            String inputUsername = input.nextLine();
            if (inputUsername.equals(username)) {
                System.out.println("Enter your password");
                String inputPassword = input.nextLine();
                while(this.loggedIn == false && (inputPassword != null)) {
                    if (inputPassword.equals(password)) {
                        this.loggedIn = true;
                        System.out.println("\nLogin Successfully\n");
                    } else {
                        System.out.println("Incorrect Password. Please try again");
                        this.loggedIn = false;
                        inputPassword = input.nextLine();
                    }
                }
            } else {
                System.out.println("Invalid Username\n");
            }
        }
    }

    public boolean staffLoggedIn() {
        return this.loggedIn;
    }

    public void showMenuOptions() {
        System.out.print("Select a task :\n");
        System.out.print("1 : See Inventory\n");
        System.out.print("2 : Fill Inventory\n");
        System.out.print("3 : See Sales\n");
        System.out.print("4 : Exit / Logout\n\n");
    }

    public static void showSalesOptions() {
        System.out.print("\nSelect an option :\n"
                        + "1 : See All Transactions\n"
                        + "2 : See Completed Transactions\n"
                        + "3 : See Cancelled Transactions\n"
                        + "4 : Go Back\n\n");
    }

    public static void showSales(ArrayList<Transaction> transactions) {
        Scanner input = new Scanner(System.in);
        showSalesOptions();
        String salesInput = input.nextLine();
        while (salesInput.equals("4") != true) {
            switch (salesInput) {
                case "1":
                    //show all transactions
                    for (Transaction t : transactions) {
                        t.printTransaction();
                    }
                    showSalesOptions();
                    break;
                case "2":
                    //show all successfull transactions
                    for (Transaction t : transactions) {
                        if (t.getStatus().equals("Completed")) {
                            t.printTransaction();
                        }
                    }
                    showSalesOptions();
                    break;
                case "3":
                    // show all cancelled transactions
                    for (Transaction t : transactions) {
                        if (t.getStatus().equals("Cancelled")) {
                            t.printTransaction();
                        }
                    }
                    showSalesOptions();
                default:
                    System.out.println("Invalid Output");
                    showSalesOptions();
                    break;
            }
            salesInput = input.nextLine();
        }
        
    }

    public void showMenu(Inventory inventory, ArrayList<Transaction> transactions) {
        Scanner input = new Scanner(System.in);
        showMenuOptions();
        String staffInput = input.nextLine();
        while (staffInput.equals("4") != true) {
            // showMenuOptions();
            switch (staffInput) {
                case "1":
                    inventory.printInventory();
                    showMenuOptions();
                    break;
                case "2":
                    // fill inventory
                    inventory.fill();
                    showMenuOptions();
                    break;
                case "3":
                    // see sales
                    showSales(transactions);
                    showMenuOptions();
                    break;
                default:
                    System.out.println("Invalid Output");
                    showMenuOptions();
                    break;
            }
            staffInput = input.nextLine();

        }
        if(staffInput.equals("4")) {
            loggedIn = !loggedIn;
            System.out.println("Logout Successfully\n");
            Driver.firstPage();
        }
    }
}
