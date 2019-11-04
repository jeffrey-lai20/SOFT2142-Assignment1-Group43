import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.io.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventoryTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }


    @Test
    public void basicTest() {
        Inventory inventory = new Inventory();
        assertEquals(145, inventory.getQuantity().intValue());
    }

    @Test
    public void fillTest() {
        String expected = ("Water stock already full.\n"
                + "Soft Drink stock already full.\n"
                + "Juice added 5\n"
                + "M&M stock already full.\n"
                + "Bounty stock already full.\n"
                + "Mars stock already full.\n"
                + "Snickers stock already full.\n"
                + "Original stock already full.\n"
                + "Chicken stock already full.\n"
                + "BBQ stock already full.\n"
                + "Sweet Chilly stock already full.\n"
                + "Sour Worms stock already full.\n"
                + "Jellybeans stock already full.\n"
                + "Little Bears stock already full.\n"
                + "Party Mix stock already full.\n\n"
        );
        Inventory inventory = new Inventory();
        inventory.fill();
        assertEquals(expected, testOut.toString());
        assertEquals(150, inventory.getQuantity().intValue());
    }

    @Test
    public void getItemsTest() {
        Inventory inventory = new Inventory();
        ArrayList<Item> items = new ArrayList<>();
        File configFile;
        BufferedReader reader;
        try {
            configFile = new File(System.getProperty("user.dir") + "/src/main/java/inventory-data.txt");
            reader = new BufferedReader(new FileReader(configFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] productInfo = line.split(",", 5);
                Item i = new ItemImpl(productInfo[0], Double.valueOf(productInfo[1]), Item.TYPE.valueOf(productInfo[2]), Integer.valueOf(productInfo[3]), productInfo[4]);
                items.add(i);
            }
        } catch (Exception e) {
            System.out.println("Inventory configuration file missing or corrupted");
        }
        for (Item i : items) {
            if (i.getQuantity() < 10) {
                Integer fillQuantity = 10-i.getQuantity();
                System.out.print(i.getName() + " added " + fillQuantity + "\n");
                i.setQuantity(10);
            } else {
                System.out.print(i.getName() + " stock already full.\n");
            }
        }
        inventory.fill();
        inventory.getItems();
        assertEquals(inventory.getItems().toString(), items.toString());
    }

    @Test
    public void printInventoryTest() {
        String expected = ("Water - 10\n" +
                "Soft Drink - 10\n" +
                "Juice - 5\n" +
                "M&M - 10\n" +
                "Bounty - 10\n" +
                "Mars - 10\n" +
                "Snickers - 10\n" +
                "Original - 10\n" +
                "Chicken - 10\n" +
                "BBQ - 10\n" +
                "Sweet Chilly - 10\n" +
                "Sour Worms - 10\n" +
                "Jellybeans - 10\n" +
                "Little Bears - 10\n" +
                "Party Mix - 10\n" +
                "\n" +
                "Total Items = 145\n\n"
        );
        Inventory inventory = new Inventory();
        inventory.printInventory();
        assertEquals(expected, testOut.toString());

    }
    // @Test
    // public void loginFail() {
    //     String input = "staff" + System.getProperty("line.separator")
    //             + "@staff" + System.getProperty("line.separator")
    //             + "" + System.getProperty("line.separator");
    //     InputStream savedStandardInputStream = System.in;
    //     System.setIn(new ByteArrayInputStream(input.getBytes()));
    //     StaffSystem s = new StaffSystem();
    //     s.loginScreen();
    //     assertEquals(false, s.staffLoggedIn());
    //     System.setIn(savedStandardInputStream);
    // }
    // aws test


    @After
    public void restoreSystemInputOutput() {
        // System.setIn(systemIn);
        System.setOut(systemOut);
    }
}
