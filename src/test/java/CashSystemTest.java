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
public class CashSystemTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }
       
    @After
    public void restoreStreams() {
        System.setOut(systemOut);
        System.setIn(systemIn);
    }
    
    @Test
    public void OutputText(){
        CashSystem testCashSystem = new CashSystem();
        testCashSystem.cashChoiceText();
        String test = "\nPlease enter the amount of cash to be inputted:\n";
        assertEquals(test, testOut.toString());
    }


    @Test
    public void cashInputTest() {
        String test = (
                "\nThe total cost is : $100.0\nPlease enter the amount of cash to be inputted:\n" +
                        "Total inputted cash value:9.0\n" +
                        "Remaining value:91.0\n" +
                        "Please enter the amount of cash to be inputted:\n"+
                "Thank you for purchasing !\n"+
                "Please collect your change: $0.0 and receipt.\n"
        );
        String input = "9" + System.getProperty("line.separator")
                + "91" + System.getProperty("line.separator");
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CashSystem testCashSystem = new CashSystem();
        testCashSystem.cashInput(100);
        System.setIn(in);
        assertEquals(test, testOut.toString());
    }


    @Test
    public void cashInputTest2() {
        String test = (
                "\nThe total cost is : $100.0\nPlease enter the amount of cash to be inputted:\n" +
                "Thank you for purchasing !\n"+
                "Please collect your change: $10.0 and receipt.\n"
        );
        String input = "110.0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CashSystem testCashSystem = new CashSystem();
        testCashSystem.cashInput(100);
        assertEquals(test, testOut.toString());
    }

    @Test
    public void cashInputTest3() {
        String test = (
                "\nThe total cost is : $100.0\nPlease enter the amount of cash to be inputted:\n" +
                "Thank you for purchasing !\n"+
                "Please collect your change: $0.0 and receipt.\n"
        );
        String simulatedUserInput = "100";
        InputStream savedStandardInputStream = System.in;
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        CashSystem testCashSystem = new CashSystem();
        testCashSystem.cashInput(100);
        System.setIn(savedStandardInputStream);
        assertEquals(test, testOut.toString());
    }
    @Test
    public void cashInputTest4() {
        String test = (
                "\nThe total cost is : $100.0\nPlease enter the amount of cash to be inputted:\n" +
                        "Transaction cancelled. See you next time!\n"
        );
        String input = "cancel";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CashSystem testCashSystem = new CashSystem();
        testCashSystem.cashInput(100);
        assertEquals(test, testOut.toString());
    }

    @Test
    public void cashInputTest5() {
        String test = (
                "\nThe total cost is : $100.0\nPlease enter the amount of cash to be inputted:\n" +
                        "Error input please check again.\n" +
                        "Please make sure only input number.\n" +
                        "Total inputted cash value:0.0\n" +
                        "Remaining value:100.0\n" +
                        "Please enter the amount of cash to be inputted:\n"+
                        "Thank you for purchasing !\n"+
                        "Please collect your change: $0.0 and receipt.\n"
        );
        String input = "e" + System.getProperty("line.separator")
                + "100" + System.getProperty("line.separator");
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CashSystem testCashSystem = new CashSystem();
        testCashSystem.cashInput(100);
        System.setIn(in);
        assertEquals(test, testOut.toString());
    }
    @Test
    public void changeSystemTest(){
        CashSystem testCashSystem = new CashSystem();
        List<Integer> testList = new ArrayList<Integer>(){{
            add(1);
            add(1);
        }};
        assertEquals(testCashSystem.changeSystem(100,160),60.0,0.0);
        assertEquals(testCashSystem.changeSystem(100,150),50.0,0.0);
        assertEquals(testCashSystem.changeSystem(100,115),15.0,0.0);
        assertEquals(testCashSystem.changeSystem(100,106),6.0,0.0);
        assertEquals(testCashSystem.changeSystem(100,103),3.0,0.0);
        assertEquals(testCashSystem.changeSystem(100,101.5),1.5,0.0);
        assertEquals(testCashSystem.changeSystem(100,100.6),0.6,0.0);
        assertEquals(testCashSystem.changeSystem(100,100.3),0.3,0.0);
        assertEquals(testCashSystem.changeSystem(100,100.1),0.1,0.0);
        assertNotEquals(testCashSystem.changeSystem(100,90),0.1,0.0);
    }

}
