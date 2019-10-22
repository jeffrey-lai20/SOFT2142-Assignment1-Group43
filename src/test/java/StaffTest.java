import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;

public class StaffTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    // @Before
    // public void setUp() {
    // }
    
    // @After
    // public void restoreStreams() {
    // }
    
    @Test
    public void loginSuccess() {
        System.setOut(originalOut);
        System.setOut(new PrintStream(outContent));
        StaffSystem s = new StaffSystem();
        s.loginScreen();
        String input = "staff";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        input = "st@ff";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(false, s.staffLoggedIn());
    }
}