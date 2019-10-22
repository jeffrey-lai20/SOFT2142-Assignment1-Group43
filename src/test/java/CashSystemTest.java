import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
public class CashSystemTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void OutputText(){
        CashSystem testCashSystem = new CashSystem();
        testCashSystem.cashChoiceText();
        String test = ("\nPlease choose the note or coin value,\n" +
                "Followed by the amount of that value after a space:\n"+
                "(E.g. 1 10 = $200 inputted )\n"+
                "    1. $20 note\n"+
                "    2. $10 note\n"+
                "    3.  $5 note\n"+
                "    4.  $2 coin\n"+
                "    5.  $1 coin\n"+
                "    6. 50c coin\n"+
                "    7. 20c coin\n"+
                "    8. 10c coin\n"+
                "    9. Cancel Transaction\n"
                );
        assertEquals(test,outContent.toString());
    }
    @Test
    public void cashInputTest() {
        String test = ("\nPlease choose the note or coin value,\n" +
                "Followed by the amount of that value after a space:\n"+
                "(E.g. 1 10 = $200 inputted )\n"+
                "    1. $20 note\n"+
                "    2. $10 note\n"+
                "    3.  $5 note\n"+
                "    4.  $2 coin\n"+
                "    5.  $1 coin\n"+
                "    6. 50c coin\n"+
                "    7. 20c coin\n"+
                "    8. 10c coin\n"+
                "    9. Cancel Transaction\n"+
                "Transaction canceled.See you next time!\n"
        );
        String input = "9";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CashSystem testCashSystem = new CashSystem();
        testCashSystem.cashInput(100);
        assertEquals(test, outContent.toString());
    }
    @Test
    public void cashInputTest2() {
        String test = ("\nPlease choose the note or coin value,\n" +
                "Followed by the amount of that value after a space:\n"+
                "(E.g. 1 10 = $200 inputted )\n"+
                "    1. $20 note\n"+
                "    2. $10 note\n"+
                "    3.  $5 note\n"+
                "    4.  $2 coin\n"+
                "    5.  $1 coin\n"+
                "    6. 50c coin\n"+
                "    7. 20c coin\n"+
                "    8. 10c coin\n"+
                "    9. Cancel Transaction\n"+
                "Please collect your change: $0.0\n"
        );
        String input = "1 5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CashSystem testCashSystem = new CashSystem();
        testCashSystem.cashInput(100);
        assertEquals(test, outContent.toString());
    }
    @Test
    public void cashInputTest3() {
        String test = ("\nPlease choose the note or coin value,\n" +
                "Followed by the amount of that value after a space:\n" +
                "(E.g. 1 10 = $200 inputted )\n" +
                "    1. $20 note\n" +
                "    2. $10 note\n" +
                "    3.  $5 note\n" +
                "    4.  $2 coin\n" +
                "    5.  $1 coin\n" +
                "    6. 50c coin\n" +
                "    7. 20c coin\n" +
                "    8. 10c coin\n" +
                "    9. Cancel Transaction\n" +
                "Total inputted cash value:80.0\n" +
                "Remaining value:20.0\n" +
                "\nPlease choose the note or coin value,\n" +
                "Followed by the amount of that value after a space:\n"+
                "(E.g. 1 10 = $200 inputted )\n"+
                "    1. $20 note\n"+
                "    2. $10 note\n"+
                "    3.  $5 note\n"+
                "    4.  $2 coin\n"+
                "    5.  $1 coin\n"+
                "    6. 50c coin\n"+
                "    7. 20c coin\n"+
                "    8. 10c coin\n"+
                "    9. Cancel Transaction\n"+
                "Please collect your change: $0.0\n"
        );
        String simulatedUserInput = "1 4" + System.getProperty("line.separator")
                + "1 1" + System.getProperty("line.separator");
        InputStream savedStandardInputStream = System.in;
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        CashSystem testCashSystem = new CashSystem();
        testCashSystem.cashInput(100);
        System.setIn(savedStandardInputStream);
        assertEquals(test, outContent.toString());
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

        assertEquals(testCashSystem.inputChecker("1 1").size(),testList.size());
        assertEquals(testCashSystem.inputChecker("a a").size(),testList.size());

    }
    @Test
    public void cashHandlerTest(){
        CashSystem testSystem = new CashSystem();
        List<Integer> testList = new ArrayList<>();
        testList.add(2);
        testList.add(2);
        assertEquals(testSystem.cashHandler(testList),20,0.0);
        testList = new ArrayList<>();
        testList.add(3);
        testList.add(2);
        assertEquals(testSystem.cashHandler(testList),10,0.0);
        testList = new ArrayList<>();
        testList.add(4);
        testList.add(2);
        assertEquals(testSystem.cashHandler(testList),4,0.0);
        testList = new ArrayList<>();
        testList.add(5);
        testList.add(2);
        assertEquals(testSystem.cashHandler(testList),2,0.0);
        testList = new ArrayList<>();
        testList.add(6);
        testList.add(2);
        assertEquals(testSystem.cashHandler(testList),1,0.0);
        testList = new ArrayList<>();
        testList.add(7);
        testList.add(2);
        assertEquals(testSystem.cashHandler(testList),0.4,0.0);
        testList = new ArrayList<>();
        testList.add(8);
        testList.add(2);
        assertEquals(testSystem.cashHandler(testList),0.2,0.0);
        testList = new ArrayList<>();
        testList.add(9);
        testList.add(2);
        assertEquals(testSystem.cashHandler(testList),-1,0.0);
        testList = new ArrayList<>();
        testList.add(200);
        testList.add(2);
        assertEquals(testSystem.cashHandler(testList),0,0.0);
    }
}
