import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    final static Integer MAX = 150;
    private ArrayList<Item> items;
    private Integer quantity;
    private File configFile;
    private BufferedReader reader;
    
    public Inventory() {
        this.items = new ArrayList<Item>(MAX);
        this.quantity = 0;
        try {
            this.configFile = new File(System.getProperty("user.dir") + "/src/main/java/inventory-data.txt");
            this.reader = new BufferedReader(new FileReader(this.configFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] productInfo = line.split(",", 5);
                Item i = new ItemImpl(productInfo[0], Double.valueOf(productInfo[1]), Item.TYPE.valueOf(productInfo[2]), Integer.valueOf(productInfo[3]), productInfo[4]);
                this.items.add(i);
            }
        } catch (Exception e) {
            System.out.println("Inventory configuration file missing or corrupted");
        }

    }

    public void fill() {
        if (this.getQuantity() < MAX) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter Item Name : ");
            Item item = null;
            String searchName = input.nextLine();
            for (Item it : this.items) {
                if (it.getName().equals(searchName)) {
                    item = it;
                }
            }
            System.out.println("Selected Item - " + item.getName() + " Price - " + item.getPrice() + " Type - " + item.getType() + " Quantity - " + item.getQuantity());
            System.out.println("Enter Fill Quantity : ");
            String quantityFill = input.nextLine();
            if (item.getQuantity() < 10) {
                // fill item
                for (int i = 0; i<Integer.valueOf(quantityFill); i++) {
                    item.setQuantity(item.getQuantity()+1);
                    if(item.getQuantity() == 10) {
                        Integer quantityAdded = i+1;
                        System.out.println("Item Capacity reached. Added " + quantityAdded + " items\n");
                        break;
                    }
                }
                System.out.println("Successfully Added " + quantityFill + " items.\n");
            } else {
                System.out.println("Item " + item.getName() + " is full");
            }
            System.out.println("Inventory Size = " + this.getQuantity() + "/" + MAX + ".\n");
        } else {
            System.out.println("Inventory Full. Cannot add/fill a new item.\n");
        }
    }

    public Integer getQuantity() {
        Integer totalItems = 0;
        for (Item i : items) {
            totalItems = totalItems + i.getQuantity();
        }
        return totalItems;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public void printInventory() {
        for (Item i : items) {
            System.out.println(i.getName() + " - " + i.getQuantity());
        }
        System.out.println("\nTotal Items = " + this.getQuantity() + "\n");
    }
}