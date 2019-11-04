import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventoryTest {
    private final PrintStream systemOut = System.out;
    private ByteArrayOutputStream testOut;
    private Inventory i;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @After
    public void restoreSystemInputOutput() {
        // System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void newInventoryTest() {
        this.i = new Inventory();
        
    }
}