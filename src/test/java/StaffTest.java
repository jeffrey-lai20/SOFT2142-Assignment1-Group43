import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StaffTest {
    private final PrintStream systemOut = System.out;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }
    
    
    @Test
    public void loginSuccess() {
        String input = "staff" + System.getProperty("line.separator")
                + "st@ff" + System.getProperty("line.separator");
        InputStream savedStandardInputStream = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        StaffSystem s = new StaffSystem();
        s.loginScreen();
        assertEquals(true, s.staffLoggedIn());
        System.setIn(savedStandardInputStream);
    }

    @Test
    public void staffMenuOptionsTest() {
        String expected = ("Select a task :\n"
                            + "1 : See Inventory\n"
                            + "2 : Fill Inventory\n"
                            + "3 : See Sales\n"
                            + "4 : Exit / Logout\n\n"
                            );
        StaffSystem s = new StaffSystem();
        s.showMenuOptions();
        assertEquals(expected, testOut.toString());
    }

    @Test
    public void showSalesOptionsTestAll() {
        ArrayList<Transaction> transactions = new ArrayList<>();
        Inventory inv = new Inventory();
        ItemImpl i = (ItemImpl) inv.getItems().get(0);
        Transaction t = new Transaction();
        t.addItem(i, 2);
        t.setInputtedCash(5.0);
        t.setChange(0.0);
        t.complete();
        Transaction t2 = new Transaction();
        t2.addItem(i, 5);
        t2.setInputtedCash(0.0);
        t2.setChange(0.0);
        transactions.add(t);
        transactions.add(t2);

        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String dateTime = formatter.format(currentDate);
        String expected = ("\nSelect an option :\n"
        + "1 : See All Transactions\n"
        + "2 : See Completed Transactions\n"
        + "3 : See Cancelled Transactions\n"
        + "4 : Go Back\n\n"
        + "\n==============================================================\n" 
        + "Transaction Date and Time - "+dateTime+"\n" 
        + "-----------------------------------------------------------\n" 
        + "Item Name\tQuantity\tPrice/ea\tTotal Price\n" 
        + "Water\t2\t\t$2.5\t\t$5.0\t\n" 
        + "-----------------------------------------------------------\n" 
        + "Total Cost\t\t\t\t\t$5.0\n" 
        + "Inputted cash\t5.0\tChange\t0.0\n" 
        + "Transaction Status - Completed\n" 
        + "==============================================================\n"
        + "\n==============================================================\n" 
        + "Transaction Date and Time - "+dateTime+"\n" 
        + "-----------------------------------------------------------\n" 
        + "Item Name\tQuantity\tPrice/ea\tTotal Price\n" 
        + "Water\t5\t\t$2.5\t\t$12.5\t\n" 
        + "-----------------------------------------------------------\n" 
        + "Total Cost\t\t\t\t\t$12.5\n" 
        + "Inputted cash\t0.0\tChange\t0.0\n" 
        + "Transaction Status - Cancelled\n" 
        + "==============================================================\n"
        + "\nSelect an option :\n"
        + "1 : See All Transactions\n"
        + "2 : See Completed Transactions\n"
        + "3 : See Cancelled Transactions\n"
        + "4 : Go Back\n\n");

        String input = "1" + System.getProperty("line.separator")
                + "4" + System.getProperty("line.separator");
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        StaffSystem s = new StaffSystem();
        s.showSales(transactions);
        System.setIn(in);
        assertEquals(expected, testOut.toString());
    }

    @Test
    public void showSalesOptionsTestCompleted() {
        ArrayList<Transaction> transactions = new ArrayList<>();
        Inventory inv = new Inventory();
        ItemImpl i = (ItemImpl) inv.getItems().get(0);
        Transaction t = new Transaction();
        t.addItem(i, 2);
        t.setInputtedCash(5.0);
        t.setChange(0.0);
        t.complete();
        transactions.add(t);

        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String dateTime = formatter.format(currentDate);
        String expected = ("\nSelect an option :\n"
        + "1 : See All Transactions\n"
        + "2 : See Completed Transactions\n"
        + "3 : See Cancelled Transactions\n"
        + "4 : Go Back\n\n"
        + "\n==============================================================\n" 
        + "Transaction Date and Time - "+dateTime+"\n" 
        + "-----------------------------------------------------------\n" 
        + "Item Name\tQuantity\tPrice/ea\tTotal Price\n" 
        + "Water\t2\t\t$2.5\t\t$5.0\t\n" 
        + "-----------------------------------------------------------\n" 
        + "Total Cost\t\t\t\t\t$5.0\n" 
        + "Inputted cash\t5.0\tChange\t0.0\n" 
        + "Transaction Status - Completed\n" 
        + "==============================================================\n"
        + "\nSelect an option :\n"
        + "1 : See All Transactions\n"
        + "2 : See Completed Transactions\n"
        + "3 : See Cancelled Transactions\n"
        + "4 : Go Back\n\n");

        String input = "1" + System.getProperty("line.separator")
                + "4" + System.getProperty("line.separator");
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        StaffSystem s = new StaffSystem();
        s.showSales(transactions);
        System.setIn(in);
        assertEquals(expected, testOut.toString());
    }

    @Test
    public void showSalesOptionsTestCancelled() {
        ArrayList<Transaction> transactions = new ArrayList<>();
        Inventory inv = new Inventory();
        ItemImpl i = (ItemImpl) inv.getItems().get(0);
        Transaction t = new Transaction();
        t.addItem(i, 2);
        t.setInputtedCash(5.0);
        t.setChange(0.0);
        transactions.add(t);

        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String dateTime = formatter.format(currentDate);
        String expected = ("\nSelect an option :\n"
        + "1 : See All Transactions\n"
        + "2 : See Completed Transactions\n"
        + "3 : See Cancelled Transactions\n"
        + "4 : Go Back\n\n"
        + "\n==============================================================\n" 
        + "Transaction Date and Time - "+dateTime+"\n" 
        + "-----------------------------------------------------------\n" 
        + "Item Name\tQuantity\tPrice/ea\tTotal Price\n" 
        + "Water\t2\t\t$2.5\t\t$5.0\t\n" 
        + "-----------------------------------------------------------\n" 
        + "Total Cost\t\t\t\t\t$5.0\n" 
        + "Inputted cash\t5.0\tChange\t0.0\n" 
        + "Transaction Status - Cancelled\n" 
        + "==============================================================\n"
        + "\nSelect an option :\n"
        + "1 : See All Transactions\n"
        + "2 : See Completed Transactions\n"
        + "3 : See Cancelled Transactions\n"
        + "4 : Go Back\n\n");

        String input = "3" + System.getProperty("line.separator")
                + "4" + System.getProperty("line.separator");
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        StaffSystem s = new StaffSystem();
        s.showSales(transactions);
        System.setIn(in);
        assertEquals(expected, testOut.toString());
    }

    @Test
    public void showSalesOptionsTestInavlidInput() {
        ArrayList<Transaction> transactions = new ArrayList<>();

        String expected = ("\nSelect an option :\n"
        + "1 : See All Transactions\n"
        + "2 : See Completed Transactions\n"
        + "3 : See Cancelled Transactions\n"
        + "4 : Go Back\n\n"
        + "Invalid Input\n"
        + "\nSelect an option :\n"
        + "1 : See All Transactions\n"
        + "2 : See Completed Transactions\n"
        + "3 : See Cancelled Transactions\n"
        + "4 : Go Back\n\n");

        String input = "5" + System.getProperty("line.separator")
                + "4" + System.getProperty("line.separator");
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        StaffSystem s = new StaffSystem();
        s.showSales(transactions);
        System.setIn(in);
        assertEquals(expected, testOut.toString());
    }
    
    @After
    public void restoreSystemInputOutput() {
        // System.setIn(systemIn);
        System.setOut(systemOut);
    }
}
