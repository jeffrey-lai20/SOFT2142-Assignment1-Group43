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
        customerSystem = new CustomerSystem();
        cashSystem = new CashSystem();
        staffSystem = new StaffSystem();
        vendingMachine = new VendingMachine();

        customerSystem.itemsAvaliable(inventory.getItems());
        System.out.println("Please make a selection.");
        customerSystem.enterItem(inventory.getItems());

        // Item mountFranklin = new ItemImpl("Mount Franklin", 2.5, Item.TYPE.DRINKS);
        // i.addItem(mountFranklin);
        // System.out.println("Inventory size = " + i.getQuantity());
    }
}