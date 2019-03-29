import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

import models.Account;

public class BasicTest extends UnitTest {
	
	// This function will first in this test
	@Before
    public void setup() {
		// Clear the database
        Fixtures.deleteDatabase();
    }
	
	
    @Test
    public void createAndRetrieveAccount() {
    	// Create an account
    	Account a = new Account(12345, false);
    	
    	// Save to the database
    	a.save();
		
		// Find the account with "accountNumber=12345"
    	Account acc = Account.find("byAccountNumber", 12345).first();
    	
    	// Check that the account exists 
		assertNotNull(acc);
		
		// Check if the account number of found account matches with 12345
    	assertEquals((Integer)12345, acc.getAccountNumber());
    }
    
    @Test
    public void createAndRetrieveCustomer() {
		// Create and save an account
		Account a = new Account(678, false).save();

		// Create and save a customer
    	new Customer(a, 1, "NoName").save();
		
		// Find the customer with "customerNumber=1"
    	Customer cust = Customer.find("byCustomerNumber", 1).first();
		
		// Check that the customer exists
		assertNotNull(cust);
		
		// Check if the account of found customer is same as the account created above
		assertEquals(cust.getAccount().getAccountNumber(), (Integer)678);

		// Check if the customer number of found customer matches with 1
		assertEquals(cust.getCustomerNumber(), (Integer)1);

		// Check if the customer name of found customer matches with "NoName"
		assertEquals(cust.getCustomerName(), "NoName");
    }
}
