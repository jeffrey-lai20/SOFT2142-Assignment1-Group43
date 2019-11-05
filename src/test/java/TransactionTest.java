import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransactionTest {

    private final PrintStream systemOut = System.out;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @After
    public void restoreStreams() {
        System.setOut(systemOut);
    }

    @Test
    public void TranTest(){
        Transaction tt = new Transaction();
        //Testing add item function and all getter methods
        assertEquals(tt.getItems().size(),0);
        String cancel = "Cancelled";
        assertEquals(tt.getStatus(),cancel);
        tt.complete();
        assertEquals(tt.getStatus(),"Completed");
        Item testItem = new ItemImpl("name",10, Item.TYPE.DRINKS,10,"D1");
        tt.addItem(testItem,10);
        assertEquals(tt.getItems().size(),1);
        assertNotEquals(tt.getQuantity().size(),2);

        //Testing print receipt function
        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String dateTime = formatter.format(currentDate);
        String testReceipt= "\n" +
                "==============================================================\n" +
                "Transaction Date and Time - "+dateTime+"\n" +
                "-----------------------------------------------------------\n" +
                "Item Name\tQuantity\tPrice/ea\tTotal Price\n" +
                "name\t10\t\t$10.0\t\t$100.0\t\n" +
                "-----------------------------------------------------------\n" +
                "Total Cost\t\t\t\t\t$100.0\n" +
                "Inputted cash\t0.0\tChange\t0.0\n" +
                "Transaction Status - Completed\n" +
                "==============================================================\n";
        tt.printTransaction();
        assertEquals(testReceipt,testOut.toString());
        testOut.reset();
        //testing setter function
        tt.setChange(100.0);
        tt.setInputtedCash(200.0);
        String testReceipt2= "\n" +
                "==============================================================\n" +
                "Transaction Date and Time - "+dateTime+"\n" +
                "-----------------------------------------------------------\n" +
                "Item Name\tQuantity\tPrice/ea\tTotal Price\n" +
                "name\t10\t\t$10.0\t\t$100.0\t\n" +
                "-----------------------------------------------------------\n" +
                "Total Cost\t\t\t\t\t$100.0\n" +
                "Inputted cash\t200.0\tChange\t100.0\n" +
                "Transaction Status - Completed\n" +
                "==============================================================\n";
        tt.printTransaction();
        assertEquals(testReceipt2,testOut.toString());
        //Testing clear function
        tt.clearItems();
        assertNotEquals(tt.getQuantity().size(),1);
        assertNotEquals(tt.getItems().size(),1);

        assertEquals(tt.getQuantity().size(),0);
        assertEquals(tt.getItems().size(),0);
        assertEquals(tt.totalAmount(),0,0);




    }


}
