import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StaffTest {
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
    
    @After
    public void restoreSystemInputOutput() {
        // System.setIn(systemIn);
        System.setOut(systemOut);
    }
}
