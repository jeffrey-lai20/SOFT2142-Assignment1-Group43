import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        Inventory i = new Inventory();
        System.out.println("Inventory size = " + i.getQuantity());
        Item mountFranklin = new ItemImpl("Mount Franklin", 2.5, Item.TYPE.DRINKS);
        i.addItem(mountFranklin);
        System.out.println("Inventory size = " + i.getQuantity());
    }
}