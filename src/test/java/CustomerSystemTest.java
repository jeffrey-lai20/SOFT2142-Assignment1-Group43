import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomerSystemTest {
	// private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	// private final PrintStream originalOut = System.out;

	// @Before
	// public void setUpStreams() {
	// 	System.setOut(new PrintStream(outContent));
	// }

	// @After
	// public void restoreStreams() {
	// 	System.setOut(originalOut);
	// }

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
				"Water: 10\n" +
				"Soft Drink: 10\n" +
				"Juice: 10\n" +
				"\n" +
				"Chocolates - \n" +
				"M&M: 10\n" +
				"Bounty: 10\n" +
				"Mars: 10\n" +
				"Snickers: 10\n" +
				"\n" +
				"Chips - \n" +
				"Original: 10\n" +
				"Chicken: 10\n" +
				"BBQ: 10\n" +
				"Sweet Chilly: 10\n" +
				"\n" +
				"Lollies - \n" +
				"Sour Worms: 10\n" +
				"Jellybeans: 10\n" +
				"Little Bears: 10\n" +
				"Party Mix: 10\n\n"
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
				"Water: "+items.get(0).getQuantity()+"\n" +
				"Soft Drink: "+items.get(1).getQuantity()+"\n" +
				"Juice: "+items.get(2).getQuantity()+"\n\n" +

				"Chocolates - \n" +
				"M&M: "+items.get(3).getQuantity()+"\n" +
				"Bounty: "+items.get(4).getQuantity()+"\n" +
				"Mars: "+items.get(5).getQuantity()+"\n" +
				"Snickers: "+items.get(6).getQuantity()+"\n\n" +

				"Chips - \n" +
				"Original: "+items.get(7).getQuantity()+"\n" +
				"Chicken: "+items.get(8).getQuantity()+"\n" +
				"BBQ: "+items.get(9).getQuantity()+"\n" +
				"Sweet Chilly: "+items.get(10).getQuantity()+"\n\n" +

				"Lollies - \n" +
				"Sour Worms: "+items.get(11).getQuantity()+"\n" +
				"Jellybeans: "+items.get(12).getQuantity()+"\n" +
				"Little Bears: "+items.get(13).getQuantity()+"\n" +
				"Party Mix: "+items.get(14).getQuantity()+"\n\n"
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
		String test1 = "Transaction cancelled, have a good day!";

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
		String test1 = "Transaction cancelled. Have a good day!";

		customerSystem.confirmation(2,"Water",3);
		assertEquals(test1, testOut.toString());
	}

}