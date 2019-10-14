import java.util.ArrayList;

public class Inventory {
    final static Integer MAX = 20;
    private ArrayList<Item> items;
    private Integer quantity;
    
    public Inventory() {
        this.items = new ArrayList<Item>(MAX);
        this.quantity = 0;
    }

    public void addItem(Item item) {
        if (this.quantity <= 20) {
            this.items.add(item);
            this.quantity++;
            System.out.println(item.getName() + " added successfully.");
        } else {
            System.out.println("Inventory Full. Cannot add a new item");
        }
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }
}