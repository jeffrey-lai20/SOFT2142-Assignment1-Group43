import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Transaction {
    private String dateTime;
    private ArrayList<Item> items;
    private boolean completed;
    private double totalAmount;
    private ArrayList<Integer> quantity;
    private String trans;
    public Transaction() {
        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        this.dateTime = formatter.format(currentDate);
        this.items = new ArrayList<>();
        this.quantity = new ArrayList<>();
        this.completed = false;
        this.totalAmount = 0.0;
    }

    public void addItem(Item i, Integer quantity) {
        this.items.add(i);
        this.quantity.add(quantity);
        for (int j = 0; j < quantity; j++) {
            this.totalAmount = this.totalAmount + i.getPrice();
        }
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

    public String printItems() {
        String finalItems ="";
        for (int i = 0; i < this.items.size(); i++) {
            Item item = this.items.get(i);
            finalItems += (item.getName() + "\t"
                            + this.quantity.get(i) + "\t\t\t"
                            + "$"+item.getPrice() + "\t\t"
                            + "$"+item.getPrice()*this.quantity.get(i) + "\t"
                            + "\n");
        }
        return finalItems;
    }

    public String getStatus() {
        if (this.completed) {
            return "Completed";
        } else {
            return "Cancelled";
        }
    }

    public void printTransaction(double inputtedCash,double change) {
        String newTrans = ("\n==============================================================\n"
                + "Transaction Date and Time - " + getDateAndTime() + "\n"
                +"-----------------------------------------------------------\n"
                + "Item Name\tQuantity\tPrice/ea\tTotal Price" + "\n"+
        this.printItems()+
        "-----------------------------------------------------------\n"
                + "Total Cost\t\t"+ this.totalAmount + "\n"
                + "Inputted cash\t"+ inputtedCash+ "\tChange\t" +change
                + "\nTransaction Status - " + this.getStatus() + "\n"+
                "==============================================================\n");
        System.out.print(newTrans);
        saveTransaction(newTrans);
    }
    private void saveTransaction(String trans){
        this.trans = trans;
    }
    public String getTrans(){
        return this.trans;
    }
    public List<Integer> getQuantity() {
        return quantity;
    }
    public void clearItems(){
        this.items.clear();
        this.quantity.clear();
        totalAmount=0;
    }
    // Just for testing // will delete later
    public static void main(String[] args) {
        Item airpods = new ItemImpl("Apple Airpods", 319.0, Item.TYPE.CHOCOLATES, 1, "A5");
        Transaction t1 = new Transaction();
        t1.addItem(airpods, 2);
        t1.complete();
        t1.printTransaction(10,10);
    }

}