import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Transaction {
    private String dateTime;
    private ArrayList<Item> items;
    private boolean completed;
    private double totalAmount;

    public Transaction() {
        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        this.dateTime = formatter.format(currentDate);
        this.items = new ArrayList<>();
        this.completed = false;
        this.totalAmount = 0.0;
    }

    public void addItem(Item i) {
        this.items.add(i);
        this.totalAmount = this.totalAmount + i.getPrice();
    }

    public void complete() {
        this.completed = true;
    }

    public boolean completed() {
        return this.completed;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public double totalAmount() {
        return this.totalAmount;
    }

    public String getDateAndTime() {
        return this.dateTime;
    }

    public void printItems() {
        for (Item i : this.items) {
            System.out.print(i.getName() + "\t"
                            + "1\t\t"
                            + i.getPrice() + "\t\t"
                            + i.getPrice() + "\t"
                            + "\n");
        }
    }

    public String getStatus() {
        if (this.completed) {
            return "Completed";
        } else {
            return "Cancelled";
        }
    }

    public void printTransaction() {
        System.out.print("\n==============================================================\n"
                        + "Transaction Date and Time - " + getDateAndTime() + "\n"
                        + "Item Name\tQuantity\tPrice/ea\tTotal Price" + "\n"
                        );
        this.printItems();
        System.out.print("\nTotal Amount - " + this.totalAmount + "\n"
                        + "Transaction Status - " + this.getStatus() + "\n");
        System.out.print("==============================================================\n");

    }

    // Just for testing // will delete later
    public static void main(String[] args) {
        Item airpods = new ItemImpl("Apple Airpods", 319.0, Item.TYPE.CHOCOLATES, 1, "A5");
        Transaction t1 = new Transaction();
        t1.addItem(airpods);
        t1.complete();
        t1.printTransaction();
    }
}