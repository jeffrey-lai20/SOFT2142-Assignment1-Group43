import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ItemImplTest {
    @Test
    public void mainTest(){
        ItemImpl testItem = new ItemImpl("Water",100.0, Item.TYPE.DRINKS,10,"A1");
        String originalString = ("A1 - Water - Quantity: 10 - Price: $100.0\n");
        assertEquals(originalString,testItem.toString());
        testItem.setCode("B3");
        testItem.setName("Godiva");
        testItem.setPrice(20.0);
        testItem.setType(Item.TYPE.CHOCOLATES);
        testItem.setQuantity(5);
        assertEquals(Item.TYPE.CHOCOLATES,testItem.getType());
        assertNotEquals(Item.TYPE.DRINKS,testItem.getType());

        String testOutCome = ("B3 - Godiva - Quantity: 5 - Price: $20.0\n");
        assertEquals(testOutCome,testItem.toString());
        assertNotEquals(originalString,testItem.toString());
    }
}
