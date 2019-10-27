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
                while(inputPassword.equals(password) != true) {
                    System.out.println("Incorrect Password. Please try again");
                    inputPassword = input.nextLine();
                }
                if (inputPassword.equals(password)) {
                    this.loggedIn = true;
                    System.out.println("\nLogin Successfully\n");
                }
            } else {
                System.out.println("Invalid Username\nShutting Down...");
            }
        }
    }

    public boolean staffLoggedIn() {
        return this.loggedIn;
    }

    public void showMenuOptions() {
        System.out.println("Select a task :");
        System.out.println("1 : See Inventory");
        System.out.println("2 : Fill Inventory");
        System.out.println("3 : See Sales");
        System.out.println("4 : Exit / Logout\n");
    }

    public void showMenu(Inventory inventory) {
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
            System.out.println("Logout Successfull\n");
        }
    }
}
