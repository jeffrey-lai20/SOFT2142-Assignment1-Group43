import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CustomerSystemTest {

	/**
	 * Basic test to check avaliable items
	 */

	@Test
	public void itemAvaliableTest1() {
		Driver testCustomerSystem = new Driver();
		CustomerSystem customerSystem = new CustomerSystem();

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
				"Party Mix: 10\n\n" +
		);

		assertEquals(test1, customerSystem.itemsAvaliable(inventory.getItems()));

	}

	@Test
	public void enterItemTest1() {
		Driver testCustomerSystem = new Driver();
		CustomerSystem customerSystem = new CustomerSystem();




	}
}