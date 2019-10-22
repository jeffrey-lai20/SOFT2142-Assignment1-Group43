import org.junit.Assert.*;
import org.junit.Test;

public class CustomerSystemTest {

	/**
	 * Basic test to check avaliable items
	 */

	@Test
	public void itemAvaliableTest1() {
		Inventory i = new Inventory();
		Driver testCustomerSystem = new Driver();
		CustomerSystem customerSystem = new CustomerSystem(i.getItems());

		String test1 = ("Here are our items avaliable: \n" +
			"Drinks - \n" +
				"Water: 10\n" +
				"Soft Drink: 10\n" +
				"Juice: 10\n\n" +

			"Chocolates - \n" +
				"M&M: 10\n" +
				"Bounty: 10\n" +
				"Mars: 10\n" +
				"Snickers: 10\n\n" +

			"Chips - \n" +
				"Original: 10\n" +
				"Chicken: 10\n" +
				"BBQ: 10\n" +
				"Sweet Chilly: 10\n\n" +

			"Lollies - \n" +
				"Sour Worms: 10\n" +
				"Jellybeans: 10\n" +
				"Little Bears: 10\n" +
				"Party Mix: 10\n\n"
		);

		assertEquals(test1, customerSystem.itemsAvaliable());

	}

	@Test
	public void itemAvaliableTest1() {
		Inventory i = new Inventory();
		Driver testCustomerSystem = new Driver();
		CustomerSystem customerSystem = new CustomerSystem(i.getItems());

		ArrayList<Item> items = i.getItems();

		String test2 = ("Here are our items avaliable: \n" +
				"Drinks - \n" +
				"Water: "+items.get(0).getQuantity+"\n" +
				"Soft Drink: "+items.get(1).getQuantity+"\n" +
				"Juice: "+items.get(2).getQuantity+"\n\n" +

				"Chocolates - \n" +
				"M&M: "+items.get(3).getQuantity+"\n" +
				"Bounty: "+items.get(4).getQuantity+"\n" +
				"Mars: "+items.get(5).getQuantity+"\n" +
				"Snickers: "+items.get(6).getQuantity+"\n\n" +

				"Chips - \n" +
				"Original: "+items.get(7).getQuantity+"\n" +
				"Chicken: "+items.get(8).getQuantity+"\n" +
				"BBQ: "+items.get(9).getQuantity+"\n" +
				"Sweet Chilly: "+items.get(10).getQuantity+"\n\n" +

				"Lollies - \n" +
				"Sour Worms: "+items.get(11).getQuantity+"\n" +
				"Jellybeans: "+items.get(12).getQuantity+"\n" +
				"Little Bears: "+items.get(13).getQuantity+"\n" +
				"Party Mix: "+items.get(14).getQuantity+"\n\n" +
		);

		assertEquals(test2, customerSystem.itemsAvaliable());

	}

	@Test
	public void enterItemTest1() {
		Inventory i = new Inventory();
		Driver testCustomerSystem = new Driver();
		CustomerSystem customerSystem = new CustomerSystem(i.getItems);

		assertEquals("Invalid input.", customerSystem.enterItem());
	}

	@Test
	public void enterQuantityTest1() {
		Inventory i = new Inventory();
		Driver testCustomerSystem = new Driver();
		CustomerSystem customerSystem = new CustomerSystem(i.getItems);

		assertEquals("Invalid quantity input.", customerSystem.enterQuantity(-10, "Water"));
	}

	@Test
	public void enterQuantityTest1() {
		Inventory i = new Inventory();
		Driver testCustomerSystem = new Driver();
		CustomerSystem customerSystem = new CustomerSystem(i.getItems);

		assertEquals("Quantity requested exceeds stock quantity.", customerSystem.enterQuantity(20, "Water"));
	}


}