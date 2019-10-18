import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Inventory {
    final static Integer MAX = 40;
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
                String[] productInfo = line.split(",", 3);
                Item i = new ItemImpl(productInfo[0], Double.valueOf(productInfo[1]), Item.TYPE.valueOf(productInfo[2]), Double.valueOf(productInfo[3])); 
                this.items.add(i);
            }
        } catch (Exception e) {
            System.out.println("Inventory configuration file missing or corrupted");
        }

    }

    public void addItem(Item item) {
        if (this.quantity < MAX) {
            this.items.add(item);
            this.quantity++;
            System.out.println(item.getName() + " added successfully.");
            System.out.println("Inventory Size = " + this.quantity + "/" + MAX);
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