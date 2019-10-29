import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.Assertion;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;


public class CustomerSystemTest {

	@Rule
	public final ExpectedSystemExit exit = ExpectedSystemExit.none();

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
    }
	/**
	 * Basic test to check avaliable items
	 */

	@Test
	public void itemAvaliableTest1() {
		Inventory i = new Inventory();
		Driver testCustomerSystem = new Driver();
		CustomerSystem customerSystem = new CustomerSystem(i.getItems());
		customerSystem.itemsAvaliable();
		String test1 = ("Here are our items available: \n" +
				"\n" +
				"Drinks - \n" +
				"A1 - Water: 10\n" +
				"A2 - Soft Drink: 10\n" +
				"A3 - Juice: 10\n" +
				"\n" +
				"Chocolates - \n" +
				"B1 - M&M: 10\n" +
				"B2 - Bounty: 10\n" +
				"B3 - Mars: 10\n" +
				"B4 - Snickers: 10\n" +
				"\n" +
				"Chips - \n" +
				"C1 - Original: 10\n" +
				"C2 - Chicken: 10\n" +
				"C3 - BBQ: 10\n" +
				"C4 - Sweet Chilly: 10\n" +
				"\n" +
				"Lollies - \n" +
				"D1 - Sour Worms: 10\n" +
				"D2 - Jellybeans: 10\n" +
				"D3 - Little Bears: 10\n" +
				"D4 - Party Mix: 10\n\n"
		);

		assertEquals(test1,testOut.toString() );

	}

	@Test
	public void itemAvaliableTest2() {
		Inventory i = new Inventory();
		Driver testCustomerSystem = new Driver();
		CustomerSystem customerSystem = new CustomerSystem(i.getItems());

		ArrayList<Item> items = i.getItems();
		customerSystem.itemsAvaliable();
		String test2 = ("Here are our items available: \n"+"\n"+
				"Drinks - \n" +
				"A1 - Water: "+items.get(0).getQuantity()+"\n" +
				"A2 - Soft Drink: "+items.get(1).getQuantity()+"\n" +
				"A3 - Juice: "+items.get(2).getQuantity()+"\n\n" +

				"Chocolates - \n" +
				"B1 - M&M: "+items.get(3).getQuantity()+"\n" +
				"B2 - Bounty: "+items.get(4).getQuantity()+"\n" +
				"B3 - Mars: "+items.get(5).getQuantity()+"\n" +
				"B4 - Snickers: "+items.get(6).getQuantity()+"\n\n" +

				"Chips - \n" +
				"C1 - Original: "+items.get(7).getQuantity()+"\n" +
				"C2 - Chicken: "+items.get(8).getQuantity()+"\n" +
				"C3 - BBQ: "+items.get(9).getQuantity()+"\n" +
				"C4 - Sweet Chilly: "+items.get(10).getQuantity()+"\n\n" +

				"Lollies - \n" +
				"D1 - Sour Worms: "+items.get(11).getQuantity()+"\n" +
				"D2 - Jellybeans: "+items.get(12).getQuantity()+"\n" +
				"D3 - Little Bears: "+items.get(13).getQuantity()+"\n" +
				"D4 - Party Mix: "+items.get(14).getQuantity()+"\n\n"
		);

		assertEquals(test2,testOut.toString());

	}

	@Test
	public void enterItemTest1() {
		Inventory i = new Inventory();
		Driver testCustomerSystem = new Driver();
		CustomerSystem customerSystem = new CustomerSystem(i.getItems());
		String test1 = "Invalid input please try again.\n";

		customerSystem.enterItemChecker("Ice-cream");
		assertEquals(test1, testOut.toString());
	}

	@Test
	public void enterItemTest2() {
		Inventory i = new Inventory();
		Driver testCustomerSystem = new Driver();
		CustomerSystem customerSystem = new CustomerSystem(i.getItems());
		String test1 = "Transaction cancelled, have a good day!\n";

		customerSystem.enterItemChecker("cancel");
		assertEquals(test1, testOut.toString());
	}

	@Test
	public void enterQuantityTest1() {
		Inventory i = new Inventory();
		Driver testCustomerSystem = new Driver();
		CustomerSystem customerSystem = new CustomerSystem(i.getItems());
		String test1 = "Quantity must be at least 1 and less than availability. Please try again.\n";

		customerSystem.enterQuantityChecker(0,"Water");
		assertEquals(test1, testOut.toString());
	}

	@Test
	public void enterQuantityTest2() {
		Inventory i = new Inventory();
		Driver testCustomerSystem = new Driver();
		CustomerSystem customerSystem = new CustomerSystem(i.getItems());
		String test1 = "Quantity must be at least 1 and less than availability. Please try again.\n";

		customerSystem.enterQuantityChecker(-10,"Water");
		assertEquals(test1, testOut.toString());
	}

	@Test
	public void enterQuantityTest3() {
		Inventory i = new Inventory();
		Driver testCustomerSystem = new Driver();
		CustomerSystem customerSystem = new CustomerSystem(i.getItems());
		String test1 = "Quantity requested exceeds stock quantity. Please try again.\n";

		customerSystem.enterQuantityChecker(20,"Water");
		assertEquals(test1, testOut.toString());
	}

	@Test
	public void confirmationTest1() {
		Inventory i = new Inventory();
		Driver testCustomerSystem = new Driver();
		CustomerSystem customerSystem = new CustomerSystem(i.getItems());
		String test1 = "Invalid input please try again.\n";

		customerSystem.confirmation(2,"Water",5);
		assertEquals(test1, testOut.toString());
	}

	@Test
	public void confirmationTest2() {
		Inventory i = new Inventory();
		Driver testCustomerSystem = new Driver();
		CustomerSystem customerSystem = new CustomerSystem(i.getItems());
		String test1 = "Transaction cancelled. Have a good day!\n";

		customerSystem.confirmation(2,"Water",3);
		assertEquals(test1, testOut.toString());
	}
//	@Test
//	public void systemExitWithSelectedStatusCode0() {
//		//for system.exit(0) tests
//		exit.expectSystemExitWithStatus(0);
//		Inventory i = new Inventory();
//		CustomerSystem customerSystem = new CustomerSystem(i.getItems());
//		//customerSystem.testExit();
//	}

}